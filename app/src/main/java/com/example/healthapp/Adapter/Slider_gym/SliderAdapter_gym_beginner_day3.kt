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

class SliderAdapter_gym_beginner_day3(val context: Context) : PagerAdapter() {

    lateinit var layoutInflater: LayoutInflater
    lateinit var slideImageView : ImageView
    lateinit var slideHeading : TextView
    lateinit var slideDescription : TextView

    val slide_images = arrayOf(

        R.drawable.ezbarupright,
        R.drawable.closegrip,
        R.drawable.cable_fly,
        R.drawable.lunges,
        R.drawable.skull_cusher,
        R.drawable.hammercurls
    )

    val slide_headings = arrayOf(
        "EZ Bar Upright Rows – 3 sets of 15 reps",
        "Close-Grip Pulldowns – 4 sets of 12 reps",
        "Cable Fly – 4 sets of 10 reps",
        "Lunges – 3 sets of 10 reps per leg",
        "Skullcrushers – 3 sets of 15 reps",
        "Hammer Curls – 3 sets of 12 reps"
    )

    val slide_descs = arrayOf(
        "Step 1: Grasp an EZ-bar with an overhand grip. Hands should be place on the first grip position so that they are only a few inches apart.\n" +
                "Step 2: While keeping the bar close to your body, raise the bar straight up until it almost touches your chin and your elbows are flared out to the sides.\n" +
                "Step 3: Slowly lower the weight back down the starting position.\n" +
                "Step 4: This completes one rep.",

        "Sit at a lat pull-down machine and attach a hammer grip to the cable.\n" +
                "Hold the grip with your palms facing in, straighten your torso and lock it in this position. Then lean back slightly.\n" +
                "Keep your elbows tucked in to your sides and pull the handle to your chest, making sure your arms are the only part of you that moves.",

        "Set the pulleys on a dual-cable machine to chest height, and stand between the two stacks. Grab the handles.\n" +
                "Keeping your back straight and core engaged, raise your arms out to your sides, palms facing forward, and walk a step or two forward in order to create tension on the cables. Stand with one foot in front of the other.\n" +
                "Bend your elbows slightly, making sure not to let them travel behind your shoulders. This is your starting position.\n" +
                "Pull your hands toward each other in wide arcs in front of you, pausing when your hands touch before slowly returning to the starting position. Alternate your forward foot with each set.",

        "1. Stand tall with feet hip-width apart. Engage your core.\n" +
                "\n" +
                "2. Take a big step forward with right leg. Start to shift your weight forward so heel hits the floor first.\n" +
                "\n" +
                "3. Lower your body until right thigh is parallel to the floor and right shin is vertical. It’s OK if knee shifts forward a little as long as it doesn’t go past right toe. If mobility allows, lightly tap left knee to the floor while keeping weight in right heel.\n" +
                "\n" +
                "4. Press into right heel to drive back up to starting position.\n" +
                "\n" +
                "5. Repeat on the other side",

        "Lie down on your back. Your feet should be flat on the floor and your legs should be bent at the knees. If you're on a bench, your head should be at one end of the bench so you have space to use your weights. On a stability ball, just balance in the middle of your back",

        "Stand with your feet shoulder-width apart and a slight bend in your knees. Hold a pair of dumbbells in your hands with your palms facing towards your body – this is the main difference from the standard curl, which you start with your palms facing forwards. Keeping your elbows close to your body, slowly curl the dumbbell up to your shoulders. Pause for a second at the top of the lift, squeeze your biceps, then lower the weights under control."
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