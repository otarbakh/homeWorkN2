package com.example.homeworkn2
import java.util.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editText = findViewById<EditText>(R.id.edit_num)
        val button = findViewById<Button>(R.id.button_convert)
        val textView = findViewById<TextView>(R.id.tv_result)
        button.setOnClickListener{
            val x = editText.text.toString().toInt()
            val result = numberToWord(x)
            textView.text = result
        }
    }
    fun numberToWord(a: Int): String {
        var a = a
        var word = ""
        val unitArray = arrayOf(
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
            "thirteen", "fourteen", "fifteen", "sixteen",
            "seventeen", "eighteen", "nineteen"
        )
        val tensArray = arrayOf(
            "zero", "ten", "twenty", "thirty", "forty",
            "fifty", "sixty", "seventy", "eighty", "ninety"
        )
        val hundredArray = arrayOf(
            "zero", "hundred", "two hundred", "three hundred", "four hundred",
            "five hundred", "six hundred", "seven hundred", "eight hundred", "nine hundred", "thousand"
        )
        if (a == 0) {
            return "zero"
        }
        if (a / 1000 > 0) {
            word += numberToWord(a / 1000) + "thousand"
            a %= 1000
        }
        if (a / 100 > 0) {
            word += numberToWord(a / 100) + "hundred"
            a %= 100
        }
        if (a > 0) {
            if (a < 20) {
                word += unitArray[a]
            } else if (a in 21..99) {
                word += tensArray[a / 10]
                if (a % 10 > 0) {
                    word = word + " " + unitArray[a % 10]
                }
            } else {
                word += hundredArray[a / 100]
                if (a % 100 > 99) {
                    word = word + " " + unitArray[a] + " " + tensArray[a / 10]
                }
            }
        }
        return word
    }

}


//
// NumberConverter {
//
//    @JvmStatic
//    fun main(args: Array<String>) {
//        val sc = Scanner(System.`in`)
//        var number = 0
//        number = sc.nextInt()
//        if (number == 0) {
//            println("Zero")
//        } else {
//            println("Number in words :" + numberToWord(number))
//        }
//    }
//}