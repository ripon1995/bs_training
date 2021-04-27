package com.example.firstproject.ui.features.profile.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstproject.R
import com.example.firstproject.dataSource.RestApiDataSource
import com.example.firstproject.dataSource.RestApiDataSourceImplementation
import com.example.firstproject.dataSource.model.ProfileOwner
import com.example.firstproject.dataSource.model.ProfilePost
import com.example.firstproject.fragmentCallbacks.FragmentCallback
import com.example.firstproject.ui.features.profile.presenter.ProfilePostPresenter
import com.squareup.picasso.Picasso
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ProfileDetailsInfoAndPostFragment constructor() : DaggerFragment(), ProfileView {

    private var id: String? = null
    private var imageSource: String? = null
    private var name: String? = null
    private var profileImage: ImageView? = null
    private var profileName: TextView? = null
    private var profileTitle: TextView? = null
    private var postCounter: TextView? = null
    private var followerCounter: TextView? = null
    private var followingCounter: TextView? = null


    private lateinit var linearLayout: LinearLayout
    private lateinit var restApiDataSourceImplementation: RestApiDataSource

    @Inject
    lateinit var profilePostPresenter: ProfilePostPresenter
    private lateinit var profilePostAdapter: ProfilePostAdapter
    private var callback: FragmentCallback? = null


    constructor(callback: FragmentCallback?) : this() {
        this.callback = callback
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        restApiDataSourceImplementation = RestApiDataSourceImplementation()
        profilePostPresenter.bindView(this)
//        profilePostPresenter =
//            ProfilePostPresenterImplementation(restApiDataSourceImplementation, this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        id?.let {
            profilePostPresenter.fetchProfilePost(it)
            profilePostPresenter.fetchProfileInfo(it)
        }

    }

    override fun onStop() {
        super.onStop()
        profilePostPresenter.detachView()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view: View = inflater.inflate(R.layout.profile_posts, container, false)
        id = arguments?.getString("ownerId")
        profileImage = view.findViewById<ImageView>(R.id.imageViewProfile)
        profileName = view.findViewById<TextView>(R.id.tvProfileName)
        profileTitle = view.findViewById<TextView>(R.id.tvProfileTitle)
        postCounter = view.findViewById<TextView>(R.id.tvPostCounter)
        followerCounter = view.findViewById<TextView>(R.id.tvFollowerCounter)
        followingCounter = view.findViewById<TextView>(R.id.tvFollowingCounter)
        linearLayout = view.findViewById(R.id.linearLayoutPhotos)
        name = arguments?.getString("ownerFirstName") + " " + arguments?.getString("ownerLastName")
        imageSource = arguments?.getString("ownerPicture")
        return view
    }

    override fun showProfilePostList(profileList: List<ProfilePost>) {
        addPhoto(profileList, view!!)
        val recyclerView: RecyclerView? = view?.findViewById(R.id.recyclerView)
        profilePostAdapter = ProfilePostAdapter(profileList, imageSource!!, name!!)
        val layoutManager: LinearLayoutManager = LinearLayoutManager(context)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = profilePostAdapter
    }

    override fun showProfileInfoDetails(profileOwner: ProfileOwner) {
        profileName?.text = profileOwner.firstName + " " + profileOwner.lastName
        profileTitle?.text = profileOwner.title
        postCounter?.text = "30"
        followerCounter?.text = "40"
        followingCounter?.text = "50"
        Picasso.with(context).load(profileOwner.picture).into(profileImage)
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


}