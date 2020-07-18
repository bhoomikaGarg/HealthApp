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

class SliderAdapter_gym_beginner_day2(val context: Context) : PagerAdapter() {

    lateinit var layoutInflater: LayoutInflater
    lateinit var slideImageView : ImageView
    lateinit var slideHeading : TextView
    lateinit var slideDescription : TextView

    val slide_images = arrayOf(

        R.drawable.legpress,
        R.drawable.overheadbarextension,
        R.drawable.ezbarcurls,
        R.drawable.machinechestpress,
        R.drawable.tbar,
        R.drawable.dumbell_lateral_rise
    )

    val slide_headings = arrayOf(
        "Leg Press Machine – 4 sets of 8 reps",
        "Overhead Bar Extensions – 3 sets of 20 reps",
        "EZ Bar Curls – 4 sets of 10 reps",
        "Machine Chest Press – 4 sets of 10 reps",
        "T-Bar Row – 4 sets of 10 reps",
        "Lateral Raises – 3 sets of 20 reps"
    )


        val slide_descs = arrayOf(
            "Choose the appropriate weight and set the seat so that the knees are bent just over right angles.\n" +
                    "Position feet about shoulder width apart\n" +
                    "Try to push through your heels, keeping the knees lined up over the toes\n" +
                    "Extend the legs until nearly straight, avoiding locking the knees\n" +
                    "Lower the weight slowly back towards the starting position\n" +
                    "Repeat for the number of reps required",

            "Step 1: Grab an EZ-bar with an overhand grip at the first grip position from the center. Raise bar above your head so your arms are straight out above your head. This is the starting position.\n" +
                    "Step 2: Stand with feet shoulder-width apart. Next, begin exercise by lowering bar down behind head without moving upper arms. Only your forearms should be lowering down at the elbow. Lower down until forearms are parallel to the floor.\n" +
                    "Step 3: Next, raise weight back up to starting position. Keep elbows tucked in. Do not let them flare out. This completes on rep.",

            "An EZ-bar curl is, well, easy. Stand with your feet shoulder-width apart, knees slightly bent. Hold an EZ-bar in an underhand grip with your arms extended and then curl the bar up towards your chest, keeping your elbows in to your sides. ",

            "Step 1: Sit down on the chest press machine. Select the weight you want to work with.\n" +
                    "Step 2: Step on the lever to bring the handles forward. Grab the handles and fully extend your arms.\n" +
                    "Step 3: Grasp the handles in a palms-down grip. Lift your elbows so that your upper arms are parallel to the floor to the side of your torso. Push the handles forward and extend your arms; this is the starting position.\n" +
                    "Step 4: Move the handles back towards you as you inhale.\n" +
                    "Step 5: Push the handles away from you as you flex your pecs. Hold the contraction for a second and move back to the starting position.\n" +
                    "Step 6: Repeat for the number of reps in your set.\n" +
                    "Step 7: When you have finished, step on the lever again and move the handles back to their original position.",

            "Place the end of an empty barbell into the corner of a room.\n" +
                    "Rest a heavy dumbbell or some weight plates on it to hold it down.\n" +
                    "Load the opposite end of the bar with plates and straddle it.\n" +
                    "Bend over at the hips until your torso is about a 45-degree angle to the floor with arms extended.\n" +
                    "Hook a V-grip handle (the kind you see at a cable station) under the bar and hold with both hands.\n" +
                    "Keeping your lower back in its natural arch, squeeze your shoulder blades together and pull the bar until the plates touch your chest.\n" ,

            "All you need is a set of dumbbells (start with a pair between 5 to 15 pounds if you're a beginner), and enough space to raise your arms in a \"T\" formation out to each side."

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