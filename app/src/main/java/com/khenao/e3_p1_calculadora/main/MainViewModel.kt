package com.khenao.e3_p1_calculadora.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val operand1EmptyMutableLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val operand1EmptyLiveData: LiveData<Boolean> = operand1EmptyMutableLiveData
    private val operand2EmptyMutableLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val operand2EmptyLiveData: LiveData<Boolean> = operand2EmptyMutableLiveData
    private val operationWarningMutableLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val operationWarningLiveData: LiveData<Boolean> = operationWarningMutableLiveData
    private val resultMutableLiveData: MutableLiveData<Float> = MutableLiveData()
    val resultLiveData: LiveData<Float> = resultMutableLiveData

    private var isEmpty = false

    fun checkOperands(operand1: String, operand2: String) {
        operand1EmptyMutableLiveData.value =  operand1.isEmpty()
        operand2EmptyMutableLiveData.value =  operand2.isEmpty()
        isEmpty = operand1.isEmpty().or(operand2.isEmpty())
    }

    fun process(operand1: String, operand2: String, operation: String) {
        if(!isEmpty){
            if(operation == ""){
                operationWarningMutableLiveData.value = true
            }else{
                when(operation){
                    "+" -> resultMutableLiveData.value = operand1.toFloat() + operand2.toFloat()
                    "-" -> resultMutableLiveData.value = operand1.toFloat() - operand2.toFloat()
                    "*" -> resultMutableLiveData.value = operand1.toFloat() * operand2.toFloat()
                    "/" -> resultMutableLiveData.value = operand1.toFloat() / operand2.toFloat()
                }
            }
        }
    }
}