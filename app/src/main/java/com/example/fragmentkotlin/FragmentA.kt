package com.example.fragmentkotlin

import androidx.fragment.app.Fragment

class FragmentA : Fragment(R.layout.fragment_a) {
    companion object{
        fun newInstance() = FragmentA()
    }
}