package com.khenao.e3_p1_calculadora.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.khenao.e3_p1_calculadora.R

import com.khenao.e3_p1_calculadora.databinding.ActivityMainBinding
import java.util.*
import kotlin.concurrent.timerTask


class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private var operation = ""
    private val timer = Timer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        with(mainBinding){
            operand1Button.setOnClickListener {
                operation = operand1Button.text.toString()
                operand1Button.setBackgroundColor(resources.getColor(R.color.Crimson))
                operand2Button.setBackgroundColor(resources.getColor(R.color.main_buttons_Bground))
                operand3Button.setBackgroundColor(resources.getColor(R.color.main_buttons_Bground))
                operand4Button.setBackgroundColor(resources.getColor(R.color.main_buttons_Bground))
            }

            operand2Button.setOnClickListener {
                operation = operand2Button.text.toString()
                operand2Button.setBackgroundColor(resources.getColor(R.color.Crimson))
                operand1Button.setBackgroundColor(resources.getColor(R.color.main_buttons_Bground))
                operand3Button.setBackgroundColor(resources.getColor(R.color.main_buttons_Bground))
                operand4Button.setBackgroundColor(resources.getColor(R.color.main_buttons_Bground))
            }

            operand3Button.setOnClickListener {
                operation = operand3Button.text.toString()
                operand3Button.setBackgroundColor(resources.getColor(R.color.Crimson))
                operand1Button.setBackgroundColor(resources.getColor(R.color.main_buttons_Bground))
                operand2Button.setBackgroundColor(resources.getColor(R.color.main_buttons_Bground))
                operand4Button.setBackgroundColor(resources.getColor(R.color.main_buttons_Bground))
            }

            operand4Button.setOnClickListener {
                operation = operand4Button.text.toString()
                operand4Button.setBackgroundColor(resources.getColor(R.color.Crimson))
                operand1Button.setBackgroundColor(resources.getColor(R.color.main_buttons_Bground))
                operand2Button.setBackgroundColor(resources.getColor(R.color.main_buttons_Bground))
                operand3Button.setBackgroundColor(resources.getColor(R.color.main_buttons_Bground))

            }

            solveButton.setOnClickListener {
                val operand1 = operador1EditText.text.toString()
                val operand2 = operador2EditText.text.toString()
                var myNotEmpty = true

                if(operand1.isNullOrEmpty()){
                    operador1EditText.setBackgroundColor(resources.getColor(R.color.Red))
                    timer.schedule(
                        timerTask {
                            operador1EditText.setBackgroundResource(R.drawable.main_operand)
                        },
                        1000
                    )
                    myNotEmpty = false
                }
                if(operand2.isNullOrEmpty()){
                    operador2EditText.setBackgroundColor(resources.getColor(R.color.Red))
                    timer.schedule(
                        timerTask {
                            operador2EditText.setBackgroundResource(R.drawable.main_operand)
                        },
                        1000
                    )
                    myNotEmpty = false
                }
                if(myNotEmpty){
                    var result = 0.0f
                    if(operation == ""){
                        resultTextView.setBackgroundColor(resources.getColor(R.color.Red))
                        timer.schedule(
                            timerTask {
                                resultTextView.setBackgroundResource(R.drawable.main_result)
                            },
                            1000
                        )
                    }else{
                        when(operation){
                            "+" -> result = operand1.toFloat() + operand2.toFloat()
                            "-" -> result = operand1.toFloat() - operand2.toFloat()
                            "*" -> result = operand1.toFloat() * operand2.toFloat()
                            "/" -> result = operand1.toFloat() / operand2.toFloat()
                        }
                        resultTextView.text = result.toString()
                    }
                }

            }
        }
    }
}