package com.tsdproject.pokerplanning.cards

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tsdproject.pokerplanning.R
import kotlinx.android.synthetic.main.item_card.view.*

class CardsAdapter : RecyclerView.Adapter<CardsAdapter.ViewHolder>() {

    private val cardValues: List<Int>
        get() = listOf(1, 2, 3, 5, 8, 13, 21, 34, 55)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.valueTextView.text = cardValues[position].toString()
    }

    override fun getItemCount(): Int {
        return cardValues.size
    }

    inner class ViewHolder(view: View) :
            RecyclerView.ViewHolder(view) {
        val valueTextView = view.valueTextView
    }
}