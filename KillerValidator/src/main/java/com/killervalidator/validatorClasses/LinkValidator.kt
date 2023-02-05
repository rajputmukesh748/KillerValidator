package com.killervalidator.validatorClasses

import com.killervalidator.models.ErrorTypes
import com.killervalidator.models.ValidatorModel
import com.killervalidator.utils.ConstantValues
import com.killervalidator.utils.addErrorMessage
import com.killervalidator.utils.safeCallBlock
import java.lang.reflect.Field
import java.util.regex.Pattern

class LinkValidator<T>(
    private val field: Field, private val dataClass: T, private val errorMessage: String?
) {

    init {
        checkLinkValidator()
    }


    /**
     * CHeck Link Validator
     * */
    private fun checkLinkValidator() {
        safeCallBlock {
            field.isAccessible = true
            val value = field.get(dataClass)?.toString().orEmpty().trim()
            if (value.isNotValidLink()) {
                ValidatorModel(
                    errorType = ErrorTypes.URL_LINK_ERROR,
                    errorMessages = if (errorMessage.isNullOrEmpty()) "${field.name} is not a valid url." else errorMessage
                ).addErrorMessage()
            }
        }
    }


    /**
     * Check is valid url or not
     * */
    private fun String.isNotValidLink() = !Pattern.matches(ConstantValues.URL_REGEX, this.trim())

}