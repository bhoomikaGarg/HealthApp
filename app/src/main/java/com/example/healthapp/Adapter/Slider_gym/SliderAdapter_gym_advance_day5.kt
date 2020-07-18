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

class SliderAdapter_gym_advance_day5  (val context: Context) : PagerAdapter() {

    lateinit var layoutInflater: LayoutInflater
    lateinit var slideImageView : ImageView
    lateinit var slideHeading : TextView
    lateinit var slideDescription : TextView

    val slide_images = arrayOf(

        R.drawable.flat_dumbell_press,
        R.drawable.incline_press,
        R.drawable.hammer_press,
        R.drawable.cable_fly,
        R.drawable.dumbell_lateral_rise,
        R.drawable.reverse_grip_latpulldown

    )

    val slide_headings = arrayOf(
        "Flat Dumbbell Press – 5 sets of 20-6 (Pyramiding) reps" ,
        "Incline Dumbbell Press – 3 sets of 6-10 reps" ,
        "Hammer Strength Press – 3 sets of 10 reps" ,
        "Cable Flys – 3 sets of 12-15 reps" ,
        "Lateral Raises – 5 sets of 15-20 reps" ,
        "Reverse-Grip Pull-Downs – 5 sets of 15-20 reps"

    )

    val slide_descs = arrayOf(
        "Sit on a flat bench, hold two dumbbells, and keep them in the resting position on top of the thighs so that your palms are facing each other.\n" +
                "Push your thighs up to assist in raising the weights. Lift the dbs up and hold them at your shoulder\n" +
                "Make sure that your palms face away from you by rotating your wrists forward. Keep the dumbbells positioned at the sides of the chest while creating an angle of 90 degrees between your upper arm and forearm. It is the initial position.\n" +
                "Press the dbs up with the help of your chest to lockout position at the top of the movement. Squeeze your chest and hold the position for a second.\n" +
                "Slowly lower the weights under control.\n" +
                "Repeat the steps for the required number of reps of your training regimen.",

        "Lie on a bench set to a 45-degree incline, holding a pair of dumbbells at arm’s length above your chest, palms forward.\n" +
                "Keeping your core braced and your elbows close to your body (i.e., not flared), lower the dumbbells to the sides of your chest.\n" +
                "Pause, and then push the weights back up to the starting position.",

        "Lie on a flat bench, holding a dumbbell in each hand. Bring the dumbbells up to the sides of your chest, keeping your grip neutral. Press the dumbbells up above your chest until your arms are fully extended. Bring the weights back down slowly until you feel a stretch in your chest, then press them overhead again.",

        "Set the pulleys on a dual-cable machine to chest height, and stand between the two stacks. Grab the handles.\n" +
                "Keeping your back straight and core engaged, raise your arms out to your sides, palms facing forward, and walk a step or two forward in order to create tension on the cables. Stand with one foot in front of the other.\n" +
                "Bend your elbows slightly, making sure not to let them travel behind your shoulders. This is your starting position.\n" +
                "Pull your hands toward each other in wide arcs in front of you, pausing when your hands touch before slowly returning to the starting position. Alternate your forward foot with each set.",

        " Step 1 Standing in a shoulder-width stance, grab a pair of dumbbells with palms facing inward and let them hang at your sides. Step 2 Raise your arms out to the sides until they're at shoulder level. Pause, then lower the weights back to the starting position.",

        "To do the reverse-grip pulldown, grab the bar with an underhand grip with your hands spaced about shoulder-width apart. Your arms should be fully extended in the start position and your back should be slightly arched with your chest up high."
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