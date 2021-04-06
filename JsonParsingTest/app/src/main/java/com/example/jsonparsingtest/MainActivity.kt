package com.example.jsonparsingtest

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.JsonReader
import android.view.textclassifier.TextClassification
import android.view.textclassifier.TextLinks
import okhttp3.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //fetchJsonDataSingleElement()
        fetchJsonData2()
    }

    fun fetchJsonData()
    {
        println("Attempt to fetch data")
        val url = "https://jsonplaceholder.typicode.com/users"
        val request= Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {

            override fun onResponse(call: Call?, response: Response?) {
                val body=response?.body()?.string()
                val json = JSONArray(body)
                for(i in 0 until json.length()) {
                    val body = json.getJSONObject(i).getJSONObject("address").getJSONObject("geo").get("lat")
                    val body2=json.getJSONObject(i).get("username")
                    println(body)
                }
            }
            override fun onFailure(call: Call?, e: IOException?) {
                println("Failed to execute")
            }
        })
    }

    fun fetchJsonData2(){
        val url="https://jsonplaceholder.typicode.com/users"
        val request=Request.Builder().url(url).build()
        val client=OkHttpClient()
        client.newCall(request).enqueue(object:Callback{
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call, response: Response) {
                val body=response?.body()?.string()
                val json=JSONArray(body)
                val name=json.getJSONObject(3).get("name")
                val street=json.getJSONObject(3).getJSONObject("address").get("street")
                val lattitude=json.getJSONObject(3).getJSONObject("address").getJSONObject("geo").get("lat")
                val phone=json.getJSONObject(3).get("phone")
                val bs=json.getJSONObject(3).getJSONObject("company").get("bs")
                println("Name: "+name)
                println("Street: "+street)
                println("Lattitude: "+lattitude)
                println("Phone: "+phone)
                println("Bs: "+bs)

            }
        })
    }

    fun fetchJsonDataAllUserAddressDetails(){
        val url="https://jsonplaceholder.typicode.com/users"
        val request=Request.Builder().url(url).build()
        val client =OkHttpClient()
        client.newCall(request).enqueue(object :Callback{
            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {
                val body=response?.body()?.string()
                val json=JSONArray(body)
                for(i in 0 until json.length())
                {
                    val allUserAddress=json.getJSONObject(i).get("address")
                    println(allUserAddress)
                }
            }
        } )
    }

    fun fetchJsonDataSingleElementAddress() {

        val url="https://jsonplaceholder.typicode.com/users"
        val request=Request.Builder().url(url).build()
        val client =OkHttpClient()
        client.newCall(request).enqueue(object:Callback{
            override fun onFailure(call: Call, e: IOException) {
                //TODO("Not yet implemented")
            }

            override fun onResponse(call: Call?, response: Response?) {
                //TODO("Not yet implemented")

                val body=response?.body()?.string()
                val json=JSONArray(body)
                val address=json.getJSONObject(3).get("address")
                println(address)
            }

        })
    }

    fun fetchJsonDataSingleElement()
    {
        println("Fetching Single User full")
        val url = "https://jsonplaceholder.typicode.com/users"
        val request= Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {

            override fun onResponse(call: Call?, response: Response?) {
                val body=response?.body()?.string()
                val json=JSONArray(body)
                val name=json[3]
                println(name)
            }
            override fun onFailure(call: Call?, e: IOException?) {
                println("Failed to execute")
            }
        })
    }

}