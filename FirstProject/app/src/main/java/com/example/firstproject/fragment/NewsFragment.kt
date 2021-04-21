package com.example.firstproject.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstproject.R
import com.example.firstproject.adapter.PostAdapter
import com.example.firstproject.model.Profile
import com.example.firstproject.model.UserData
import com.example.firstproject.network.ApiInterface
import com.example.firstproject.network.RetrofitApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsFragment constructor() : Fragment(), PostAdapter.CustomAdapterCallback {
    private lateinit var postAdapter: PostAdapter
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

    override fun onNewsItemClick(item: Profile) {
        val fragment = ProfileDetailsFragment(callback)
        val bundle = Bundle()
        bundle.putString("ownerId", item.user.id)
        bundle.putString("ownerEmail", item.user.email)
        bundle.putString("ownerTitle", item.user.title)
        bundle.putString("ownerPicture", item.user.picture)
        bundle.putString("ownerFirstName", item.user.firstName)
        bundle.putString("ownerLastName", item.user.lastName)
        bundle.putString("publishDate", item.publishDate)
        bundle.putInt("likes", item.likes)
        bundle.putString("firstChip", item.tags.get(0))
        bundle.putString("secondChip", item.tags.get(1))
        bundle.putString("thirdChip", item.tags.get(2))

        fragment.arguments = bundle
        callback?.changeFragment(fragment)
    }

    private fun prepareAdapter(items: List<Profile>, view: View) {
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        postAdapter = PostAdapter(items, this)
        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = postAdapter
    }

    private fun prepareItems(view: View) {
        val dataList = mutableListOf<Profile>()

        val apiInterface: ApiInterface =
            RetrofitApiClient.getClient()!!.create(ApiInterface::class.java)
        val call: Call<UserData> = apiInterface.getData()

        call.enqueue(object : Callback<UserData?> {
            override fun onResponse(call: Call<UserData?>, response: Response<UserData?>) {
                val myresponse = response.body()

                val list: List<Profile>
                if (response.code() == 200 && myresponse != null) {
                    list = myresponse.data
                    dataList.addAll(list)
                    prepareAdapter(dataList, view)
                }
            }

            override fun onFailure(call: Call<UserData?>, t: Throwable) {

            }
        })
    }
}