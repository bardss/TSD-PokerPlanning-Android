package com.tsdproject.pokerplanning.results

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.tsdproject.pokerplanning.R
import kotlinx.android.synthetic.main.item_result.view.*

class ResultsListAdapter : RecyclerView.Adapter<ResultsListAdapter.ViewHolder>() {

    var cardValues: List<Int> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_result, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return cardValues.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.valueTextView.text = cardValues[position].toString()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val valueTextView: TextView = view.valueTextView
    }

    fun updateCardValues(values: List<Int>) {
        cardValues = values
        notifyDataSetChanged()
    }
}