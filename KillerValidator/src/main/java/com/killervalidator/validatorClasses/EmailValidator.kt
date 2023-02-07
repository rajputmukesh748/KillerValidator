package com.killervalidator.validatorClasses

import com.killervalidator.models.ErrorTypes
import com.killervalidator.utils.ConstantValues
import com.killervalidator.utils.addErrorModel
import com.killervalidator.utils.safeCallBlock
import java.lang.reflect.Field
import java.util.regex.Pattern

/**
 * Email Validator
 * */
class EmailValidator<T>(val field: Field, val dataClass: T, val errorMessage: String?) {

    init {
        checkEmail()
    }


    /***
     * Check Email
     */
    private fun checkEmail() {
        safeCallBlock {
            field.isAccessible = true
            val value = field.get(dataClass)?.toString().orEmpty().trim()
            if (value.isEmpty()) {
                "${field.name} is not allowed to be empty.".addErrorModel(errorTypes = ErrorTypes.EMAIL_ERROR)
            } else if (value.isNotValidEmail()) {
                (if (errorMessage.isNullOrEmpty()) "${field.name} is not a valid email address." else errorMessage).addErrorModel(
                    ErrorTypes.EMAIL_ERROR
                )
            }
        }
    }


    /**
     * Check Is Valid Email Or Not
     * */
    private fun String.isNotValidEmail(): Boolean = !Pattern.matches(ConstantValues.EMAIL_REGEX, this)

}