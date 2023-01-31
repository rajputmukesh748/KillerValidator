package com.killervalidator.killerValidator

import android.content.Context
import com.killervalidator.models.ValidatorModel
import com.killervalidator.utils.ContextHelper
import com.killervalidator.utils.safeCallBlock
import com.killervalidator.validatorCheck.ValidatorCheck
import com.killervalidator.validatorClasses.MatchFieldValidator

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
     * Initialize
     * */
    fun initialize(context: Context){
        safeCallBlock {
            ContextHelper.setContext(context = context)
        }
    }


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
            MatchFieldValidator(fields, dataClass)
            killerCallback.callback(errorList)
        }
    }

}