package com.example.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<Binding : ViewBinding> : Fragment() {

    protected lateinit var binding: Binding
    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("BaseFragment: onCreateView")
        binding = bindingInflater.invoke(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        println("Base fragment: onAttach")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("Base fragment: onDestroy")
    }
}