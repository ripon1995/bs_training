package com.example.hotelorderwithdi.ui.activity.mainActivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hotelorder.dataSource.model.OrderItem
import com.example.hotelorderwithdi.R
import com.example.hotelorderwithdi.ui.activity.mainActivity2.MainActivity2
import com.example.hotelorderwithdi.ui.activity.seekBarWithCallBack.SeekBarActivityWithCallBack
import com.example.hotelorderwithdi.ui.activity.seekBarWithLiveData.SeekBarActivityWithLiveData
import com.example.hotelorderwithdi.ui.activity.seekBarWithRxJava.SeekBarTestActivityWithRXJava
import com.example.hotelorderwithdi.ui.adapter.OrderAdapter
import com.example.hotelorderwithdi.viewModel.mainActivity.MainActivityViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {


    lateinit var mainActivityViewModel: MainActivityViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    lateinit var button: Button
    lateinit var button2: Button
    lateinit var button3: Button
    lateinit var button4: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.btnNextWithLiveData)
        button2 = findViewById(R.id.btnNextWithRxJava)
        button3 = findViewById(R.id.btnNextWithCallBack)
        button4 = findViewById(R.id.btnMainActivity2)
        button.setOnClickListener {
            val intent = Intent(this, SeekBarActivityWithLiveData::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener {
            val intent = Intent(this, SeekBarTestActivityWithRXJava::class.java)
            startActivity(intent)
        }

        button3.setOnClickListener {
            val intent = Intent(this, SeekBarActivityWithCallBack::class.java)
            startActivity(intent)
        }

        button4.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        mainActivityViewModel =
            ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)
        mainActivityViewModel.fetchOrderDetails()
        mainActivityViewModel.orderListLiveData.observe(this) {
            showOrderList(it)
        }
    }

    fun showOrderList(orderList: List<OrderItem>) {
        val recyclerView: RecyclerView = findViewById(R.id.orderRecyclerView)
        val orderAdapter = OrderAdapter(orderList)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = orderAdapter
    }


}

