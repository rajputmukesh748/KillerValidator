package com.killervalidator.validatorClasses

import android.text.TextUtils
import com.killervalidator.utils.safeCallBlock
import java.lang.reflect.Field

/**
 * Required Validator
 * */
class RequiredValidator<T>(val field: Field, val dataClass: T) {

    init {
        checkRequired()
    }


    /**
     * Check Required
     * */
    private fun checkRequired() {
        safeCallBlock {
            val value: String = field.get(dataClass)?.toString().orEmpty()
            if (TextUtils.isEmpty(value)){
                throw Exception("${field.name} is required.")
            }
        }
    }

}