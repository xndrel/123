package com.example.triangles

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }
        val sideOne : EditText = findViewById(R.id.SideOne)
        val sideTwo : EditText = findViewById(R.id.SideTwo)
        val findCatet : Button = findViewById(R.id.CatetButton)

        val findHypotenuse : Button = findViewById((R.id.HypotenuseButton))

        findHypotenuse.setOnClickListener{
            if((sideOne.text!=null && sideOne.text.toString().toIntOrNull()!=null) && (sideTwo.text!=null && sideTwo.text.toString().toIntOrNull()!=null)){
                val int1 : Float = sideOne.text.toString().toFloat()
                val int2 : Float = sideTwo.text.toString().toFloat()
                val result : String = solve_hypo(int1,int2)
                Toast.makeText(this, "Hypotenuse: $result", Toast.LENGTH_SHORT).show()
            }

        }
        findCatet.setOnClickListener{
            if((sideOne.text!=null && sideOne.text.toString().toIntOrNull()!=null) && (sideTwo.text!=null && sideTwo.text.toString().toIntOrNull()!=null)){
                val int1 : Float = sideOne.text.toString().toFloat()
                val int2 : Float = sideTwo.text.toString().toFloat()
                val result : String = solve_catet(int1,int2)
                Toast.makeText(this, "Catet: $result", Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun solve_hypo(num1:Float, num2:Float) : String{
        val result : Float = sqrt(num1*num1 + num2*num2)
        return result.toString()

    }
    fun solve_catet(num1:Float, num2:Float) : String{
        val hypo : Float
        val catet : Float
        if(num1>num2) {
            hypo = num1
            catet = num2
        }
        else{
            hypo = num2
            catet = num1
        }
        val result : Float = sqrt(hypo*hypo - catet*catet)
        return result.toString()
    }
}