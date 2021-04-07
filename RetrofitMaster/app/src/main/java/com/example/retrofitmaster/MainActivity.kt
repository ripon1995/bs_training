package com.example.retrofitmaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.contentValuesOf
import com.example.retrofitmaster.model.MyAlbums
import com.example.retrofitmaster.model.MyAlbumsItem
import com.example.retrofitmaster.network.ApiInterface
import com.example.retrofitmaster.network.RetrofitApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    lateinit var layout:LinearLayout
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showData()
        textView=findViewById(R.id.tvAll)
    }

    private fun showData(){
        val apiInterface:ApiInterface=
            RetrofitApiClient.getClient()!!.create(ApiInterface::class.java)
        val call:Call<List<MyAlbumsItem>> = apiInterface.getAlbums()

        call.enqueue(object : Callback<List<MyAlbumsItem>?> {
            override fun onResponse(
                call: Call<List<MyAlbumsItem>?>,
                response: Response<List<MyAlbumsItem>?>
            ) {
                val myAlbumsItemResponse:List<MyAlbumsItem> =response.body()!!
                if(response.code()==200)
                {
                    val myStringBuilder=StringBuilder()
                    for(myData in myAlbumsItemResponse)
                    {
                        println("Title: "+myData.title)
                        myStringBuilder.append("ID: "+myData.id+"\nUserId: "+myData.userId+"\nTitle: "+myData.title+"\n\n\n")
                    }
                    textView.text=myStringBuilder
                }
            }

            override fun onFailure(call: Call<List<MyAlbumsItem>?>, t: Throwable) {
                println("Error: "+t.message)
            }
        })
    }
}