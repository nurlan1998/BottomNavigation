package com.example.fragmentkotlin

import androidx.fragment.app.Fragment

class FragmentB : Fragment(R.layout.fragment_b) {
    companion object{
        fun newInstance() = FragmentB()
    }
}