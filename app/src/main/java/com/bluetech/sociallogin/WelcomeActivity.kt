package com.bluetech.sociallogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.firebase.auth.FirebaseAuth

class WelcomeActivity : AppCompatActivity() {
    //private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

    }

    fun signOut(view: View) {
        val currentUser = MainActivity.auth.currentUser
        if (currentUser != null) {
            MainActivity.auth.signOut()

            // Google revoke access
            MainActivity.googleSignInClient.revokeAccess().addOnCompleteListener(this) {
                Log.d("panda", "Signing Out ...")
                finish()
            }
        }
    }


}