package com.killervalidator.killerValidator

import com.killervalidator.models.ValidatorModel


/**
 * Killer Callback
 *
 * It's used for return array list of error messages.
 * Using functional interface and callback function.
 *
 * */
fun interface KillerCallback {

    /**
     * Callback for return a error messages list.
     * */
    fun callback(list: ArrayList<ValidatorModel>)
}