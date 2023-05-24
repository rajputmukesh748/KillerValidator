package com.killervalidator.annotationClasses


/**
 * @EmailField is used for check it's valid email in data class field
 *
 * Example:- Let's have a one example. we need to check data class variable is valid email or not
 *
 * Let's Create a data class with EmailField Annotation
 *
 *      data class UserData(
 *         @EmailField
 *         val email: String? = null
 *      )
 *
 *  Let's Check it`s valid email address with data or not.
 *      val userData = UserData(email = "mukesh@yopmail.com")
 *      KillerValidator.isValid(dataClass = userData){
 *          //Check if list is empty then its valid else not valid and fetch error message from list.
 *      }
 *
 * */
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class EmailField(val errorKey: String = "")
