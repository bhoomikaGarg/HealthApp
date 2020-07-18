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

class SliderAdapter_gym_advance_day3 (val context: Context) : PagerAdapter() {

    lateinit var layoutInflater: LayoutInflater
    lateinit var slideImageView : ImageView
    lateinit var slideHeading : TextView
    lateinit var slideDescription : TextView

    val slide_images = arrayOf(

        R.drawable.dumbell_military_press,
        R.drawable.dumbell_lateral_rise,
        R.drawable.barbell_curls,
        R.drawable.dumbbell_curls
    )

    val slide_headings = arrayOf(
        "Military Press or Dumbbell Press – 3 sets of 6-8" ,
        "Lateral Raises – 5 sets of 10 reps" ,
        "Barbell Curls – 5 sets of 6-10 reps",
        "Dumbbell Curls – 3 sets of 6-10 reps"

    )

    val slide_descs = arrayOf(
        "Sit on an upright bench holding a dumbbell in each hand at shoulder height with your palms facing away from you. Keep your chest up and your core braced, and look straight forward throughout the move. Press the weights directly upwards until your arms are straight and the weights touch above your head.",
        "All you need is a set of dumbbells (start with a pair between 5 to 15 pounds if you're a beginner), and enough space to raise your arms in a \"T\" formation out to each side.",
        "Before you pick up a weight, stand with your arms at your sides and palms facing out. Your hands will be wider than shoulder width. That should be the strongest and most joint-friendly grip for you.\n" +
                "Now load a barbell, either on the floor or, if you’re training at home or in a mostly empty gym, the supports of a squat rack. ",
        "Stand holding a dumbbell in each hand with your arms hanging by your sides. Ensure your elbows are close to your torso and your palms facing forward. Keeping your upper arms stationary, exhale as you curl the weights up to shoulder level while contracting your biceps. Use a thumb-less grip, advises Edgley."
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