package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity(),View.OnClickListener {
    val PASSWORD_PATTERN =Pattern.compile("^" +
            "(?=.*[0-9])" +         //at least 1 digit
            "(?=.*[a-z])" +         //at least 1 lower case letter
            "(?=.*[A-Z])" +         //at least 1 upper case letter
            "(?=.*[a-zA-Z])" +      //any letter
            "(?=\\S+$)" +           //no white spaces
            ".{6,}" +               //at least 6 characters
            "$");


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSignIn.setOnClickListener(this)
    }

    private fun validateEmail() :Boolean{
        if(!Patterns.EMAIL_ADDRESS.matcher(emailField.text.toString()).matches()){
            emailField.error = "Неправильно введен email"
            return false
        }
        emailField.error = null
        return true
    }

    private fun validatePassword(): Boolean {
        if (!PASSWORD_PATTERN.matcher(passField.text.toString()).matches()) {
            passField.error = "Пароль слишком лёгкий"
            return false
        }
        passField.error = null
        return true
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnSignIn  ->{
                if((validatePassword()) && (validateEmail())){
                    Toast.makeText(applicationContext, "Done",Toast.LENGTH_LONG).show()
                }
            }
        }
    }


}
