package com.example.fragmentkotlin

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.fragment_a.view.*
import kotlinx.android.synthetic.main.fragment_b.view.*
import kotlinx.android.synthetic.main.fragment_c.view.*

class PageTransformer : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        var fgA = page.fgA
        var fgB = page.fgB
        var fgC = page.fgC
        page.apply {
            translationY = Math.abs(position) * 500f
            scaleX = 1f
            scaleY = 1f
        }
    }
}