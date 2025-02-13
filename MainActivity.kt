package com.example.mykotlinapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btnAdd : Button
    lateinit var btnSubtract : Button
    lateinit var btnMultiply : Button
    lateinit var btnDivide : Button
    lateinit var etA : EditText
    lateinit var etB : EditText
    lateinit var resultTv : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnAdd = findViewById(R.id.btn_add)
        btnSubtract = findViewById(R.id.btn_subtraction)
        btnMultiply = findViewById(R.id.btn_multiplication)
        btnDivide = findViewById(R.id.btn_division)
        etA = findViewById(R.id.et_a)
        etB = findViewById(R.id.et_b)
        resultTv = findViewById(R.id.result_tv)

        btnAdd.setOnClickListener(this)
        btnSubtract.setOnClickListener(this)
        btnMultiply.setOnClickListener(this)
        btnDivide.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val a = etA.text.toString().toDoubleOrNull() ?: 0.0
        val b = etB.text.toString().toDoubleOrNull() ?: 0.0
        var result = 0.0
        var fault = false
        when(v?.id) {
            R.id.btn_add -> {
                result = a + b
            }
            R.id.btn_subtraction -> {
                result = a - b
            }
            R.id.btn_division -> {
                if (b == 0.0) {
                    fault = true
                } else {
                    result = a / b
                }
            }
            R.id.btn_multiplication -> {
                result = a * b
            }
        }
        if (!fault) {
            resultTv.text = "Result is $result."
        }
        else {
            resultTv.text = "You cannot divide by 0."
        }
    }
}