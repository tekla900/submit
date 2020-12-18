package com.example.submit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var inputEmail: EditText
    private lateinit var inputPassword: EditText
    private lateinit var submit: Button

    private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()

        inputEmail = findViewById(R.id.EmailAddress)
        inputPassword = findViewById(R.id.Password)
        submit = findViewById(R.id.submitButton)

        submit.setOnClickListener {

            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Empty", Toast.LENGTH_LONG).show()
            } else {
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    task ->
                    if(task.isSuccessful) {
                } else {
                        Toast.makeText(this, "Error!", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

    }
}