package com.example.simpleproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var operand1: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text: TextView = findViewById(R.id.textView)

        val b0: Button = findViewById(R.id.button0)
        b0.setOnClickListener{appendNumber("0")}

        val b1: Button = findViewById(R.id.button1)
        b1.setOnClickListener{appendNumber("1")}

        val b2: Button = findViewById(R.id.button2)
        b2.setOnClickListener{appendNumber("2")}

        val b3: Button = findViewById(R.id.button3)
        b3.setOnClickListener{appendNumber("3")}

        val b4: Button = findViewById(R.id.button4)
        b4.setOnClickListener{appendNumber("4")}

        val b5: Button = findViewById(R.id.button5)
        b5.setOnClickListener{appendNumber("5")}

        val b6: Button = findViewById(R.id.button6)
        b6.setOnClickListener{appendNumber("6")}

        val b7: Button = findViewById(R.id.button7)
        b7.setOnClickListener{appendNumber("7")}

        val b8: Button = findViewById(R.id.button8)
        b8.setOnClickListener{appendNumber("8")}

        val b9: Button = findViewById(R.id.button9)
        b9.setOnClickListener{appendNumber("9")}

        val bclear: Button = findViewById(R.id.buttonClear)
        bclear.setOnClickListener{
            text.text = ""
            operand1 = 0.0
            operation = ""
        }

        val beq: Button = findViewById(R.id.buttonEq)
        beq.setOnClickListener{
            val operand2String: String = text.text.toString()
            if (operand2String != "") {
                val operand2: Double = operand2String.toDouble()
                val result: Double = when (operation) {
                    "+" -> operand1 + operand2
                    "-" -> operand1 - operand2
                    "/" -> operand1 / operand2
                    "*" -> operand1 * operand2
                    else -> operand2
                }
                text.text=result.toString()
                operand1=result
            }
            else {
                return@setOnClickListener
            }

        }

        val bsum: Button = findViewById(R.id.buttonPlus)
        bsum.setOnClickListener{setOperation("+")}
        val bmin: Button = findViewById(R.id.buttonMin)
        bmin.setOnClickListener{setOperation("-")}
        val bmul: Button = findViewById(R.id.buttonMul)
        bmul.setOnClickListener{setOperation("*")}
        val bdiv: Button = findViewById(R.id.buttonDiv)
        bdiv.setOnClickListener{setOperation("/")}

    }

    private fun appendNumber(number: String){
        val textF: TextView = findViewById(R.id.textView)
        if (textF.text == "0"){
            textF.text = number
        }
        else{
            textF.append(number)
        }
    }

    private fun setOperation (oper: String){
        val textF: TextView = findViewById(R.id.textView)
        if (operand1 == 0.0){
            operand1 = textF.text.toString().toDouble()
            operation = oper
            textF.text = ""
        }

        else if (operation == "") {

        }

        else{
            val operand2F: String = textF.text.toString()
            if (operand2F.isNotEmpty()){
                val operand2: Double = operand2F.toDouble()
                val result: Double = when(operation) {
                    "+" -> operand1 + operand2
                    "-" -> operand1 - operand2
                    "*" -> operand1 * operand2
                    "/" -> operand1 / operand2
                    else -> operand2
                }
                textF.text = result.toString()
                operand1 = result
            }

            operation = oper
        }
    }

}