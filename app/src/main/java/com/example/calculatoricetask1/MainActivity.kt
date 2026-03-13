package com.example.calculatoricetask1
/*
MASIKE
ST10452404 ICE TASK 1
 */
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number1 = findViewById<EditText>(R.id.number1)
        val number2 = findViewById<EditText>(R.id.number2)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSubtract = findViewById<Button>(R.id.btnSubtract)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val btnDivide = findViewById<Button>(R.id.btnDivide)

        val txtResult = findViewById<TextView>(R.id.txtResult)

        fun getNumbers(): Pair<Double, Double>? {
            val num1 = number1.text.toString()
            val num2 = number2.text.toString()

            if (num1.isEmpty() || num2.isEmpty()) {
                Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show()
                return null
            }

            return Pair(num1.toDouble(), num2.toDouble())
        }

        btnAdd.setOnClickListener {
            val numbers = getNumbers()
            numbers?.let {
                val result = it.first + it.second
                txtResult.text = "Result: $result"
            }
        }

        btnSubtract.setOnClickListener {
            val numbers = getNumbers()
            numbers?.let {
                val result = it.first - it.second
                txtResult.text = "Result: $result"
            }
        }

        btnMultiply.setOnClickListener {
            val numbers = getNumbers()
            numbers?.let {
                val result = it.first * it.second
                txtResult.text = "Result: $result"
            }
        }

        btnDivide.setOnClickListener {
            val numbers = getNumbers()
            numbers?.let {
                if (it.second == 0.0) {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                } else {
                    val result = it.first / it.second
                    txtResult.text = "Result: $result"
                }
            }
        }
    }
}