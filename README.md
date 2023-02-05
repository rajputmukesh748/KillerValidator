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
  <p>Required annotation check if variable is empty or not. If value is null then it will also return error.</p>
  <li><h4>@ErrorMessage(R.string.error_message)</h4></li>
  <p>ErrorMessage annotation is not required. They will help you to pass custom error messages. If you are not apply this annotation then it will automatically give error message according to field names.</p>
  <li><h4>@EmailField</h4></li>
  <p>EmailField annotation is used to check it's valid email address or not.</p>
  <li><h4>@CustomRegex("{ANY REGEX VALUE}")</h4></li>
  <p>If you want to validate custom regex then this will possible with the help of CustomRegex annotation.</p>
  <li><h4>@LengthField(minLength = 2, maxLength = 20)</h4></li>
  <p>LengthField is used to check minimum and maximum length of any variable.</p>
  <li><h4>@LinkField</h4></li>
  <p>LinkField is used to check url's or link is valid or not. Https, Http or ftp any type of link check with the help of this annotation.</p>
  <li><h4>@PasswordField</h4></li>
  <p>PasswordField is used to check its valid password or not. In this validation user need to add One Capital Character, One Small Character, One Special Character, One Numeric character and length must be greater then 7.</p>
  <li><h4>@MatchField("uniqueType")</h4></li>
  <p>MatchField is used to check values more then two fields. If you want to match variable values then you can pass same key on both variables. Also refer data class below attached example.</p>
 </ol>
 
 <h2> How to used validator classes in app. </h2>

<h3>How to integrate into your app?</h3>
&nbsp;&nbsp;Step 1. Add the JitPack repository to your build file. Add it in your root build.gradle at the end of repositories:

    allprojects {
		  repositories {
		  	...
		  	maven { url 'https://jitpack.io' }
		  }
	  }
  
 
Step 2. Add the dependency

    dependencies {
	        implementation 'com.github.rajputmukesh748:KillerValidator:1.0.0'
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
            
 
 <h4>3. How to apply validation's in data class.</h4>
     
        data class ValidatorData( 
            @RequiredField
            @ErrorMessage(R.string.empty_name)
            val name: String? = null,

            @RequiredField
            @EmailField
            @ErrorMessage(R.string.email_address)
            val emailAddress: String? = null,

            @RequiredField
            @CustomRegex("{ANY REGEX VALUE}")
            @ErrorMessage(R.string.custom_regex_Error)
            val customRegex: String? = null,

            @RequiredField
            @LengthField(minLength = 2, maxLength = 20)
            @ErrorMessage(R.string.not_valid_length)
            val checkLength: String? = null,

            @RequiredField
            @LinkField
            @ErrorMessage(R.string.not_valid_url)
            val urlLink: String? = null,

            @RequiredField
            @PasswordField
            @ErrorMessage(R.string.not_valid_password)
            val password: String? = null,

            //Apply Same key and automatically match all same keys
            @RequiredField
            @MatchField("email")
            @ErrorMessage(R.string.email_not_match)
            val reEnterEmail: String? = null,

            @RequiredField
            @MatchField("email")
            @ErrorMessage(R.string.email_not_match)
            val confirmEmail: String? = null,

            //Apply Same key and automatically match all same keys
            @RequiredField
            @MatchField("checkValues")
            @ErrorMessage(R.string.value_not_match)
            val value1: String? = null,

            @RequiredField
            @MatchField("checkValues")
            @ErrorMessage(R.string.value_not_match)
            val value2: String? = null,

            @RequiredField
            @MatchField("checkValues")
            @ErrorMessage(R.string.value_not_match)
            val value3: String? = null 
         )
         
          
<h4>4. How to check data class all validation are valid or not.</h4>
      
      
      KillerValidator.isValid(dataClass = ValidatorData()) {
            if (it.isNotEmpty()) {
                it.errorHandling()
            } else {
                //All validations are valid
            }
        }

          
<h4>4. Get error messages and also check error type.</h4>

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
