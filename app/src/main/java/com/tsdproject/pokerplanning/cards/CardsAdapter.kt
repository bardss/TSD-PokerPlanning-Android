package com.tsdproject.pokerplanning.cards

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tsdproject.pokerplanning.R
import com.tsdproject.pokerplanning.model.utils.ResUtil
import kotlinx.android.synthetic.main.item_card.view.*

class CardsAdapter : RecyclerView.Adapter<CardsAdapter.ViewHolder>() {

    lateinit var context: Context
    private val cardValues: List<Int>
        get() = listOf(1, 2, 3, 5, 8, 13, 21, 34, 55)
    private var choosenCard: Int? = null
    private var previousCardPosition: Int? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_card,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.valueTextView.text = cardValues[position].toString()
        holder.chooseCardButton.setOnClickListener { onCardItemClick(position, holder) }
        if (position == 0) {
            holder.chooseCardButton.isEnabled = true
            holder.chooseCardButton.isClickable = true
        }
    }

    private fun onCardItemClick(position: Int, holder: ViewHolder) {
        if (cardValues[position] == choosenCard) {
            unhighlightCard(holder)
            (context as CardsView).setCarouselScrollable(true)
            choosenCard = null
        } else {
            highlightCard(holder)
            choosenCard = cardValues[position]
            (context as CardsView).onChooseCardClick(cardValues[position].toString())
        }
    }

    fun highlightCard(holder: ViewHolder) {
        holder.cardLayout.background = ResUtil.getDrawable(R.drawable.rounded_frame_blue)
        holder.valueTextView.setTextColor(ResUtil.getColor(android.R.color.white))
        holder.chooseCardButton.background = ResUtil.getDrawable(R.drawable.rounded_card_white)
        holder.chooseCardButton.setTextColor(ResUtil.getColor(android.R.color.black))
        holder.chooseCardButton.text = ResUtil.getString(R.string.uncheck).toUpperCase()
    }

    fun unhighlightCard(holder: ViewHolder) {
        holder.cardLayout.background = ResUtil.getDrawable(R.drawable.rounded_card_white)
        holder.valueTextView.setTextColor(ResUtil.getColor(R.color.colorAccent))
        holder.chooseCardButton.background = ResUtil.getDrawable(R.drawable.rounded_frame_blue)
        holder.chooseCardButton.setTextColor(ResUtil.getColor(android.R.color.white))
        holder.chooseCardButton.text = ResUtil.getString(R.string.check).toUpperCase()
    }

    override fun getItemCount(): Int {
        return cardValues.size
    }

    fun setupCardClickability(card: View?, enabled: Boolean) {
        card?.chooseCardButton?.isEnabled = enabled
        card?.chooseCardButton?.isClickable = enabled
    }

    fun changePreviousCardPosition(position: Int) {
        previousCardPosition = position
    }

    fun getPreviousSelectedPosition() = previousCardPosition

    inner class ViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        val valueTextView = view.valueTextView
        val cardLayout = view.cardLayout
        val chooseCardButton = view.chooseCardButton
    }
}