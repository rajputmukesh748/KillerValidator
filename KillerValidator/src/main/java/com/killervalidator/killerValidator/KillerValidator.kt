package com.killervalidator.killerValidator

import com.killervalidator.models.ValidatorModel
import com.killervalidator.utils.safeCallBlock
import com.killervalidator.validatorCheck.ValidatorCheck

/**
 * Killer Validator
 * */
object KillerValidator {


    /**
     * Error Messages Lists
     * */
    val errorList by lazy { ArrayList<ValidatorModel>() }

    /**
     * Killer Callback
     * */
    var killerCallback: KillerCallback? = null


    /**
     * Is Valid Check
     * */
    inline fun <reified T> isValid(dataClass: T, killerCallback: KillerCallback) {
        safeCallBlock {
            this.killerCallback = killerCallback
            errorList.clear()
            val fields = T::class.java.declaredFields
            fields.forEach { field ->
                ValidatorCheck(field = field, dataClass = dataClass)
            }
            killerCallback.callback(errorList)
        }
    }

}