package com.killervalidator.annotationClasses


/**
 * @PasswordField field is used to check its valid password or not.
 * Its contain password regex like
 * 1. At least contain one capital character.
 * 2. At least one small character.
 * 3. At least one special character
 * 4. At least one numeric character.
 * 5. At least 8 character.
 *
 * For Example:-
 * Here are one simple password example:- Abc@1234
 *
 *
 * Let's Create a data class with Password Field Annotation
 *
 *      data class UserData(
 *         @PasswordField
 *         val password: String? = null
 *      )
 *
 * How to check it's valid or not.
 *
 *      val userData = UserData(password = "Abc@1234")
 *      KillerValidator.isValid(dataClass = userData){
 *          //Check if list is empty then its valid else not valid and fetch error message from list.
 *      }
 *
 * */
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class PasswordField(val errorKey: String = "")
