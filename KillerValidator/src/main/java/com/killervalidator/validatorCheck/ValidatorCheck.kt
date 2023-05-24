package com.killervalidator.validatorCheck

import com.killervalidator.annotationClasses.CustomRegex
import com.killervalidator.annotationClasses.EmailField
import com.killervalidator.annotationClasses.LengthField
import com.killervalidator.annotationClasses.LinkField
import com.killervalidator.annotationClasses.PasswordField
import com.killervalidator.annotationClasses.RequiredField
import com.killervalidator.utils.getErrorMessage
import com.killervalidator.utils.safeCallBlock
import com.killervalidator.validatorClasses.CustomRegexValidator
import com.killervalidator.validatorClasses.EmailValidator
import com.killervalidator.validatorClasses.LengthValidator
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
            customRegexAnnotation()
            checkEmailAnnotation()
            lengthAnnotation()
            linkAnnotation()
            checkPasswordAnnotation()
            checkRequiredAnnotation()
        }
    }


    /**
     * Check Required Annotation
     * */
    private fun checkRequiredAnnotation() {
        field.getAnnotation(RequiredField::class.java)?.let {
            RequiredValidator(
                field = field,
                dataClass = dataClass,
                errorMessage = it.errorKey.getErrorMessage()
            )
        }
    }


    /**
     * Check Email Annotation
     * */
    private fun checkEmailAnnotation() {
        field.getAnnotation(EmailField::class.java)?.let {
            EmailValidator(
                field = field,
                dataClass = dataClass,
                errorMessage = it.errorKey.getErrorMessage()
            )
        }
    }


    /**
     * Check Password Annotation
     * */
    private fun checkPasswordAnnotation() {
        field.getAnnotation(PasswordField::class.java)?.let {
            PasswordValidator(
                field = field,
                dataClass = dataClass,
                errorMessage = it.errorKey.getErrorMessage()
            )
        }
    }


    /**
     * Check Link Annotation
     * */
    private fun linkAnnotation() {
        field.getAnnotation(LinkField::class.java)?.let {
            LinkValidator(
                field = field,
                dataClass = dataClass,
                errorMessage = it.errorKey.getErrorMessage()
            )
        }
    }


    /**
     * Check Length Annotation
     * */
    private fun lengthAnnotation() {
        field.getAnnotation(LengthField::class.java)?.let {
            LengthValidator(
                lengthField = it,
                field = field,
                dataClass = dataClass,
                errorMessage = it.errorKey.getErrorMessage()
            )
        }
    }


    /**
     * Custom Regex Annotation
     * */
    private fun customRegexAnnotation() {
        field.getAnnotation(CustomRegex::class.java)?.let {
            CustomRegexValidator(
                annotation = it,
                field = field,
                dataClass = dataClass,
                errorMessage = it.errorKey.getErrorMessage()
            )
        }
    }

}