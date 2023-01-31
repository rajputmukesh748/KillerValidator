package com.killervalidator.utils

/**
 * Constant Values
 * */
object ConstantValues {

    /** Email Regex */
    const val EMAIL_REGEX =
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+"

    /** Password Regex */
    const val PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@*#$%^&+=!])(?=\\S+$).{8,50}$"


    /**
     * URL Validator
     * */
    const val URL_REGEX = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]"

}
