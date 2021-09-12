package com.example.basicmvvmwithdiwithgenericviewmodelfactory.ui.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.basicmvvmwithdiwithgenericviewmodelfactory.R
import com.example.basicmvvmwithdiwithgenericviewmodelfactory.dataSource.model.typeCodeData.SinglePost
import com.example.basicmvvmwithdiwithgenericviewmodelfactory.ui.adapter.PostAdapter
import com.example.basicmvvmwithdiwithgenericviewmodelfactory.viewModel.typeCode.TypeCodeViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class TypeCodeDataActivity : DaggerAppCompatActivity() {

    lateinit var viewModel: TypeCodeViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_type_code_data)

        viewModel = ViewModelProvider(this, viewModelFactory).get(TypeCodeViewModel::class.java)

        viewModel.fetchPostDetails()

        viewModel.postListLiveData.observe(this, {
            showPostList(it)
        })
    }

    private fun showPostList(postList: List<SinglePost>) {
        val recyclerView: RecyclerView = findViewById(R.id.postsRecyclerView)
        val postAdapter = PostAdapter(postList)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = postAdapter
    }
}