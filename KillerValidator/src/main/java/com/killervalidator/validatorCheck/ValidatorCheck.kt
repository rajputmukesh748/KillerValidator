package com.killervalidator.validatorCheck

import com.killervalidator.annotationClasses.*
import com.killervalidator.utils.ContextHelper
import com.killervalidator.utils.safeCallBlock
import com.killervalidator.validatorClasses.EmailValidator
import com.killervalidator.validatorClasses.LinkValidator
import com.killervalidator.validatorClasses.PasswordValidator
import com.killervalidator.validatorClasses.RequiredValidator
import java.lang.reflect.Field

class ValidatorCheck<T>(private val field: Field, private val dataClass: T) {

    init {
        check()
    }


    /**
     * Check Annotations Which is Available or Not
     * */
    private fun check() {
        safeCallBlock {
            field.getMessage().apply {
                checkRequiredAnnotation()
                checkEmailAnnotation()
                checkPasswordAnnotation()
                linkAnnotation()
            }

        }
    }


    /**
     * Check Required Annotation
     * */
    private fun String.checkRequiredAnnotation() {
        field.getAnnotation(RequiredField::class.java)?.let {
            RequiredValidator(field = field, dataClass = dataClass, errorMessage = this)
        }
    }


    /**
     * Check Email Annotation
     * */
    private fun String.checkEmailAnnotation() {
        field.getAnnotation(EmailField::class.java)?.let {
            EmailValidator(field = field, dataClass = dataClass, errorMessage = this)
        }
    }


    /**
     * Check Password Annotation
     * */
    private fun String.checkPasswordAnnotation() {
        field.getAnnotation(PasswordField::class.java)?.let {
            PasswordValidator(field = field, dataClass = dataClass, errorMessage = this)
        }
    }


    /**
     * Check Link Annotation
     * */
    private fun String.linkAnnotation() {
        field.getAnnotation(LinkField::class.java)?.let {
            LinkValidator(field = field, dataClass = dataClass, errorMessage = this)
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