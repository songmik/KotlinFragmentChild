package com.example.kotlinfragmentchildtest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlinfragmentchildtest.databinding.FragmentParentBinding

class ParentFragment : Fragment(), FragmentListener {

    private var _binding : FragmentParentBinding ? = null
    private val binding get() = _binding!!
    private lateinit var mFragmentListener: FragmentListener
    private var fragmentChild = ChildFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentParentBinding.inflate(inflater, container, false)
        val rootView = binding.root

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val transaction = childFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayoutChild, fragmentChild).commit()

        _binding!!.btnParent.setOnClickListener {
            mFragmentListener = fragmentChild
            mFragmentListener.onReceiveData("Parent에서 보낸 데이터로 Child의 text를 바꿔줌")
        }


//        //Bundle로 데이터를 보내고 싶을 때
//
//        _binding!!.btnParent.setOnClickListener {
//            val bundle = Bundle().apply { putString("data", "Parent -> Child") }
//            val fragmentChild = ChildFragment().apply { arguments = bundle }
//            val transaction = childFragmentManager.beginTransaction()
//            transaction.add(R.id.frameLayoutChild, fragmentChild).commit()
//        }
    }

    override fun onReceiveData(data: String) {
        _binding!!.tvParent.text = data
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}