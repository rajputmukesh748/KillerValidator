package com.killervalidator.validatorClasses

import com.killervalidator.annotationClasses.LengthField
import com.killervalidator.utils.safeCallBlock
import java.lang.reflect.Field

class LengthValidator<T>(
    private val lengthField: LengthField,
    private val field: Field,
    private val dataClass: T,
    private val errorMessage: String?
) {

    init {
        checkLength()
    }

    private fun checkLength() {
        safeCallBlock {
            val value = field.get(dataClass)?.toString().orEmpty().trim()
            val isMinimum = value.isMinLength(lengthField.minLength)
            val isMaximum = value.isMinLength(lengthField.maxLength)

        }
    }


    private fun String.isMinLength(minLength: Int) = this.trim().length < minLength


    private fun String.isMaxLength(maxLength: Int) = this.trim().length > maxLength

}