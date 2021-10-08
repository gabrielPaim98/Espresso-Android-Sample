package tk.gabrielpaim.espressotestexample.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import tk.gabrielpaim.espressotestexample.R

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        findViewById<Button>(R.id.buttonLogout).setOnClickListener {
            finish()
        }
    }
}