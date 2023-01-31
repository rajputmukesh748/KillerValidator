package com.killervalidator.validatorClasses

import com.killervalidator.annotationClasses.ErrorMessage
import com.killervalidator.annotationClasses.MatchField
import com.killervalidator.models.ErrorTypes
import com.killervalidator.models.ValidatorModel
import com.killervalidator.utils.ContextHelper
import com.killervalidator.utils.addErrorMessage
import com.killervalidator.utils.safeCallBlock
import java.lang.reflect.Field

/**
 * Match Field Validator
 * */
class MatchFieldValidator<T>(private val fields: Array<Field>, private val dataClass: T) {

    private val fieldsList by lazy { ArrayList<Pair<String, Pair<String, String>>>() }

    init {
        checkMatchValidator()
    }


    /**
     * Check Match Validator
     * */
    private fun checkMatchValidator() {
        safeCallBlock {
            fields.forEach { field ->
                field.isAccessible = true
                field.getAnnotation(MatchField::class.java)?.let {
                    fieldsList.add(
                        Pair(
                            first = it.key,
                            second = Pair(
                                first = field.get(dataClass)?.toString().orEmpty(),
                                second = field.getMessage()
                            )
                        )
                    )
                }
            }
            if (fields.isNotEmpty()) handleMatchFields()
        }
    }


    /**
     * Handle Match Fields
     * */
    private fun handleMatchFields() {
        safeCallBlock {
            val commonList = fieldsList.map { it.first }.distinct()
            commonList.forEach { commonKey ->
                fieldsList.filter { it.first == commonKey }.let {
                    if (it.map { item -> item.second.first }.distinct().size > 1) {
                        ValidatorModel(
                            errorType = ErrorTypes.MATCH_ERROR,
                            errorMessages = if (it.firstOrNull()?.second?.second.isNullOrEmpty())
                                "${it.firstOrNull()?.first} is not match."
                            else
                                it.first().second.second
                        ).addErrorMessage()
                    }
                }
            }
        }
    }


    /**
     * Get Error Messages
     * */
    private fun Field.getMessage(): String =
        getAnnotation(ErrorMessage::class.java)?.let {
            ContextHelper.getContext()?.getString(it.message).orEmpty()
        }.orEmpty()

}