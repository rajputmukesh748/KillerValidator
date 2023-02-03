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
