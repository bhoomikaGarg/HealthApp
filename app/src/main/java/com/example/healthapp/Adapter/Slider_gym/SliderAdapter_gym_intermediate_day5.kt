package com.example.healthapp.Adapter.Slider_gym

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.healthapp.R

class SliderAdapter_gym_intermediate_day5(val context: Context) : PagerAdapter() {

    lateinit var layoutInflater: LayoutInflater
    lateinit var slideImageView : ImageView
    lateinit var slideHeading : TextView
    lateinit var slideDescription : TextView

    val slide_images = arrayOf(

        R.drawable.barbell_row,
        R.drawable.barbell_shrugs,
        R.drawable.pullups,
        R.drawable.pulldown
    )

    val slide_headings = arrayOf(
        "Barbell Rows – 5 sets of 20-8 (Pyramiding) reps" ,
        "Barbell Shrugs – 3 sets of 15-20 reps" ,
        "Pullups – 3 sets of 6-10 reps" ,
        "Pulldowns – 3 sets of 6-10 reps"

    )

    val slide_descs = arrayOf(
        "Stand with your mid-foot under the bar (medium stance)\n" +
                "Bend over and grab the bar (palms down, medium-grip)\n" +
                "Unlock your knees while keeping your hips high\n" +
                "Lift your chest and straighten your back\n" +
                "Pull the bar against your lower chest\n" +
                "\n" ,
        "Step 1 Standing with your feet shoulder-width apart, place a barbell in front of your thighs, hands shoulder-width apart, palms facing your body, and arms fully extended.\n Step 2 Keeping your arms straight, shrug your shoulders as high as you can. Pause, then lower to the start position.",
        "Grab The Bar. Grip it about shoulder-width apart. ...\n" +
                "Hang. Raise your feet off the floor by bending your knees. ...\n" +
                "Pull. Pull yourself up by pulling your elbows down to the floor. ...\n" +
                "Pass The bar. Pull yourself all the way up until your chin passes the bar. ...\n" +
                "Repeat. Lower yourself all the way down until your arms are straight.",
        "Hold a short bar above your head with an overhand grip, palms facing forwards. Pull the bar down by bringing your elbows in to your sides. Then press the bar down, keeping your elbows by your sides. Reverse the movement to return to the starting position."
    )

    override fun getCount(): Int {
        return slide_headings.size
    }
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as RelativeLayout
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view = layoutInflater.inflate(R.layout.slider_gym_layout, container, false)

        slideImageView =  view.findViewById(R.id.imgYogaPose)
        slideHeading = view.findViewById(R.id.txtYogaName)
        slideDescription= view.findViewById(R.id.txtYogaDesc)

        slideImageView.setImageResource(slide_images[position])
        slideHeading.text = slide_headings[position]
        slideDescription.text = slide_descs[position]

        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as RelativeLayout)
    }

}