package com.example.mykaspi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val textBalance = findViewById<TextView>(R.id.textBalance)
        val btnTransfer = findViewById<Button>(R.id.btnTransfer)
        val btnPay = findViewById<Button>(R.id.btnPay)
        val btnScanQR = findViewById<Button>(R.id.btnScanQR)

        textBalance.text = "125 000 ₸"

        btnTransfer.setOnClickListener { startActivity(Intent(this, TransferActivity::class.java)) }
        btnPay.setOnClickListener { startActivity(Intent(this, PayActivity::class.java)) }
        btnScanQR.setOnClickListener { startActivity(Intent(this, QRScanActivity::class.java)) }
    }
}