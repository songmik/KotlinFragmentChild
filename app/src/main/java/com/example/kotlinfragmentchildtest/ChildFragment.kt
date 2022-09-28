package com.example.kotlinfragmentchildtest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlinfragmentchildtest.databinding.FragmentChildBinding

class ChildFragment : Fragment(), FragmentListener {

    private lateinit var mFragmentListener: FragmentListener
    private var _binding : FragmentChildBinding ?= null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentChildBinding.inflate(inflater, container, false)
        val rootView = binding.root



        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding!!.btnChild.setOnClickListener {
            mFragmentListener = parentFragment as ParentFragment
            mFragmentListener.onReceiveData("Child에서 보낸 데이터 Parent의 값을 바꿔줌")
        }


//        // Bundle로 ParentFragment의 값을 받을 때
//        val bundle = arguments
//        _binding!!.tvChild.text = bundle!!.getString("data")
    }

    override fun onReceiveData(data: String) {
        _binding!!.tvChild.text = data
    }

}