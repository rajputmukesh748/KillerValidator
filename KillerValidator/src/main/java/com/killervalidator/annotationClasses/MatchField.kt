package com.killervalidator.annotationClasses

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class MatchField(val key: String)
