package com.example.calculator

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAC.setOnClickListener {
            input.text=""
            output.text = ""
        }
        btnbracketleft.setOnClickListener {input.text = addToInput("(") }
        btnbracketright.setOnClickListener { input.text = addToInput(")") }
        btn0.setOnClickListener { input.text = addToInput("0") }
        btn1.setOnClickListener { input.text = addToInput("1") }
        btn2.setOnClickListener { input.text = addToInput("2") }
        btn3.setOnClickListener { input.text = addToInput("3") }
        btn4.setOnClickListener { input.text = addToInput("4") }
        btn5.setOnClickListener { input.text = addToInput("5") }
        btn6.setOnClickListener { input.text = addToInput("6") }
        btn7.setOnClickListener { input.text = addToInput("7") }
        btn8.setOnClickListener { input.text = addToInput("8") }
        btn9.setOnClickListener { input.text = addToInput("9") }
        btndot.setOnClickListener { input.text = addToInput(".") }
        btnplus.setOnClickListener { input.text = addToInput("+") }
        btnminus.setOnClickListener { input.text = addToInput("-") }
        btnmultiply.setOnClickListener { input.text = addToInput("×") }
        btndivision.setOnClickListener { input.text = addToInput("/") }
        btnsqroot.setOnClickListener { input.text = addToInput("√") }
        btnequal.setOnClickListener { display() }
    }
    private fun addToInput(buttonValue: String): String {
        return "${input.text}$buttonValue"
    }
    private fun display() {
        val expression = getInputExpression()
        val result = Expression(expression).calculate()
        if (result.isNaN()) {
            // Show Error Message
            output.text = "Error"
            output.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
        else {
            // Show Result
            output.text = DecimalFormat("0.######").format(result).toString()
            output.setTextColor(ContextCompat.getColor(this, R.color.green))
        }
    }
    private fun getInputExpression(): String {
        var expression = input.text.replace(Regex("×"), "*")
        return expression
    }
}