package com.killervalidator.validatorClasses

import android.text.TextUtils
import com.killervalidator.models.ErrorTypes
import com.killervalidator.models.ValidatorModel
import com.killervalidator.utils.addErrorMessage
import com.killervalidator.utils.safeCallBlock
import java.lang.reflect.Field

/**
 * Required Validator
 * */
class RequiredValidator<T>(val field: Field, val dataClass: T, val errorMessage: String?) {

    init {
        checkRequired()
    }


    /**
     * Check Required
     * */
    private fun checkRequired() {
        safeCallBlock {
            field.isAccessible = true
            val value: String = field.get(dataClass)?.toString().orEmpty().trim()
            if (value.isEmpty()) {
                ValidatorModel(
                    errorType = ErrorTypes.REQUITED_ERROR,
                    errorMessages = if (errorMessage.isNullOrEmpty()) "${field.name} is required." else errorMessage
                ).addErrorMessage()
            }
        }
    }

}