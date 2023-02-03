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
    fun initialize(context: Context) {
        safeCallBlock {
            ContextHelper.setContext(context = context)
        }
    }


    /**
     * Check data class all annotation values are valid or not
     *
     * How to use this function for validation check
     *
     *  KillerValidator.isValid(dataClass = ValidatorData()){
     *       if (it.isNotEmpty()){
     *            //For print message
     *            println(it.map { it.errorMessages })
     *
     *            //Check which type of error
     *            it.forEach {
     *                when(it.errorType){
     *                    ErrorTypes.REQUITED_ERROR -> { "TODO WORK" }
     *                    else -> ""
     *                }
     *            }
     *        } else {
     *            //All validations are valid
     *        }
     *    }
     *
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