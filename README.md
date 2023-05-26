# KillerValidator

<h5>Hi Developers,</h5>
<p>This library used for check any type of validations in Kotlin without write any extra code. Just simply create a data class and apply any annotation according to your requirements.</p>
<p>Hope this library will game changer in android development validations. Now no need to add extra code for validations only apply annotation's and check with the help of 2 lines of code.</p>

<h2>Features Available</h2>
<ol>
  <li>Required validation (Check field is empty or not.)</li>
  <li>Email validation</li>
  <li>Length check validation (Minimum and Maximum Length)</li>
  <li>Link validation</li>
  <li>Password validation</li>
  <li>Match multiple fields validation</li>
  <li>Custom Regex check validation</li>
 </ol>


<h2>Available Annotations</h2>
<ol>
  <li><h4>@RequiredField</h4></li>
  <p>Required annotation check if variable is empty or not. If value is null then it will also return error message.</p>
  <li><h4>@EmailField</h4></li>
  <p>EmailField annotation is used to check its valid email address or not.</p>
  <li><h4>@CustomRegex("{ANY REGEX VALUE}")</h4></li>
  <p>If you want to validate custom regex then this will possible with the help of CustomRegex annotation.</p>
  <li><h4>@LengthField(minLength = 2, maxLength = 20)</h4></li>
  <p>LengthField is used to check minimum and maximum length of any variable.</p>
  <li><h4>@LinkField</h4></li>
  <p>LinkField is used to check url or link is valid or not. Https, Http or ftp any type of link check with the help of this annotation.</p>
  <li><h4>@PasswordField</h4></li>
  <p>PasswordField is used to check its valid password or not. In this validation user need to add One Capital Character, One Small Character, One Special Character, One Numeric character and length must be greater than 7.</p>
  <li><h4>@MatchField("uniqueType")</h4></li>
  <p>MatchField is used to check values more than two fields. If you want to match variable values then you can pass same key on both variables. Also refer data class below attached example.</p>
 </ol>

 <h2> How to used validator classes in app. </h2>

<h3>How to integrate into your app?</h3>
&nbsp;&nbsp;Step 1. Add the JitPack repository to your build file. Add it in your root build.gradle
at the end of repositories:

    allprojects {
		  repositories {
		  	...
		  	maven { url 'https://jitpack.io' }
		  }
	  }

Step 2. Add the dependency

    dependencies {
	        implementation 'com.github.rajputmukesh748:KillerValidator:1.3.0'
	  }

<br>
<h2>Source Code</h2>

<h4>1. Initialized validator classes in application class.</h4>

      class ApplicationClass: Application() {
          override fun onCreate() {
            super.onCreate()
            KillerValidator.initialize(context = applicationContext)
         }
      }

<h4>2. Add application class in manifest file.</h4>

     <application
            android:name=".ApplicationClass"
            />

<h4>3. What is errorKey in annotations parameter.</h4>
<p>It's used for provide custom error messages to user.</p>
<p>ErrorKey annotation is user in every annotation but its optional. If developer not provide this
key then in-build error message will return. If developer provide "errorKey" is any annotation and
provide string file key in that, then it will return a user error message.</p>

    1. Firstly declare error message in `string.xml` file
        <string name="not_valid_email_address">Please enter valid email address.</string>

    2. Now provide string key into any errorKey in any annotation. Please refer below syntax.
            data class Login(
                @EmailField(errorKey = "not_valid_email_address")
                var email: String? = null
            )

    3. `not_valid_email_address` is a key that declare in `string.xml` file.


<h4>4. How to apply validation's in data class.</h4>

        data class ValidatorData( 
            @RequiredField(errorKey = "empty_name")
            val name: String? = null,
        
            @RequiredField(errorKey = "empty_email")
            @EmailField(errorKey = "email_address")
            val emailAddress: String? = null,
        
            @RequiredField(errorKey = "custom_regex_valid")
            @CustomRegex(regex = "{ANY REGEX VALUE}", errorKey = "custom_regex_valid")
            val customRegex: String? = null,
        
            @RequiredField(errorKey = "not_empty")
            @LengthField(minLength = 2, maxLength = 20, errorKey = "length_error_message")
            val checkLength: String? = null,
        
            @RequiredField(errorKey = "empty_url")
            @LinkField(errorKey = "not_valid_url")
            val urlLink: String? = null,
        
            @RequiredField(errorKey = "empty_password")
            @PasswordField(errorKey = "not_valid_password")
            val password: String? = null,
        
            //Apply Same key and automatically match all same keys
            @RequiredField(errorKey = "empty_email")
            @MatchField(key = "email", errorKey = "not_valid_email")
            val reEnterEmail: String? = null,
        
            @RequiredField("empty_confirm_email")
            @MatchField(key = "email", errorKey = "not_valid_email")
            val confirmEmail: String? = null,
        
            //Apply Same key and automatically match all same keys
            @RequiredField(errorKey = "empty_value")
            @MatchField(key = "checkValues", errorKey = "value_not_match")
            val value1: String? = null,
        
            @RequiredField(errorKey = "empty_value")
            @MatchField(key = "checkValues", errorKey = "value_not_match")
            val value2: String? = null,
        
            @RequiredField(errorKey = "empty_value")
            @MatchField(key = "checkValues", errorKey = "value_not_match")
            val value3: String? = null
         )

<h4>5. How to check data class all validation are valid or not.</h4>

      KillerValidator.isValid(dataClass = ValidatorData()) {
            if (it.isNotEmpty()) {
                it.errorHandling()
            } else {
                //All validations are valid
            }
        }

<h4>6. Get error messages and also check error type.</h4>

     private fun ArrayList<ValidatorModel>.errorHandling() {
          println(map { it.errorMessages })

          //Check which type of error
          forEach {
              when (it.errorType) {
                  ErrorTypes.REQUITED_ERROR -> {
                      "TODO WORK"
                  }
                  else -> ""
              }
          }
      }

<b><h3>Thanks for your support. Please try and support it.</h3></b>
