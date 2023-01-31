package com.killervalidator.annotationClasses

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Repeatable
annotation class ErrorMessage(val message: String)
