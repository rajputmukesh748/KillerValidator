package com.mukesh.killervalidator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.killervalidator.annotationClasses.EmailField
import com.killervalidator.annotationClasses.ErrorMessage
import com.killervalidator.annotationClasses.PasswordField
import com.killervalidator.annotationClasses.RequiredField
import com.killervalidator.killerValidator.KillerValidator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

}


data class ValidatorData(
    @RequiredField
    @ErrorMessage("Please enter name.")
    val name1: String? = null,
    @RequiredField
    @PasswordField
    val message: String? = null

)

fun main(){
    KillerValidator.isValid(dataClass = ValidatorData()){
        println("Error Messages   $it")
    }
}