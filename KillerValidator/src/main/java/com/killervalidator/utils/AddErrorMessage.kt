package com.killervalidator.utils

import com.killervalidator.killerValidator.KillerValidator
import com.killervalidator.models.ErrorTypes
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


/**
 * Add Error Messages
 * */
fun String.addErrorModel(errorTypes: ErrorTypes) {
    ValidatorModel(
        errorType = errorTypes,
        errorMessages = this
    ).addErrorMessage()
}


/**
 * Get Error Message
 * */
fun String?.getErrorMessage(): String? {
    if (this.isNullOrEmpty()) return null
    return ContextHelper.getContext()?.let {
        return try {
            val stringRes =
                it.resources?.getIdentifier(this, "string", it.packageName) ?: throw Exception()
            it.getString(stringRes)
        } catch (e: Exception) {
            null
        }
    } ?: run { null }
}