package com.example.mykaspi.repository

import android.content.Context
import android.content.SharedPreferences
import com.example.mykaspi.data.User

class LocalRepository(context: Context) {
    private val prefs: SharedPreferences = context.applicationContext
        .getSharedPreferences("mykaspi_prefs", Context.MODE_PRIVATE)

    fun saveUser(user: User) {
        prefs.edit()
            .putString("user_id", user.id)
            .putString("user_name", user.name)
            .putString("user_phone", user.phone)
            .apply()
    }

    fun getUser(): User? {
        val id = prefs.getString("user_id", null) ?: return null
        val name = prefs.getString("user_name", "") ?: ""
        val phone = prefs.getString("user_phone", "") ?: ""
        return User(id, name, phone)
    }

    fun clearUser() {
        prefs.edit().clear().apply()
    }
}