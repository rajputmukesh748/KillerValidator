package com.killervalidator.utils

import com.killervalidator.killerValidator.KillerValidator
import com.killervalidator.models.ValidatorModel


/**
 * Add Error Messages
 * */
fun ValidatorModel.addErrorMessage() {
    /**
     * Add Message to Error List
     * */
    KillerValidator.errorList.add(this)
}