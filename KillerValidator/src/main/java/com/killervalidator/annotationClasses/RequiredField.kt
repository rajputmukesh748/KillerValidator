package com.killervalidator.annotationClasses


/**
 * @Required annotation is used for require and not be empty or null
 * */
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class RequiredField