package com.example.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
//view - edit text, spinner, checkbox, radio group
class MainActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var edtName: EditText
    private lateinit var chJava: CheckBox
    private lateinit var chKotlin: CheckBox
    private lateinit var chNative: CheckBox
    private lateinit var rdGroup: RadioGroup
    private lateinit var btnSave: Button
    private lateinit var rdButton: RadioButton


    //res
    private lateinit var resSpinner: String
    private lateinit var resName: String
    private lateinit var resCheckbox: String
    private lateinit var resRadio:String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //find by id
        spinner = findViewById(R.id.spinner)
        edtName = findViewById(R.id.edtName)
        chJava = findViewById(R.id.chJava)
        chKotlin = findViewById(R.id.chKotlin)
        chNative  = findViewById(R.id.chNative)
        rdGroup = findViewById(R.id.rdGroup)
        btnSave = findViewById(R.id.btnSave)



        //get spinner
        val hobbies = arrayOf<String>("Football", "Music", "Singing", "Coding")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,hobbies)//spinner ထဲမှာသုံးဖို့ဆိုရင် adapter လိုတယ်. hobbies ကို adapter အနေနဲ့သုံးမယ်
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                resSpinner = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }


//        resCheckbox = ""
//        //get checkbox
//        when {
//            (chJava.isChecked) -> resCheckbox += "Java\n"
//            (chNative.isChecked) -> resCheckbox += "Native\n"
//            (chKotlin.isChecked) -> resCheckbox += "Kotlin\n"
//        }


        rdGroup.setOnCheckedChangeListener { group, checkedId ->
            rdButton = findViewById(checkedId)
            resRadio = rdButton.text.toString()

        }

        btnSave.setOnClickListener {
            resCheckbox = ""

            if (chJava.isChecked){
                resCheckbox =resCheckbox+ "Java\n"
            }

            if(chKotlin.isChecked){
                resCheckbox =resCheckbox+ "Kotlin\n"
            }

            if(chNative.isChecked){
                resCheckbox =resCheckbox+ "Native\n"
            }

            //get edit text
            resName = edtName.text.toString()

            Log.d("Data", "$resName  $resSpinner $resCheckbox $resRadio")
        }
    }
}

