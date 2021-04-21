package com.example.firstproject.ui.features.news.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstproject.R
import com.example.firstproject.adapter.PostAdapter
import com.example.firstproject.fragment.FragmentCallback
import com.example.firstproject.fragment.ProfileDetailsFragment
import com.example.firstproject.dataSource.model.Post
import com.example.firstproject.dataSource.model.UserData
import com.example.firstproject.network.ApiInterface
import com.example.firstproject.network.RetrofitApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsFragment constructor() : Fragment(), PostAdapter.CustomAdapterCallback,NewsView {
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
        return view
    }

    override fun onNewsItemClick(item: Post) {
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
    override fun showNewsList(newsList: List<Post>) {
        val recyclerView: RecyclerView? = view?.findViewById(R.id.recycler_view)
        postAdapter = PostAdapter(newsList, this)
        val layoutManager = LinearLayoutManager(context)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = postAdapter
    }
}