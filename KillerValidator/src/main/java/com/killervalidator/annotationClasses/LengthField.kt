package com.killervalidator.annotationClasses

/**
 * @LengthField field is used to check minimum and maximum length.
 * Simply say check value is greater than minimum value and less than maximum value.
 *
 *
 * Let's Create a data class with EmailField Annotation
 *
 *      data class UserData(
 *         @LengthField(minLength = 2, maxLength=20)
 *         val lengthCheck: String? = null
 *      )
 *
 * How to check it's valid or not.
 *
 *      val userData = UserData(lengthCheck = "Mukesh")
 *      KillerValidator.isValid(dataClass = userData){
 *          //Check if list is empty then its valid else not valid and fetch error message from list.
 *      }
 *
 * */
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class LengthField(val minLength: Int, val maxLength: Int)
