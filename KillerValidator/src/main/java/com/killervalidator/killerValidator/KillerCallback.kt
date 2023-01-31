package com.killervalidator.killerValidator

import com.killervalidator.models.ValidatorModel


/**
 * Killer Callback
 * */
fun interface KillerCallback {

    /**
     * Callback
     * */
    fun callback(list: ArrayList<ValidatorModel>)
}