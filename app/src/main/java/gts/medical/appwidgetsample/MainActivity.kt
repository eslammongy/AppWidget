package gts.medical.appwidgetsample

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*
import kotlin.math.min

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cal = Calendar.getInstance()
        val minute = cal[Calendar.MINUTE]
        val button = findViewById<Button>(R.id.btnGetTime)
        val txtTime = findViewById<TextView>(R.id.tvTime)
        button.setOnClickListener {

            val startingAngle = (360 - (60 - minute) * 60 / 60 * Math.PI * 2).toFloat()
            txtTime.text = "$startingAngle"
        }
    }
}