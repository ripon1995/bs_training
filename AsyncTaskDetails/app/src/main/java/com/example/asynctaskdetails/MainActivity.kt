package com.example.asynctaskdetails

import android.os.AsyncTask
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONException
import org.json.JSONObject
import java.io.*
import java.net.HttpURLConnection
import java.net.URL


class MainActivity : AppCompatActivity() {

    private val url ="https://jsonplaceholder.typicode.com/users"

    private lateinit var btnData : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnData = findViewById(R.id.btnData)
        btnData.setOnClickListener {
            loadData()
        }
    }

    private fun loadData(){
        val data = LoadDataFromServer()
        data.execute(url)
    }

    private class LoadDataFromServer():AsyncTask<String,String,String>(){
        override fun doInBackground(vararg params: String?): String {
            var weather = "UNDEFINED"
            try {
                val url = URL(params[0])
                val urlConnection = url.openConnection() as HttpURLConnection
                val stream: InputStream = BufferedInputStream(urlConnection.inputStream)
                val bufferedReader = BufferedReader(InputStreamReader(stream))
                val builder = StringBuilder()
                var inputString: String?
                while (bufferedReader.readLine().also { inputString = it } != null) {
                    builder.append(inputString)
                }
                val topLevel = JSONObject(builder.toString())
                val main = topLevel.getJSONObject("Value")
                weather = main.getDouble("name").toString()
                urlConnection.disconnect()
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: JSONException) {
                e.printStackTrace()
            }
            return weather
        }

        override fun onPostExecute(result: String) {
            super.onPostExecute(result)
        }
    }
}