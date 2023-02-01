package com.killervalidator.annotationClasses

/**
 * @CustomRegex is used for check custom regex in data class
 *
 * Example:- Let's have a one example. we need to check this regex with over field
 * Regex:- `{^(?=.*[0-9])(?=.*[A-Z])(?=.*[@*#$%^&+=!])(?=\S+$).{8,50}$}`
 *
 * Let's Create a data class with CustomRegex Annotation
 *
 *      data class UserData(
 *         @CustomRegex(regex = "{^(?=.*[0-9])(?=.*[A-Z])(?=.*[@*#$%^&+=!])(?=\S+$).{8,50}$}")
 *         val password: String? = null
 *      )
 *
 *  Let's Check it`s valid regex with data or not.
 *      val userData = UserData(password = "Abc@1234")
 *      KillerValidator.isValid(dataClass = userData){
 *          //Check if list is empty then its valid else not valid and fetch error message from list.
 *      }
 *
 * */
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class CustomRegex(val regex: String = "")
