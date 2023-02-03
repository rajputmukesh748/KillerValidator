package com.killervalidator.models


/**
 * Validator Model for send
 * ErrorMessage or ErrorType
 * */
data class ValidatorModel(
    val errorMessages: String? = null,
    val errorType: ErrorTypes? = null
)
