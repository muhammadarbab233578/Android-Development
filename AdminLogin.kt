package com.example.kaleemapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AdminLogin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_admin_login)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.adminMain)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val usernameInput = findViewById<EditText>(R.id.adminUsernameInput)
        val passwordInput = findViewById<EditText>(R.id.adminPasswordInput)
        val loginButton = findViewById<Button>(R.id.adminLoginButton)

        loginButton.setOnClickListener {
            val username = usernameInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            // Validate inputs
            if (username.isEmpty()) {
                usernameInput.error = "Username is required"
                usernameInput.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                passwordInput.error = "Password is required"
                passwordInput.requestFocus()
                return@setOnClickListener
            }

            // Check credentials
            if (username == "admin" && password == "12345") {
                Toast.makeText(this, "Admin Login Successful", Toast.LENGTH_SHORT).show()
                // Navigate to AdminDashboard
                val intent = Intent(this, AdminDashboard::class.java)
                startActivity(intent)
                finish()  // Optional: close login screen
            } else {
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
