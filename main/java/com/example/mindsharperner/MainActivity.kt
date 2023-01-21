package com.example.mindsharperner

import androidx.appcompat.app.AppCompatActivity
import com.example.mindsharperner.databinding.ActivityMainBinding
import android.os.Bundle
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.checkButton.setOnClickListener{checkAnswer()}

         var firstNumber: Int = 0
         var secondNumber: Int = 0
         var operator: String = ""
        binding.levelOptions.check(R.id.easy)

        binding.levelOptions.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.easy -> {
                    firstNumber = Random.nextInt(9)
                    secondNumber = Random.nextInt(9)
                    val operators = arrayOf("+", "-", "*", "/")
                    operator = operators[Random.nextInt(operators.size)]
                    binding.firstNumber.text = firstNumber.toString();
                    binding.secondNumber.text = secondNumber.toString();
                    binding.operator.text = operator.toString();
                }
                R.id.medium -> {
                    firstNumber = Random.nextInt(99)
                    secondNumber = Random.nextInt(99)
                    val operators = arrayOf("+", "-", "*", "/")
                    operator = operators[Random.nextInt(operators.size)]
                    binding.firstNumber.text = firstNumber.toString();
                    binding.secondNumber.text = secondNumber.toString();
                    binding.operator.text = operator.toString();
                }
                R.id.hard -> {
                    firstNumber = Random.nextInt(999)
                    secondNumber = Random.nextInt(999)
                    val operators = arrayOf("+", "-", "*", "/")
                    operator = operators[Random.nextInt(operators.size)]
                    binding.firstNumber.text = firstNumber.toString();
                    binding.secondNumber.text = secondNumber.toString();
                    binding.operator.text = operator.toString();}
            }

        }

    }
    private fun checkAnswer() {
        var firstNumber: Int = 0
        var secondNumber: Int = 0
        var operator: String = ""
        var ans: Int = 0
        val stringInputEditText = binding.editTextNumber.text.toString()
        val userInput = stringInputEditText.toIntOrNull()
        if (userInput == null) {
            binding.displayPoint.text = ""
            return
        }

        binding.levelOptions.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.easy -> {
                    firstNumber = Random.nextInt(9)
                    secondNumber = Random.nextInt(9)
                    val operators = arrayOf("+", "-", "*", "/")
                    operator = operators[Random.nextInt(operators.size)]
                }
                R.id.medium -> {
                    firstNumber = Random.nextInt(99)
                    secondNumber = Random.nextInt(99)
                    val operators = arrayOf("+", "-", "*", "/")
                    operator = operators[Random.nextInt(operators.size)]
                }
                R.id.hard -> {
                    firstNumber = Random.nextInt(999)
                    secondNumber = Random.nextInt(999)
                    val operators = arrayOf("+", "-", "*", "/")
                    operator = operators[Random.nextInt(operators.size)]
                }

            }
        }
       if (operator == "+"){
           ans = firstNumber + secondNumber
       } else if (operator == "-"){
           ans = firstNumber - secondNumber
       } else if (operator == "*"){
           ans = firstNumber * secondNumber
       } else {
           ans = firstNumber / secondNumber
       }
       if (userInput == ans){
           binding.displayPoint.text = "Plus One!!! Correct"
    }else{
        binding.displayPoint.text = "Wrong!"
       }
    }
}