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

class SliderAdapter_gym_intermediate_day4(val context: Context) : PagerAdapter() {

    lateinit var layoutInflater: LayoutInflater
    lateinit var slideImageView : ImageView
    lateinit var slideHeading : TextView
    lateinit var slideDescription : TextView

    val slide_images = arrayOf(

        R.drawable.barbell_bench_press,
        R.drawable.tricep_kickback,
        R.drawable.dumbell_lateral_rise
    )

    val slide_headings = arrayOf(
        "Barbell Bench Press – 3 sets of 10, 10, 8 reps",
        "Tricep Kickback – 3 sets of 10 reps",
        "One Arm Cable Lateral Raise – 3 sets of 12 reps"
    )

    val slide_descs = arrayOf(
        "Lie on the bench with your eyes under the bar\n" +
                "   Grab the bar with a medium grip-width (thumbs around the bar!)\n" +
                "    Unrack the bar by straightening your arms\n" +
                "    Lower the bar to your mid-chest\n" +
                "   Press the bar back up until your arms are straight\n" +
                "   Hold the weight for a second at the top, with straight arms. Breathe. Then take a big breath, hold it, and lower the bar again. Keep your butt on the bench when you press it back up.",

        " Hold a dumbbell in each hand with your palms facing in toward each other, keeping your knees bent slightly.\n" +
                "Engage your core and maintain a straight spine as you hinge forward at the waist, bringing your torso almost parallel to the floor.\n" +
                "Keep your upper arms in close to your body and your head in line with your spine, tucking your chin in slightly.\n" +
                "On an exhale, engage your triceps by straightening your elbows.\n" +
                "Hold your upper arms still, only moving your forearms during this movement.\n" +
                "Pause here, then inhale to return the weights to the starting position.",

    "Hold one dumbbell by your side and one in front. Lift to the side and front simultaneously. Lower back down under control.\n" +
            "\n" +
            "Alternate sides with each rep.")




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