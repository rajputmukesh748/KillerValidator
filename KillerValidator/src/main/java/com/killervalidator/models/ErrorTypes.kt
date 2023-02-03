package com.killervalidator.models


/**
 * Check Which Type Of Error Message
 * */
enum class ErrorTypes {
    /**
     * Required Annotation Error Type
     * */
    REQUITED_ERROR,

    /**
     * Email Annotation Error Type
     * */
    EMAIL_ERROR,

    /**
     * Password Annotation Error Type
     * */
    PASSWORD_ERROR,

    /**
     * Regex Annotation Error Type
     * */
    REGEX_ERROR,

    /**
     * Length Annotation Error Type
     * */
    LENGTH_ERROR,

    /**
     * URL Link Annotation Error Type
     * */
    URL_LINK_ERROR,

    /**
     * Match Error Annotation Error Type
     * */
    MATCH_ERROR
}