package com.sabin.assignment5

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var etxtJoin : EditText
    private lateinit var etxtAge : EditText
    private lateinit var txtJoin : TextView
    private lateinit var txtAge : TextView
    private lateinit var btnOutput : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etxtJoin = findViewById(R.id.etxtJoin)
        etxtAge = findViewById(R.id.etxtAge)
        txtJoin = findViewById(R.id.txtJoin)
        txtAge = findViewById(R.id.txtAge)

        etxtJoin.setOnClickListener {
            val flag:Boolean=false
            loadCalendar(flag)
        }

        etxtAge.setOnClickListener {
            val flag:Boolean=true
            loadCalendar(flag)
        }

        }
    fun loadCalendar(flag:Boolean){
        val c = Calendar.getInstance()
        val year1 = c.get(Calendar.YEAR)
        val month1 = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                if(flag){

                        txtAge.text = "Your Age is : ${year1-year} years and ${month1-(month+1)} months"
                        etxtAge.setText("$dayOfMonth/$month/$year")
                }
                else{
                    txtJoin.text = "No of Year Worked : ${year1-year} years and ${month1-month} months"
                    etxtJoin.setText("$dayOfMonth/$month/$year")
                }
            },
            year1,
            month1,
            day
        )
        datePickerDialog.show()
    }
    }