package com.killervalidator.annotationClasses

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class LengthField(val minLength: Int, val maxLength: Int)
