package com.example.firstproject.ui.features.news.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstproject.R
import com.example.firstproject.dataSource.RestApiDataSource
import com.example.firstproject.dataSource.RestApiDataSourceImplementation
import com.example.firstproject.dataSource.model.Post
import com.example.firstproject.fragmentCallbacks.FragmentCallback
import com.example.firstproject.ui.features.news.presenter.NewsPresenter
import com.example.firstproject.ui.features.news.presenter.NewsPresenterImplentation
import com.example.firstproject.ui.features.profile.view.ProfileDetailsInfoAndPostFragment

class NewsFragment constructor() : Fragment(), PostAdapter.CustomAdapterCallback, NewsView {
    private lateinit var postAdapter: PostAdapter
    private var callback: FragmentCallback? = null
    private lateinit var newsPresenterImplentation: NewsPresenter
    private lateinit var restApiDataSourceImplementation: RestApiDataSource

    constructor(callback: FragmentCallback) : this() {
        this.callback = callback
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        restApiDataSourceImplementation = RestApiDataSourceImplementation()
        newsPresenterImplentation = NewsPresenterImplentation(restApiDataSourceImplementation, this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.news, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsPresenterImplentation.fetchNews()
    }

    override fun onNewsItemClick(item: Post) {
        val fragment = ProfileDetailsInfoAndPostFragment(callback)
        val bundle = Bundle()
        bundle.putString("ownerId", item.user.id)
        bundle.putString("ownerPicture", item.user.picture)
        bundle.putString("ownerFirstName", item.user.firstName)
        bundle.putString("ownerLastName", item.user.lastName)
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