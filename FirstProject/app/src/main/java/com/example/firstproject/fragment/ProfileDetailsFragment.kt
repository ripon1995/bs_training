package com.example.firstproject.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstproject.R
import com.example.firstproject.adapter.PostAdapter
import com.example.firstproject.model.DataX
import com.example.firstproject.model.PostData
import com.example.firstproject.network.ApiInterface
import com.example.firstproject.network.RetrofitApiClient
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileDetailsFragment constructor() : Fragment() {

    private var id: String? = null
    private var imageSource: String? = null
    private var firstImageSource: String? = null
    private var secondImageSource: String? = null
    private var thirdImageSource: String? = null
    private var fourthImageSource: String? = null
    private var name: String? = null

    private lateinit var firstPhoto: ImageView
    private lateinit var secondPhoto: ImageView
    private lateinit var thirdPhoto: ImageView
    private lateinit var fourthPhoto: ImageView

    private lateinit var postAdapter: PostAdapter
    private var callback: FragmentCallback? = null

    constructor(callback: FragmentCallback?) : this() {
        this.callback = callback
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        val view: View = inflater.inflate(R.layout.profile_details, container, false)

        //val back=view.findViewById<Button>(R.id.btnBack)
        id = arguments?.getString("ownerId")
        val profileImage = view.findViewById<ImageView>(R.id.imageProfile)
        firstPhoto = view.findViewById<ImageView>(R.id.imgPhotosFirst)
        secondPhoto = view.findViewById<ImageView>(R.id.imgPhotosSecond)
        thirdPhoto = view.findViewById<ImageView>(R.id.imgPhotosThird)
        fourthPhoto = view.findViewById<ImageView>(R.id.imgPhotosFourth)
        val profileName = view.findViewById<TextView>(R.id.tvProfileName)
        val profileTitle = view.findViewById<TextView>(R.id.tvProfileTitle)
        val postCounter = view.findViewById<TextView>(R.id.tvPostCounter)
        val followerCounter = view.findViewById<TextView>(R.id.tvFollowersCounter)
        val followingCounter = view.findViewById<TextView>(R.id.tvFollowingCounter)
        name =
            arguments?.getString("ownerFirstName") + " " + arguments?.getString("ownerLastName")
        imageSource = arguments?.getString("ownerPicture")
        Picasso.with(view.context).load(imageSource).into(profileImage)
        profileName.text = name
        profileTitle.text = arguments?.getString("ownerTitle")
        postCounter.text = (arguments?.getInt("likes")?.times(5)).toString()
        followerCounter.text = (arguments?.getInt("likes")?.times(6)).toString()
        followingCounter.text = (arguments?.getInt("likes")?.times(2)).toString()
//        back.setOnClickListener {
//            println("DONE")
//            val newsFragment=NewsFragment()
//            callback?.changeFragment(newsFragment)
//        }

        prepareItems(view)
        return view
    }

    private fun prepareAdapter(items: List<DataX>, view: View) {

        firstImageSource = items.get(0).image
        secondImageSource = items.get(1).image
        thirdImageSource = items.get(2).image
        fourthImageSource = items.get(3).image
        Picasso.with(view.context).load(firstImageSource).into(firstPhoto)
        Picasso.with(view.context).load(secondImageSource).into(secondPhoto)
        Picasso.with(view.context).load(thirdImageSource).into(thirdPhoto)
        Picasso.with(view.context).load(fourthImageSource).into(fourthPhoto)

        val recyclerView: RecyclerView = view.findViewById(R.id.recView)
        postAdapter = PostAdapter(items, imageSource!!, name!!)
        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = postAdapter
    }

    private fun prepareItems(view: View) {
        val dataList = mutableListOf<DataX>()

        val apiInterface: ApiInterface =
            RetrofitApiClient.getClient()!!.create(ApiInterface::class.java)
        val call: Call<PostData> = apiInterface.getPost(id!!)

        call.enqueue(object : Callback<PostData?> {
            override fun onResponse(call: Call<PostData?>, response: Response<PostData?>) {
                val myResponse = response.body()
                val list: List<DataX>
                if (response.code() == 200 && myResponse != null) {
                    list = myResponse.data
                    dataList.addAll(list)
                    prepareAdapter(dataList, view)
                }
            }

            override fun onFailure(call: Call<PostData?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }
}