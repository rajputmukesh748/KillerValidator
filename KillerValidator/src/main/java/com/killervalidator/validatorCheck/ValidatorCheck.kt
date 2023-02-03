package com.killervalidator.validatorCheck

import com.killervalidator.annotationClasses.*
import com.killervalidator.utils.ContextHelper
import com.killervalidator.utils.safeCallBlock
import com.killervalidator.validatorClasses.*
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
                customRegexAnnotation()
                checkEmailAnnotation()
                lengthAnnotation()
                linkAnnotation()
                checkPasswordAnnotation()
                checkRequiredAnnotation()
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
     * Check Length Annotation
     * */
    private fun String.lengthAnnotation() {
        field.getAnnotation(LengthField::class.java)?.let {
            LengthValidator(lengthField = it, field = field, dataClass = dataClass, errorMessage = this)
        }
    }


    /**
     * Custom Regex Annotation
     * */
    private fun String.customRegexAnnotation() {
        field.getAnnotation(CustomRegex::class.java)?.let {
            CustomRegexValidator(annotation = it, field = field, dataClass = dataClass, errorMessage = this)
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