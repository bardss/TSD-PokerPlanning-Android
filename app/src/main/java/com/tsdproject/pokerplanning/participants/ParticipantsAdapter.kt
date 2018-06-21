package com.tsdproject.pokerplanning.participants

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.daimajia.swipe.SwipeLayout
import com.tsdproject.pokerplanning.R
import com.tsdproject.pokerplanning.model.transportobjects.UserTO
import com.tsdproject.pokerplanning.model.utils.ResUtil
import kotlinx.android.synthetic.main.item_participants.view.*
import kotlinx.android.synthetic.main.item_participants_bottom.view.*
import kotlinx.android.synthetic.main.item_participants_top.view.*

class ParticipantsAdapter : RecyclerView.Adapter<ParticipantsAdapter.ViewHolder>() {

    private var usersList: List<UserTO> = listOf()
    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_participants, parent, false)
        context = parent.context
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
        setupSwipe(holder.itemSwipeLayout)
        setupDeleteClick(holder.deleteBottomView, user.email)
    }

    private fun setupDeleteClick(deleteBottomView: FrameLayout, email: String) {
        deleteBottomView.setOnClickListener {
            (context as? ParticipantsView)?.kickParticipant(email)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var userNameTextView = view.nameTextView
        var emailTextView = view.emailTextView
        var participantLayout = view.participantLayout
        var itemSwipeLayout = view.itemSwipeLayout
        var deleteBottomView = view.deleteBottomView
    }

    fun setUsersList(users: List<UserTO>) {
        usersList = users
        notifyDataSetChanged()
    }

    private fun setupSwipe(itemSwipeLayout: SwipeLayout) {
        with(itemSwipeLayout) {
            showMode = SwipeLayout.ShowMode.PullOut
            addDrag(SwipeLayout.DragEdge.Left, bottomWrapperLayout)
            addDrag(SwipeLayout.DragEdge.Right, null)
            isSwipeEnabled = true
            addSwipeListener(object : SwipeLayout.SwipeListener {
                override fun onStartOpen(layout: SwipeLayout) {
                }

                override fun onOpen(layout: SwipeLayout) {
                }

                override fun onStartClose(layout: SwipeLayout) {
                }

                override fun onClose(layout: SwipeLayout) {
                }

                override fun onUpdate(layout: SwipeLayout, leftOffset: Int, topOffset: Int) {
                }

                override fun onHandRelease(layout: SwipeLayout, xvel: Float, yvel: Float) {
                }
            })
        }
    }
}