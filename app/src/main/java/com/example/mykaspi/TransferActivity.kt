package com.example.mykaspi

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TransferActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transfer)

        val editPhone = findViewById<EditText>(R.id.editTransferPhone)
        val editAmount = findViewById<EditText>(R.id.editTransferAmount)
        val btnSend = findViewById<Button>(R.id.btnSendTransfer)

        btnSend.setOnClickListener {
            val phone = editPhone.text.toString().trim()
            val amount = editAmount.text.toString().trim()

            if (phone.isNotEmpty() && amount.isNotEmpty()) {
                Toast.makeText(this, "Перевод на $phone отправлен!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show()
            }
        }
    }
}