package com.app.onboardingscreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


data class OnboardingItem(
    val simple_text: String
)

class OnBoardingScreenAdapter(private val onboardingItem: List<OnboardingItem>) : RecyclerView.Adapter<OnBoardingScreenAdapter.OnBoardingItemViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingItemViewHolder {
        return OnBoardingItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.on_boarding_screen_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: OnBoardingItemViewHolder, position: Int) {
        holder.bind(onboardingItem[position])
    }

    override fun getItemCount(): Int {
        return onboardingItem.size
    }

    inner class OnBoardingItemViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val show_text = view.findViewById<TextView>(R.id.show_text)

        fun bind(onboardingItem:OnboardingItem){
            show_text.text=onboardingItem.simple_text
        }
    }
}