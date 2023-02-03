package com.killervalidator.annotationClasses



/**
 * @RequiredField field is used to check value is empty or not.
 *
 * Let's Create a data class with Password Field Annotation
 *
 *      data class UserData(
 *         @RequiredField
 *         val name: String? = null
 *      )
 *
 * How to check it's valid or not.
 *
 *      val userData = UserData(name = "Mukesh")
 *      KillerValidator.isValid(dataClass = userData){
 *          //Check if list is empty then its valid else not valid and fetch error message from list.
 *      }
 *
 * */
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class RequiredField