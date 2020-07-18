package com.example.healthapp.activity.gymActivity

import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.healthapp.Adapter.Slider_gym.SliderAdapter_gym_advance_day3
import com.example.healthapp.R

class Gym_Activity_advance_day3  : AppCompatActivity() {
    lateinit var mSlideViewPager: ViewPager
    lateinit var mDotLayout: LinearLayout

    lateinit var mNextBtn: Button
    lateinit var mBackBtn: Button

    private var mCurrentPage = 0

    private lateinit var mDots: Array<TextView?>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gym_)

        mSlideViewPager = findViewById(R.id.slideViewPager)
        mDotLayout = findViewById(R.id.dotsLayout)

        mNextBtn = findViewById(R.id.nextBtn)
        mBackBtn = findViewById(R.id.prevBtn)

        val sliderAdapter =
            SliderAdapter_gym_advance_day3(
                this
            )

        mSlideViewPager.adapter = sliderAdapter

        addDotsIndicator(0)

        mSlideViewPager.addOnPageChangeListener(viewListener)
        mNextBtn.setOnClickListener {
            mSlideViewPager!!.currentItem = mCurrentPage + 1
        }


        mBackBtn.setOnClickListener {
            mSlideViewPager!!.currentItem = mCurrentPage - 1
        }

    }

    fun addDotsIndicator(position: Int) {
        mDots = arrayOfNulls(4)
        mDotLayout.removeAllViews()
        for (i in mDots.indices) {
            mDots[i] = TextView(this)
            mDots[i]!!.text = Html.fromHtml("&#8226;")
            mDots[i]!!.textSize = 35f
            mDots[i]!!.setTextColor(resources.getColor(R.color.colorWhite))
            mDotLayout.addView(mDots[i])
        }
        if (mDots.isNotEmpty()) {
            mDots[position]!!.setTextColor(resources.getColor(R.color.colorAccent))
        }
    }

    var viewListener: ViewPager.OnPageChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
        }

        override fun onPageSelected(position: Int) {
            addDotsIndicator(position)
            mCurrentPage = position
            if (position == 0) {
                mNextBtn.isEnabled = true
                mBackBtn.isEnabled = false
                mBackBtn.visibility = View.INVISIBLE
                mNextBtn.text = "Next"
                mBackBtn.text = ""
            } else if (position == mDots.size - 1) {
                mNextBtn.isEnabled = true
                mBackBtn.isEnabled = true
                mBackBtn.visibility = View.VISIBLE
                mNextBtn.text = "Finish"
                mBackBtn.text = "Back"

            } else {
                mNextBtn.isEnabled = true
                mBackBtn.isEnabled = true
                mBackBtn.visibility = View.VISIBLE
                mNextBtn.text = "Next"
                mBackBtn.text = "Back"
            }
        }

        override fun onPageScrollStateChanged(state: Int) {}
    }
}