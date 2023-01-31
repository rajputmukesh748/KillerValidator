package com.killervalidator.annotationClasses

import androidx.annotation.StringRes

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Repeatable
annotation class ErrorMessage(@StringRes val message: Int)
