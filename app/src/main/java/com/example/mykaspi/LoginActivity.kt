package com.example.mykaspi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mykaspi.data.User
import com.example.mykaspi.repository.LocalRepository

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val editPhone = findViewById<EditText>(R.id.editLoginPhone)
        val editPassword = findViewById<EditText>(R.id.editLoginPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val phone = editPhone.text.toString().trim()
            val password = editPassword.text.toString().trim()

            if (phone.isNotEmpty() && password.isNotEmpty()) {
                val repository = LocalRepository(applicationContext)
                repository.saveUser(User("1", "Alex", phone))
                
                startActivity(Intent(this, DashboardActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Введите телефон и пароль", Toast.LENGTH_SHORT).show()
            }
        }
    }
}