package com.killervalidator.validatorClasses

import com.killervalidator.annotationClasses.CustomRegex
import com.killervalidator.models.ErrorTypes
import com.killervalidator.models.ValidatorModel
import com.killervalidator.utils.addErrorMessage
import com.killervalidator.utils.safeCallBlock
import java.lang.reflect.Field
import java.util.regex.Pattern

class CustomRegexValidator<T>(
    private val annotation: CustomRegex,
    private val field: Field,
    private val dataClass: T,
    private val errorMessage: String?
) {

    init {
        checkRegex()
    }


    /**
     * Check Regex
     * */
    private fun checkRegex() {
        safeCallBlock {
            field.isAccessible = true
            val value = field.get(dataClass)?.toString().orEmpty().trim()
            if (annotation.regex.isNullOrEmpty()) {
                ValidatorModel(
                    errorType = ErrorTypes.REGEX_ERROR,
                    errorMessages = "${field.name} field regex is empty."
                ).addErrorMessage()
            } else if (value.isNotValidRegex(annotation.regex)) {
                ValidatorModel(
                    errorType = ErrorTypes.REGEX_ERROR,
                    errorMessages = if (errorMessage.isNullOrEmpty()) "${field.name} field regex is not match." else errorMessage
                ).addErrorMessage()
            }
        }
    }


    /**
     * Check Is Valid Regex
     * */
    private fun String.isNotValidRegex(regex: String) = !Pattern.matches(regex, this)

}