package com.example.ideagerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)



        val generatorBtn = findViewById<Button>(R.id.Generator_Button)
        generatorBtn.setOnClickListener{AddTextbyJson()}
        }

     fun AddTextbyJson() {
         try {


             val WordView = findViewById<TextView>(R.id.WordView)
             val WordView2 = findViewById<TextView>(R.id.WordView2)

             val assetManager = resources.assets

             val A_inputStream = assetManager.open("Adjective.json")
             val A_bufferedReader = BufferedReader(InputStreamReader(A_inputStream))
             val A_str: String = A_bufferedReader.readText()
             val A_jsonObject = JSONObject(A_str)
             val A_jsonArray = A_jsonObject.getJSONArray("Adjective")


             val inputStream = assetManager.open("Noun.json")
             val bufferedReader = BufferedReader(InputStreamReader(inputStream))
             val str: String = bufferedReader.readText()
             val jsonObject = JSONObject(str)
             val jsonArray = jsonObject.getJSONArray("Noun")
             for (i in 0 until A_jsonArray.length()){
                 val A_range = (0..i)
                 val A_randomInt = A_range.random()
                 val A_jsondata = A_jsonArray.getJSONObject(A_randomInt)
                 WordView.text = A_jsondata.getString("adjective")
             }
             for (i in 0 until jsonArray.length()) {
                 val range = (0..i)
                 val randomInt = range.random()
                 val jsondata = jsonArray.getJSONObject(randomInt)
                 WordView2.text = jsondata.getString("noun")
             }
         } catch (e: JSONException){
             e.printStackTrace()
         }








     }







}


