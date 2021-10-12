package com.app.onboardingscreen

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    lateinit var indicatorsContainer:LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val onBoard_screen: ViewPager2 = findViewById(R.id.onBoard_screen)
        var onBoardingScreenAdapter:OnBoardingScreenAdapter = OnBoardingScreenAdapter(
            listOf(
                OnboardingItem(simple_text="Slide 1"),
                OnboardingItem(simple_text="Slide 2"),
                OnboardingItem(simple_text="Slide 3"),
                OnboardingItem(simple_text="Slide 4")
            )
        )
        onBoard_screen.adapter=onBoardingScreenAdapter

        indicatorsContainer = findViewById(R.id.indicatorsContainer)
        val indicator = arrayOfNulls<ImageView>(onBoardingScreenAdapter.itemCount)
        val layoutParams:LinearLayout.LayoutParams = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8, 0, 8, 0)
        for(i in indicator.indices){
            indicator[i]= ImageView(applicationContext)
            indicator[i]?.let {
                it.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.in_active))
                it.layoutParams = layoutParams
                indicatorsContainer.addView(it)
            }
        }

        // val current_position = 0

        setCurrentPage(0)

        onBoard_screen.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentPage(position)
            }
        })

        /*val childCount = indicatorsContainer.childCount
        for(i in 0 until childCount){
            val imageView = indicatorsContainer.getChildAt(i) as ImageView
            if(i == current_position){
                imageView.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.active))
            }
            else{
                imageView.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.in_active))
            }
        }*/
    }

    private fun setCurrentPage(pos:Int){
        val childCount = indicatorsContainer.childCount
        for(i in 0 until childCount){
            val imageView = indicatorsContainer.getChildAt(i) as ImageView
            if(i == pos){
                imageView.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.active))
            }
            else{
                imageView.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.in_active))
            }
        }
    }
}