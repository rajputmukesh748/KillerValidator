package com.killervalidator.killerValidator

import com.killervalidator.utils.safeCallBlock
import com.killervalidator.validatorCheck.ValidatorCheck

object KillerValidator {

    inline fun <reified T> isValid(dataClass: T){
        safeCallBlock {
            val fields = T::class.java.declaredFields
            fields.forEach {field ->
                ValidatorCheck.check(field, dataClass)
            }
        }
    }

}