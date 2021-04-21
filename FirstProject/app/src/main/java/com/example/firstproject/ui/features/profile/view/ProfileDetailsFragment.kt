package com.example.firstproject.ui.features.profile.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstproject.R
import com.example.firstproject.adapter.ProfileSpecificPostAdapter
import com.example.firstproject.dataSource.RestApiDataSource
import com.example.firstproject.dataSource.RestApiDataSourceImplementation
import com.example.firstproject.dataSource.model.ProfilePost
import com.example.firstproject.fragmentCallbacks.FragmentCallback
import com.example.firstproject.ui.features.profile.presenter.ProfilePresenter
import com.example.firstproject.ui.features.profile.presenter.ProfilePresenterImplementation
import com.squareup.picasso.Picasso

class ProfileDetailsFragment constructor() : Fragment(), ProfileView {

    private var id: String? = null
    private var imageSource: String? = null
    private var name: String? = null
    private lateinit var linearLayout: LinearLayout
    private lateinit var restApiDataSourceImplementation: RestApiDataSource
    private lateinit var profilePresenterImplementation: ProfilePresenter
    private lateinit var profileSpecificPostAdapter: ProfileSpecificPostAdapter
    private var callback: FragmentCallback? = null

    constructor(callback: FragmentCallback?) : this() {
        this.callback = callback
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        restApiDataSourceImplementation = RestApiDataSourceImplementation()
        //profilePresenterImplementation=ProfilePresenterImplementation(restApiDataSourceImplementation,this, this.id!!)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profilePresenterImplementation.fetchProfile()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view: View = inflater.inflate(R.layout.profile_posts, container, false)
        id = arguments?.getString("ownerId")
        profilePresenterImplementation =
            ProfilePresenterImplementation(restApiDataSourceImplementation, this, this.id!!)
        val profileImage = view.findViewById<ImageView>(R.id.imageViewProfile)
        val profileName = view.findViewById<TextView>(R.id.tvProfileName)
        val profileTitle = view.findViewById<TextView>(R.id.tvProfileTitle)
        val postCounter = view.findViewById<TextView>(R.id.tvPostCounter)
        val followerCounter = view.findViewById<TextView>(R.id.tvFollowerCounter)
        val followingCounter = view.findViewById<TextView>(R.id.tvFollowingCounter)
        linearLayout = view.findViewById(R.id.linearLayoutPhotos)
        name =
            arguments?.getString("ownerFirstName") + " " + arguments?.getString("ownerLastName")
        imageSource = arguments?.getString("ownerPicture")
        Picasso.with(view.context).load(imageSource).into(profileImage)
        profileName.text = name
        profileTitle.text = arguments?.getString("ownerTitle")
        postCounter.text = (arguments?.getInt("likes")?.times(5)).toString()
        followerCounter.text = (arguments?.getInt("likes")?.times(6)).toString()
        followingCounter.text = (arguments?.getInt("likes")?.times(2)).toString()
        return view
    }

    private fun addPhoto(items: List<ProfilePost>, view: View) {
        var counter: Int = 0
        for (i in items) {
            counter++
            if (counter > 4) break
            val imageView = ImageView(view.context)
            Picasso.with(view.context).load(i.image).into(imageView)
            linearLayout.addView(imageView)
        }

    }

    override fun showProfileList(profileList: List<ProfilePost>) {
        addPhoto(profileList, view!!)
        val recyclerView: RecyclerView? = view?.findViewById(R.id.recyclerView)
        profileSpecificPostAdapter = ProfileSpecificPostAdapter(profileList, imageSource!!, name!!)
        val layoutManager: LinearLayoutManager = LinearLayoutManager(context)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = profileSpecificPostAdapter
    }

}