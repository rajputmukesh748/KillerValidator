package com.killervalidator.annotationClasses

import androidx.annotation.StringRes

/**
 * @ErrorMessage field is used with any annotation.
 * It's basic use is that only provide a custom messages and fetch if validation failed.
 *
 *
 * Let's Create a data class with EmailField Annotation
 *
 *      data class UserData(
 *         @EmailMessage
 *         @ErrorMessage(R.string.error_message)
 *         val email: String? = null
 *      )
 *
 *  If any condition fail then you can fetch custom error messages.
 *      val userData = UserData(email = "mukesh@yopmail.com")
 *      KillerValidator.isValid(dataClass = userData){
 *          //Check if list is empty then its valid else not valid and fetch error message from list.
 *      }
 *
 * */
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Repeatable
annotation class ErrorMessage(@StringRes val message: Int)
