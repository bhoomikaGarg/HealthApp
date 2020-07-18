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

class SliderAdapter_gym_advance_day1(val context: Context) : PagerAdapter() {

    lateinit var layoutInflater: LayoutInflater
    lateinit var slideImageView : ImageView
    lateinit var slideHeading : TextView
    lateinit var slideDescription : TextView

    val slide_images = arrayOf(

        R.drawable.barbell_bench_press,
        R.drawable.incline_bench_press,
        R.drawable.dips,
        R.drawable.pulldown,
        R.drawable.pendlay_row,
        R.drawable.pulldown
    )

    val slide_headings = arrayOf(
        "Barbell Bench Press",
        "Incline Dumbbell Press",
        "Dips – 3 sets of 6-10 reps" ,

        "Pullups – 3 sets of 5-8 reps" ,
        "Pendlay Rows – 3 sets of 6-10 reps" ,
        "Pulldowns "
    )

    val slide_descs = arrayOf(
        "Lie on the bench with your eyes under the bar\n" +
                "Grab the bar with a medium grip-width (thumbs around the bar!)\n" +
                "Unrack the bar by straightening your arms\n" +
                "Lower the bar to your mid-chest\n" +
                "Press the bar back up until your arms are straight\n" +
                "Hold the weight for a second at the top, with straight arms. Breathe. Then take a big breath, hold it, and lower the bar again. Keep your butt on the bench when you press it back up. Bench sets of five reps every StrongLifts 5×5 workout A.\n"
        ,
        "The Incline Bench Press primarily works the clavicular head of the pectoralis major, or the upper portion of your chest. It also works the anterior deltoid (front portion of the shoulder) and the triceps (backside of your arm).",
        "A dip is an upper-body strength exercise. Narrow, shoulder-width dips primarily train the triceps, with major synergists being the anterior deltoid, the pectoralis muscles, and the rhomboid muscles of the back.",
        "A pull-up is an upper-body strength exercise. The pull-up is a closed-chain movement where the body is suspended by the hands and pulls up. As this happens, the elbows flex and the shoulders adduct and extend to bring the elbows to the torso",
        "The Pendlay row is still a type of barbell row, so it targets the same areas – principally the lats, but most of the upper and lower back muscles are also enlisted in the movement. It is a more demanding lift than the standard barbell row, owing to the fact you have to lift the bar from the ground each time.",
        "The pulldown exercise is a strength training exercise designed to develop the latissimus dorsi muscle. It performs the functions of downward rotation and depression of the scapulae combined with adduction and extension of the shoulder joint."
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