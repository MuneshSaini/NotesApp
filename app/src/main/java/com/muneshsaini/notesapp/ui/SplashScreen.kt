package com.muneshsaini.notesapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.muneshsaini.notesapp.R

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val isUserLoggedIn = SharedPref.getBoolean(PrefConstant.IS_USER_LOGGED_IN)
        if (isUserLoggedIn){
        startActivity(Intent(this,MainActivity::class.java))
        finish()
        }else{
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }
    }
}