package com.killervalidator.validatorClasses

import com.killervalidator.annotationClasses.CustomRegex
import com.killervalidator.models.ErrorTypes
import com.killervalidator.utils.addErrorModel
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
            if (annotation.regex.isEmpty()) {
                "${field.name} field regex is empty.".addErrorModel(errorTypes = ErrorTypes.REGEX_ERROR)
            } else if (value.isEmpty()) {
                "${field.name} is not allowed to be empty.".addErrorModel(errorTypes = ErrorTypes.REGEX_ERROR)
            } else if (value.isNotValidRegex(annotation.regex)) {
                (if (errorMessage.isNullOrEmpty()) "${field.name} field regex is not match." else errorMessage).addErrorModel(
                    errorTypes = ErrorTypes.REGEX_ERROR
                )
            }
        }
    }


    /**
     * Check Is Valid Regex
     * */
    private fun String.isNotValidRegex(regex: String) = !Pattern.matches(regex, this)

}