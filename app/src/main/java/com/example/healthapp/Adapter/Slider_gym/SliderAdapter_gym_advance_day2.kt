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

class SliderAdapter_gym_advance_day2 (val context: Context) : PagerAdapter() {

    lateinit var layoutInflater: LayoutInflater
    lateinit var slideImageView : ImageView
    lateinit var slideHeading : TextView
    lateinit var slideDescription : TextView

    val slide_images = arrayOf(

        R.drawable.squat,
        R.drawable.legpress,
        R.drawable.stiffed_legged_deadlift,
        R.drawable.hamstring_curls,
        R.drawable.calf_raises

    )

    val slide_headings = arrayOf(
        "Squats",
        "Leg Press – 3 sets of 6-10 reps" ,
        "Stiff-Legged Deadlift – 5 sets of 5 reps" ,
        "Hamstring Curls – 3 sets of 6-8 reps",
        "Calf-Raise – 5 sets of 10 reps"

    )

    val slide_descs = arrayOf(
        "Stand with your feet slightly wider than your hips.\n" +
                "Your toes should be pointed slightly outward – about 5 to 20 degrees outward (the wider your stance, the more you’ll want to rotate your feet outward).\nLook straight ahead and pick a spot on the wall in front of you.\n" +
                "Look at this spot the entire time you squat, not looking down at the floor or up at the ceiling.",
        "Lie on a mat face up. Lift your feet off of the mat. ...\n" +
                "Wrap the band around your feet and hold the ends. Keep your feet side by side.\n" +
                "Press your feet against the bands until your legs are straight.\n" +
                "Bend your knees to return to a 90-degree angle.\n",
        "Stand with your feet shoulder-width apart holding a barbell in an overhand grip (palms facing you). Your knees should be slightly bent and the aim is to maintain this slight degree of flex throughout the movement. Bend at your hips and lower the barbell, keeping your back straight.",
        "Stand with your feet hip-width apart. Place your hands on your waist or on a chair for balance. Shift your weight onto your left leg.\n" +
                "Slowly bend your right knee, bringing your heel toward your butt. Keep your thighs parallel.\n" +
                "Slowly lower your foot.\n" +
                "Repeat with the other leg.",
        "Start in a standing position with your feet at hip width and your arms by your sides. Keep a straight back and good upright posture, looking straight ahead. From here, contract your calf muscles, hamstrings and glutes so that you raise up on to your toes by lifting your heels up as high as you can."
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