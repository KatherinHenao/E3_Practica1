package com.khenao.e3_p1_calculadora.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.khenao.e3_p1_calculadora.R

import com.khenao.e3_p1_calculadora.databinding.ActivityMainBinding
import java.util.*
import kotlin.concurrent.timerTask

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private var operation = ""
    private val timer = Timer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        with(mainBinding) {
            mainViewModel.operand1EmptyLiveData.observe(this@MainActivity) { operand1EmptyMutableLiveData ->
                if (operand1EmptyMutableLiveData) {
                    operador1Warning()
                }
            }

            mainViewModel.operand2EmptyLiveData.observe(this@MainActivity) { operand2EmptyMutableLiveData ->
                if (operand2EmptyMutableLiveData) {
                    operador2Warning()
                }
            }

            mainViewModel.operationWarningLiveData.observe(this@MainActivity) { operationWarningMutableLiveData ->
                if (operationWarningMutableLiveData) {
                    operationWarning()
                }
            }

            mainViewModel.resultLiveData.observe(this@MainActivity) { resultMutableLiveData ->
                resultTextView.text = resultMutableLiveData.toString()
            }

            solveButton.setOnClickListener {
                val operand1 = operador1EditText.text.toString()
                val operand2 = operador2EditText.text.toString()

                mainViewModel.checkOperands(operand1, operand2)
                mainViewModel.process(operand1, operand2, operation)
            }

            operand1Button.setOnClickListener {
                operation = operand1Button.text.toString()
                operand1Button.setBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.Crimson
                    )
                )
                operand2Button.setBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.main_buttons_Bground
                    )
                )
                operand3Button.setBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.main_buttons_Bground
                    )
                )
                operand4Button.setBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.main_buttons_Bground
                    )
                )
            }

            operand2Button.setOnClickListener {
                operation = operand2Button.text.toString()
                operand2Button.setBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.Crimson
                    )
                )
                operand1Button.setBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.main_buttons_Bground
                    )
                )
                operand3Button.setBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.main_buttons_Bground
                    )
                )
                operand4Button.setBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.main_buttons_Bground
                    )
                )
            }

            operand3Button.setOnClickListener {
                operation = operand3Button.text.toString()
                operand3Button.setBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.Crimson
                    )
                )
                operand1Button.setBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.main_buttons_Bground
                    )
                )
                operand2Button.setBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.main_buttons_Bground
                    )
                )
                operand4Button.setBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.main_buttons_Bground
                    )
                )
            }

            operand4Button.setOnClickListener {
                operation = operand4Button.text.toString()
                operand4Button.setBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.Crimson
                    )
                )
                operand1Button.setBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.main_buttons_Bground
                    )
                )
                operand2Button.setBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.main_buttons_Bground
                    )
                )
                operand3Button.setBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.main_buttons_Bground
                    )
                )

            }
        }
    }

    private fun ActivityMainBinding.operationWarning() {
        resultTextView.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.Red))
        timer.schedule(
            timerTask {
                resultTextView.setBackgroundResource(R.drawable.main_result)
            },
            1000
        )
    }

    private fun ActivityMainBinding.operador2Warning() {
        operador2EditText.setBackgroundColor(
            ContextCompat.getColor(
                applicationContext,
                R.color.Red
            )
        )
        timer.schedule(
            timerTask {
                operador2EditText.setBackgroundResource(R.drawable.main_operand)
            },
            1000
        )
    }

    private fun ActivityMainBinding.operador1Warning() {
        operador1EditText.setBackgroundColor(
            ContextCompat.getColor(
                applicationContext,
                R.color.Red
            )
        )
        timer.schedule(
            timerTask {
                operador1EditText.setBackgroundResource(R.drawable.main_operand)
            },
            1000
        )
    }
}