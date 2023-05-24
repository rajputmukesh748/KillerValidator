package com.killervalidator.annotationClasses

/**
 * @LinkField field is used to check entered value is valid link or not.
 *
 *
 * Let's Create a data class with EmailField Annotation
 *
 *      data class UserData(
 *         @LinkField
 *         val webUrl: String? = null
 *      )
 *
 * How to check it's valid or not.
 *
 *      val userData = UserData(lengthCheck = "https://rajputSaab.com")
 *      KillerValidator.isValid(dataClass = userData){
 *          //Check if list is empty then its valid else not valid and fetch error message from list.
 *      }
 *
 * */
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class LinkField(val errorKey: String = "")
