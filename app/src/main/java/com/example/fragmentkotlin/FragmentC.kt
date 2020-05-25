package com.example.fragmentkotlin

import androidx.fragment.app.Fragment

class FragmentC : Fragment(R.layout.fragment_c) {
    companion object{
        fun newInstance() = FragmentC()
    }
}