package com.example.healthapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter

class SliderAdapter_yoga(val context: Context) : PagerAdapter() {

    lateinit var layoutInflater: LayoutInflater
    lateinit var slideImageView : ImageView
    lateinit var slideHeading : TextView
    lateinit var slideDescription : TextView




    val slide_images = arrayOf(

        R.drawable.mountainpose,
        R.drawable.treepose,
        R.drawable.dogpose,
        R.drawable.trikonasana,
        R.drawable.chairpose,
        R.drawable.boatpose,
        R.drawable.cobrapose,
        R.drawable.paschimottanasana,
        R.drawable.childspose,
        R.drawable.padamasana
    )

    val slide_headings = arrayOf(
        "Tadasana (Mountain Pose)",
        "Vrikshasana (Tree Pose)",
        "Adho Mukho Svanasana (Downward Facing Dog Pose)",
        "Trikonasana (Triangle Pose)",
        "Kursiasana (Chair Pose)",
        "Naukasana (Boat Pose)",
        "Bhujangasana (Cobra Pose)",
        "Paschimottanasana",
        "Child's Pose",
        "Sukhasna"

    )

    val slide_descs = arrayOf(
        "This pose teaches one to stand with majestic steadiness like a mountain. The word ‘Tada' means a mountain, that's where the name comes from. It involves the major groups of muscles and improves focus and concentration. It is the starting position for all the other asanas.\n" +
                "\n" +
                "Stand with your heels slightly apart and hang your arms besides the torso. Gently lift and spread your toes and the balls of your feet, then lay them softly down on the floor. Balance your body weight on your feet. Lift your ankles and firm your thigh muscles while rotating them inwards. As you inhale, elongate your torso and when you exhale release your shoulder blades away from your head. Broaden your collarbone and elongate your neck. Your ears, shoulders, hips and ankles should all be in one line. You can check your alignment by standing against the wall initially. You can even raise your hands and stretch them. Breathe easy.",
        "This pose gives you a sense of grounding. It improves your balance and strengthens your legs and back. It replicates the steady stance of a tree. Place your right foot high up on your left thigh. The sole of the foot should be flat and placed firmly. Keep your left leg straight and find your balance. While inhaling, raise your arms over your head and bring your palms together. Ensure that your spine is straight and take a few deep breaths. Slowly exhale, bring your hands down and release your right leg. Back in the standing position repeat the same with the other leg.",
        "This pose stretches hamstrings, chest and lengthens the spine, providing additional blood flow to the head. It is will leave you feeling energised. Sit on your heels, stretch your arms forward on the mat and lower your head. Form a table, like pushing your hands, strengthening your legs and slowly raising your hips. Press your heels down, let your head hand freely and tighten your waist.",
        "It stretches the legs and torso, mobilises the hips and promotes deep breathing, leaving one with enlivening effects. Stand with your feet wide apart. Stretch your right foot out (90 degrees) while keeping the leg closer to the torso. Keep your feet pressed against the ground and balance your weight equally on both feet. Inhale and as you exhale bend your right arm and make it touch the ground while your left arm goes up. Keep your waist straight. Ensure that your body is bent sideways and not forward or backwards. Stretch as much as you can while taking long, deep breaths. Repeat on the other side.",
        "An intensely powerful pose, this one strengthens the muscles of the legs and arms. It builds your willpower and has an energizing effect on the body and mind. Stand straight with your feet slightly apart. Stretch your arms but don't bend your elbow. Inhale and bend your knees, pushing your pelvis down like you are sitting on chair. Keep your hands parallel to the ground and back straight. Take deep breaths. Bend gradually but make sure your knees don't go beyond your toes.",
        "It tightens the abdominal muscles and strengthens shoulders and upper back. It leaves the practitioner with a sense of stability. Lie back on the mat with your feet together and hands by your side. Take a deep breath and while exhaling gently lift your chest and feet off the ground. Stretch your hands in the direction of your feet. Your eyes, fingers and toes should be in one line. Hold till you feel some tension in your navel area as your abdominal muscles begin to contract. As you exhale, come back to the ground and relax.",
        "This one will strengthen the lower back muscles while cushioning the spine, triceps and opens the chest to promote the inhalations. It also makes the spine flexible.\n" +
                "\n" +
                "Lie on your stomach with your feet together and toes flat. Place your hands downwards below your shoulders on the mat, lift your waist and raise your head while inhaling in. Pull your torso back with the support of your hands. Keep your elbows straight and make sure you put equal pressure on both palms.  Tilt your head back and make sure your shoulders are away from your ears. Exhale while coming back to the ground.",
        "This asana helps in improving the flexibility of the hamstrings and hips and lengthens the spine. Sit up with your back straight and toes pointing outwards. Breathe in and raise your hands over your head and stretch. Now, while breathing out bring your hands down and bend then forward to touch your legs. Place your hands wherever they reach, hold your toes if you can but don't force yourself. Breathe in and elongate your spine. While breathing out, keep your navel close to your knees.",
        "This restful posture helps let go and surrender. It restores vitality physically, mentally and emotionally. Insert the pose between challenging asanas, and practice with closed eyes, listening to the sound of your breath. Bend your knees and sit on your heels. Keep your hips on your heels. Lower your head on the mat and bring your hands forward by your side. Press your thighs against your chest and breathe lightly.",
        "Sukhasna is a comfortable position for pranayama and meditation. It gives the practitioner a centering effect. All the other asnas are done to eventually make the body feel comfortable to be able to sit in this position for meditation. This asna takes the yoga practice beyond its physical dimension and helps you get in touch with your spiritual side. Sit comfortably on the mat with crossed legs (left leg tugged inside the right thigh and right leg tugged inside the left thigh). Keep spine straight. Place your hands on your knees. You can use the Jnana mudra or Chin mudra. Relax your body and breathe gently."
        )


    override fun getCount(): Int {
        return slide_headings.size
    }
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as RelativeLayout
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view = layoutInflater.inflate(R.layout.slide_layout, container, false)

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