package com.example.myapplication.acitivty

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loginButton.setOnClickListener {

            navigateToUserActivity()
        }
    }

    private fun navigateToUserActivity() {
        val intent = Intent(this, UserActivity::class.java)
        intent.putExtra("USER_NAME", editText_userName.text.toString())
        startActivity(intent)
    }
}
