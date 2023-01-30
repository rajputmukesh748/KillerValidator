package com.killervalidator.validatorCheck

import com.killervalidator.annotationClasses.Required
import com.killervalidator.validatorClasses.RequiredValidator
import java.lang.reflect.Field

object ValidatorCheck {

    inline fun <reified T> check(field: Field, dataClass: T) {
        /**
         * Check Required Or Not
         * */
        field.getAnnotation(Required::class.java)?.let {
            RequiredValidator(field = field,dataClass = dataClass)
        }
    }

}