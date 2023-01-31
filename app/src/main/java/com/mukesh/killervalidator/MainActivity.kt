package com.mukesh.killervalidator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.killervalidator.annotationClasses.*
import com.killervalidator.killerValidator.KillerValidator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

}


data class ValidatorData(
    @RequiredField
    @ErrorMessage(R.string.app_name)
    val password: String? = null
)

fun main(){
    KillerValidator.isValid(dataClass = ValidatorData()){
        println("Error Messages   $it")
    }
}