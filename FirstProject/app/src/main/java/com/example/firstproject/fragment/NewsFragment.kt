package com.example.firstproject.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstproject.R
import com.example.firstproject.adapter.CustomAdapter
import com.example.firstproject.model.Data
import com.example.firstproject.model.MyData
import com.example.firstproject.network.ApiInterface
import com.example.firstproject.network.RetrofitApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsFragment constructor() : Fragment(), CustomAdapter.CustomAdapterCallback {
    private lateinit var customAdapter: CustomAdapter
    private var callback: FragmentCallback? = null

    constructor(callback: FragmentCallback) : this() {
        this.callback = callback
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.news, container, false)
        prepareItems(view)
        return view
    }

    override fun onNewsItemClick(item: Data) {
        val fragment = ProfileDetailsFragment(callback)
        val bundle = Bundle()
        bundle.putString("ownerId", item.owner.id)
        bundle.putString("ownerEmail", item.owner.email)
        bundle.putString("ownerTitle", item.owner.title)
        bundle.putString("ownerPicture", item.owner.picture)
        bundle.putString("ownerFirstName", item.owner.firstName)
        bundle.putString("ownerLastName", item.owner.lastName)
        bundle.putString("publishDate", item.publishDate)
        bundle.putInt("likes", item.likes)
        bundle.putString("firstChip", item.tags.get(0))
        bundle.putString("secondChip", item.tags.get(1))
        bundle.putString("thirdChip", item.tags.get(2))

        fragment.arguments = bundle
        callback?.changeFragment(fragment)
    }

    private fun prepareAdapter(items: List<Data>, view: View) {
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        customAdapter = CustomAdapter(items, this)
        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = customAdapter
    }

    private fun prepareItems(view: View) {
        val dataList = mutableListOf<Data>()

        val apiInterface: ApiInterface =
            RetrofitApiClient.getClient()!!.create(ApiInterface::class.java)
        val call: Call<MyData> = apiInterface.getData()

        call.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                val myresponse = response.body()

                val list: List<Data>
                if (response.code() == 200 && myresponse != null) {
                    list = myresponse.data
                    dataList.addAll(list)
                    prepareAdapter(dataList, view)
                }
            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {

            }
        })
    }
}