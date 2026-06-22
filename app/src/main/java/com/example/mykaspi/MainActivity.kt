package com.example.mykaspi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.mykaspi.repository.LocalRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        lifecycleScope.launch {
            delay(1500)
            val repository = LocalRepository(applicationContext)
            val user = repository.getUser()
            
            val intent = if (user != null) {
                Intent(this@MainActivity, DashboardActivity::class.java)
            } else {
                Intent(this@MainActivity, LoginActivity::class.java)
            }
            startActivity(intent)
            finish()
        }
    }
}