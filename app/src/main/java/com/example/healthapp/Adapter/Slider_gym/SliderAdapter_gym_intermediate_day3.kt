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

class SliderAdapter_gym_intermediate_day3(val context: Context) : PagerAdapter() {

    lateinit var layoutInflater: LayoutInflater
    lateinit var slideImageView : ImageView
    lateinit var slideHeading : TextView
    lateinit var slideDescription : TextView

    val slide_images = arrayOf(

        R.drawable.front_squats,
        R.drawable.leg_extension,
        R.drawable.hamstring_curls,
        R.drawable.calves
    )

    val slide_headings = arrayOf(
        "Front Squats – 5 sets of 20-8 (Pyramiding) reps" ,
        "Leg Extensions – 5 sets of 10 reps" ,
        "Hamstring Curls – 5 sets of 6-10 reps" ,
        "Standing Calf Raise – 3 sets of 8-12 reps"

    )

    val slide_descs = arrayOf(
        "Begin with the barbell across the front side of your shoulders. Place your fingertips under the barbell just outside of your shoulders and drive your elbows up. Keeping your chest up and core tight, bend at your hips and knees to lower into a squat until your thighs are parallel to the ground",
        "Place your hands on the hand bars.\n" +
                "Lift the weight while exhaling until your legs are almost straight. Do not lock your knees. Keep your back against the backrest and do not arch your back.\n" +
                "Exhale and lower the weight back to starting position.\n" +
                "Do three sets of eight to 12 repetitions.",
        "Lie on your back. Put your calves and heels on a stability ball. ...\n" +
                "Move your hips upward until your body is straight. Engage your glutes.\n" +
                "Slowly lift your hips and bend your knees. ...\n" +
                "Extend your knees and lower your hips and back to the floor.\n" +
                "Complete 12 to 15 reps.",
        "Stand up straight, then push through the balls of your feet and raise your heel until you are standing on your toes. Then lower slowly back to the start."

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