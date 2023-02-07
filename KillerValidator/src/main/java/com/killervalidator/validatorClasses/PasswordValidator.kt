package com.killervalidator.validatorClasses

import com.killervalidator.models.ErrorTypes
import com.killervalidator.utils.ConstantValues
import com.killervalidator.utils.addErrorModel
import com.killervalidator.utils.safeCallBlock
import java.lang.reflect.Field
import java.util.regex.Pattern

class PasswordValidator<T>(private val field: Field, private val dataClass: T, private val errorMessage: String?) {

    init {
        checkPassword()
    }


    /**
     * Check Password
     * */
    private fun checkPassword() {
        safeCallBlock {
            field.isAccessible = true
            val value = field.get(dataClass)?.toString().orEmpty().trim()
            if (value.isEmpty()) {
                "${field.name} is not allowed to be empty.".addErrorModel(ErrorTypes.PASSWORD_ERROR)
            } else if (value.isNotValidPassword()) {
                (if (errorMessage.isNullOrEmpty()) "${field.name} length must be greater then 8 character and contain at least one capital character, one small character, one alphanumeric and one special character." else errorMessage).addErrorModel(
                    ErrorTypes.PASSWORD_ERROR
                )
            }
        }
    }


    /**
     * Is Valid Password
     * */
    private fun String.isNotValidPassword(): Boolean = !Pattern.matches(ConstantValues.PASSWORD_REGEX, this)

}