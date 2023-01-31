package com.killervalidator.annotationClasses

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class CustomRegex(val regex: String = "")
