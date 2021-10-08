package tk.gabrielpaim.espressotestexample.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import tk.gabrielpaim.espressotestexample.R
import tk.gabrielpaim.espressotestexample.home.Home

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etUser = findViewById<EditText>(R.id.editTextUser)
        val etPassword = findViewById<EditText>(R.id.editTextPassword)
        val textWrongCredentials = findViewById<TextView>(R.id.textViewWrongCredentials)
        val button = findViewById<Button>(R.id.buttonEnter)

        button.setOnClickListener {
            val user = etUser.text.toString()
            val password = etPassword.text.toString()
            val isLoggedIn = login(user, password)

            if (isLoggedIn) {
                textWrongCredentials.visibility = View.INVISIBLE
                startActivity(Intent(this, Home::class.java))
            } else {
                textWrongCredentials.visibility = View.VISIBLE
            }
        }
    }

    private fun login(user: String, password: String): Boolean {
        return (user == "user" && password == "123")
    }

}