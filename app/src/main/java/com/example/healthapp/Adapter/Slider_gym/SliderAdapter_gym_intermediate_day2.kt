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

class SliderAdapter_gym_intermediate_day2(val context: Context) : PagerAdapter() {

    lateinit var layoutInflater: LayoutInflater
    lateinit var slideImageView : ImageView
    lateinit var slideHeading : TextView
    lateinit var slideDescription : TextView

    val slide_images = arrayOf(

        R.drawable.pulldown,
        R.drawable.machine_reverse,
        R.drawable.standing_barbell_curl,
        R.drawable.preacher_curl
    )

    val slide_headings = arrayOf(
        "Lat Pull Down – 3 sets of 10 reps",
        "Machine Reverse Fly – 3 sets of 10 reps",
        "Standing Barbell Curl – 3 sets of 8-10 reps",
        "Preacher Curl – 3 sets of 10 reps"

    )

    val slide_descs = arrayOf(
        "Keep your chin back and chest up as you pull the bar down, squeezing your shoulder blades down and back. Pause at the bottom of the movement (when the bar is at chest height), and then raise the bar as high as you can go. That's the movement!",
        "Sit up tall and relax your neck and shoulders. Your feet should be flat on the floor.\n" +
                "Grab the handles so that your palms are facing forward. Note that some machines have a foot bar that you need to push in order to release the handles and bring them forward.\n" +
                "Press your arms together in front of your chest with a slow, controlled movement. Keep a slight, soft bend in the elbows with wrists relaxed.\n" +
                "Pause for one second once your arms are fully \"closed\" in front of your chest.\n" +
                "Bring your arms slowly back to the starting position, opening your chest and keeping posture strong and upright.",
        "Before you pick up a weight, stand with your arms at your sides and palms facing out. Your hands will be wider than shoulder width. That should be the strongest and most joint-friendly grip for you.\n" +
                "Now load a barbell, either on the floor or, if you’re training at home or in a mostly empty gym, the supports of a squat rack.",
        "Sit on the preacher bench with your feet firmly planted on the floor shoulder-width apart. Grip the dumbbells, barbell or machine in a supinated (underhand) grip. Your underarms should be positioned at the top of the pad.\n" +
                "Lower the dumbbells, barbell or machine in a controlled manner until both of your elbows are fully extended. Then curl upward, keeping your shoulders and body stable throughout."

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