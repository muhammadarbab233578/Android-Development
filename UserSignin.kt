package com.example.kaleemapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class UserSignin : AppCompatActivity() {

    private lateinit var nameInput: EditText
    private lateinit var emailInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var confirmPasswordInput: EditText
    private lateinit var signupButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_signin)

        // Initialize views
        nameInput = findViewById(R.id.nameInput)
        emailInput = findViewById(R.id.emailInput)
        passwordInput = findViewById(R.id.passwordInput)
        confirmPasswordInput = findViewById(R.id.confirmPasswordInput)
        signupButton = findViewById(R.id.signupButton)

        signupButton.setOnClickListener {
            val name = nameInput.text.toString().trim()
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()
            val confirmPassword = confirmPasswordInput.text.toString().trim()

            var isValid = true

            if (name.isEmpty()) {
                nameInput.error = "Name is required"
                isValid = false
            }

            if (email.isEmpty()) {
                emailInput.error = "Email is required"
                isValid = false
            }

            if (password.isEmpty()) {
                passwordInput.error = "Password is required"
                isValid = false
            }

            if (confirmPassword.isEmpty()) {
                confirmPasswordInput.error = "Please confirm password"
                isValid = false
            }

            if (password != confirmPassword) {
                confirmPasswordInput.error = "Passwords do not match"
                isValid = false
            }

            if (isValid) {
                Toast.makeText(this, "Signup successful (locally)", Toast.LENGTH_SHORT).show()
                // Go to login screen
                startActivity(Intent(this, UserLogin::class.java))
                finish()
            }
        }
    }
}
