package com.diego.calculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View
import android.widget.TextView
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var oper : Int = 0
    var numero1: Double = 0.0
    lateinit var tv_num1: TextView
    lateinit var tv_num2: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        tv_num1 = findViewById(R.id.tv_num1)
        tv_num2 = findViewById(R.id.tv_num2)
        val btnBorrar : Button = findViewById(R.id.buttonC)
        val btnIgual : Button = findViewById(R.id.buttonEquals)

        btnIgual.setOnClickListener {
            var numero2: Double = tv_num1.text.toString().toDouble()
            var resp: Double = 0.0

            when (oper) {
                1 -> resp = numero1 + numero2
                2 -> resp = numero1 - numero2
                3 -> resp = numero1 * numero2
                4 -> {
                    if (numero2 == 0.0) {
                        Toast.makeText(this, "You can't divide by 0", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }
                    resp = numero1 / numero2
                }
            }

            tv_num1.setText(resp.toString())
            tv_num2.setText("")
        }

        btnBorrar.setOnClickListener {
            tv_num1.setText("")
            tv_num2.setText("")
            numero1=0.0
            oper=0
        }


    }

    fun presionarDigito(view: View) {


        var num2: String = tv_num1.text.toString()

        when (view.id) {
            R.id.button0 -> tv_num1.text = num2 + "0"
            R.id.button1 -> tv_num1.text = num2 + "1"
            R.id.button2 -> tv_num1.text = num2 + "2"
            R.id.button3 -> tv_num1.text = num2 + "3"
            R.id.button4 -> tv_num1.text = num2 + "4"
            R.id.button5 -> tv_num1.text = num2 + "5"
            R.id.button6 -> tv_num1.text = num2 + "6"
            R.id.button7 -> tv_num1.text = num2 + "7"
            R.id.button8 -> tv_num1.text = num2 + "8"
            R.id.button9 -> tv_num1.text = num2 + "9"
            R.id.buttonDot -> tv_num1.text = num2 + "."
        }
    }

    fun cliclOperacion(view: View) {
        numero1 = tv_num1.text.toString().toDouble()
        var num1_text: String = tv_num1.text.toString()
        tv_num1.setText("")
        when(view.id) {
            R.id.buttonPlus -> {
                tv_num2.setText(num1_text + "+")
                oper = 1
            }
            R.id.buttonMinus -> {
                tv_num2.setText(num1_text + "-")
                oper = 2
            }
            R.id.buttonAsterik -> {
                tv_num2.setText(num1_text + "*")
                oper = 3
            }
            R.id.buttonSlash -> {
                tv_num2.setText(num1_text + "/")
                oper = 4
            }
        }
    }
}