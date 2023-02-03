package com.killervalidator.annotationClasses



/**
 * @MatchField field is used match multiple fields values at a same time.
 * Let's suppose you want to compare 2 fields in one data class then you
 * can use match field annotation. You need to pass string value in key.
 *
 * Let's have an example
 * 1. You have to check Password and Confirm password field in data class,
 *    and also you need to check E-Mail, Re-Enter Email
 *    and Confirm E-Mail address in same class.
 * 2. In this case you need to separate both conditions with the help of key.
 *
 * Let's Create a data class with Password Field Annotation
 *
 *      data class UserData(
 *         @MatchField("password)
 *         val password: String? = null,
 *         @MatchField("password)
 *         val confirmPassword: String? = null
 *
 *         @MatchField("email)
 *         val email: String? = null,
 *         @MatchField("email)
 *         val reEnterEmail: String? = null,
 *         @MatchField("email)
 *         val confirmEmail: String? = null
 *      )
 *
 * How to check it's valid or not.
 *
 *      val userData = UserData(
 *          password = "Abc@1234",
 *          confirmPassword = "Abc@1234",
 *          email = "rajputmukesh748@gmail.com",
 *          reEnterEmail = "rajputmukesh748@gmail.com",
 *          confirmEmail = "rajputmukesh748@gmail.com"
 *      )
 *      KillerValidator.isValid(dataClass = userData){
 *          //Check if list is empty then its valid else not valid and fetch error message from list.
 *      }
 *
 * */
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class MatchField(val key: String)
