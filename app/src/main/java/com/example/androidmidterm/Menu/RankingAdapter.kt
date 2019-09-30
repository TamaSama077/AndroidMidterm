package com.example.androidmidterm.Menu

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidmidterm.R
import com.example.androidmidterm.Services.UserViewModel
import kotlinx.android.synthetic.main.ranking_item.view.*


class RankingAdapter(private val activity: Activity, private val users: ArrayList<UserViewModel>):
    RecyclerView.Adapter<RankingAdapter.RankingHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankingHolder {
        val inflatedView = LayoutInflater.from(activity)
            .inflate(R.layout.ranking_item, parent, false)
        return RankingHolder(inflatedView)
    }

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: RankingHolder, position: Int) {
        holder.bindUser(users[position], position + 1)
    }

    class RankingHolder(view: View): RecyclerView.ViewHolder(view) {
        private var view: View = view
        private var user: UserViewModel? = null

        fun bindUser(user: UserViewModel, position: Int) {
            this.user = user
            with(view) {
                tvName.text = user.FullName
                tvScore.text = user.Score.toString()
                tvRank.text = position.toString()
            }
            Glide.with(view.context)
                .load(user.ImageUrl)
                .into(view.ivUser)
        }
    }
}