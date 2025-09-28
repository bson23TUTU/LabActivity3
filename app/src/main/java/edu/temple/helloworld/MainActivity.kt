package edu.temple.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // Declare view properties - the first one is done for you
    lateinit var displayTextView: TextView
    lateinit var nameEditText: EditText
    lateinit var etEmail: EditText
    lateinit var spProgram: Spinner
    lateinit var etPassword: EditText
    lateinit var etConfirm: EditText
    lateinit var clickMeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize with views defined in Layout - the first one is done for you
        displayTextView = findViewById(R.id.displayTextView)
        nameEditText = findViewById(R.id.nameEditText)
        etEmail = findViewById(R.id.etEmail)
        spProgram = findViewById(R.id.spProgram)
        etPassword = findViewById(R.id.etPassword)
        etConfirm = findViewById(R.id.etConfirm)
        clickMeButton = findViewById(R.id.clickMeButton)

        clickMeButton.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString()
            val confirm = etConfirm.text.toString()
            val programPos = spProgram.selectedItemPosition

            nameEditText.error = null
            etEmail.error = null
            etPassword.error = null
            etConfirm.error = null

            var valid = true
            if (name.isEmpty()) { nameEditText.error = "Please enter your name"; valid = false }
            if (email.isEmpty()) { etEmail.error = "Please enter your email"; valid = false }
            if (password.isEmpty()) { etPassword.error = "Please enter a password"; valid = false }
            if (confirm.isEmpty()) { etConfirm.error = "Please confirm your password"; valid = false }
            if (password.isNotEmpty() && confirm.isNotEmpty() && password != confirm) {
                etConfirm.error = "Passwords do not match"; valid = false
            }
            if (programPos == 0) {
                Toast.makeText(this, "Please select your program", Toast.LENGTH_SHORT).show()
                valid = false
            }

            if (valid) {
                displayTextView.text = "Welcome, $name, to the SignUpForm App"
                displayTextView.visibility = TextView.VISIBLE
            }
        }
    }
}
