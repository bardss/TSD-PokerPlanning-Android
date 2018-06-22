package com.tsdproject.pokerplanning.results

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.tsdproject.pokerplanning.R
import com.tsdproject.pokerplanning.model.transportobjects.ResultTO
import kotlinx.android.synthetic.main.item_result.view.*

class ResultsListAdapter : RecyclerView.Adapter<ResultsListAdapter.ViewHolder>() {

    var results: List<ResultTO> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_result, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return results.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = results[position]
        holder.valueTextView.text = result.value
        holder.fullNameTextView.text = result.user?.firstName + " " + result.user?.lastName
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val valueTextView: TextView = view.valueTextView
        val fullNameTextView: TextView = view.fullNameTextView
    }

    fun updateCardValues(values: List<ResultTO>) {
        results = values
        notifyDataSetChanged()
    }
}