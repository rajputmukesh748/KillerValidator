package com.mukesh.killervalidator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.killervalidator.annotationClasses.*
import com.killervalidator.killerValidator.KillerValidator
import com.killervalidator.models.ErrorTypes
import com.killervalidator.models.ValidatorModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        KillerValidator.isValid(dataClass = ValidatorData()) {
            if (it.isNotEmpty()) {
                it.errorHandling()
            } else {
                //All validations are valid
            }
        }
    }


    /**
     * Check Error Handler
     * */
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

}


/**
 * Validator Data Class
 * */
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
