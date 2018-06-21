package com.tsdproject.pokerplanning.participants

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tsdproject.pokerplanning.R
import com.tsdproject.pokerplanning.model.transportobjects.UserTO
import com.tsdproject.pokerplanning.model.utils.ResUtil
import kotlinx.android.synthetic.main.item_participants.view.*

class ParticipantsAdapter : RecyclerView.Adapter<ParticipantsAdapter.ViewHolder>() {

    private var usersList: List<UserTO> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_participants, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = usersList[position]
        holder.userNameTextView.text = user.firstName + " " + user.lastName
        holder.emailTextView.text = user.email
        if (user.isReady) {
            holder.participantLayout.setBackgroundColor(ResUtil.getColor(R.color.colorGreenReadyLight))
        } else {
            holder.participantLayout.setBackgroundColor(ResUtil.getColor(android.R.color.white))
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var userNameTextView = view.nameTextView
        var emailTextView = view.emailTextView
        var participantLayout = view.participantLayout
    }

    fun setUsersList(users: List<UserTO>) {
        usersList = users
        notifyDataSetChanged()
    }
}