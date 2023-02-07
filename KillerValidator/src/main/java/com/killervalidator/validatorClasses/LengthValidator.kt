package com.killervalidator.validatorClasses

import com.killervalidator.annotationClasses.LengthField
import com.killervalidator.models.ErrorTypes
import com.killervalidator.utils.addErrorModel
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
            field.isAccessible = true
            val value = field.get(dataClass)?.toString().orEmpty().trim()
            val isMinimum = value.isMinLength(lengthField.minLength)
            val isMaximum = value.isMaxLength(lengthField.maxLength)
            if (value.isEmpty()) {
                "${field.name} is not allowed to be empty.".addErrorModel(ErrorTypes.LENGTH_ERROR)
            } else if (isMinimum || isMaximum) {
                (if (errorMessage.isNullOrEmpty()) "${field.name} min ${lengthField.minLength} and max ${lengthField.maxLength} character allowed." else errorMessage).addErrorModel(
                    errorTypes = ErrorTypes.LENGTH_ERROR
                )
            }
        }
    }


    /**
     * Check Minimum Length
     * */
    private fun String.isMinLength(minLength: Int) = this.trim().length < minLength


    /**
     * Check Maximum Length
     * */
    private fun String.isMaxLength(maxLength: Int) = this.trim().length > maxLength

}