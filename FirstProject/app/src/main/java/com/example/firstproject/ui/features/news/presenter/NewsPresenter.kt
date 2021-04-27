package com.example.firstproject.ui.features.news.presenter

import com.example.firstproject.ui.features.news.view.NewsView
import java.lang.ref.WeakReference

abstract class NewsPresenter {

    var view: WeakReference<NewsView> = WeakReference(null)

    abstract fun fetchNews()

    fun bindView(view: NewsView) {
        this.view = WeakReference(view)
    }

    fun detachView() {
        view.clear()
    }
}