package com.mvvm.home

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mvvm.R

class HobbiesAdapter(mLlistHobbies: ArrayList<String>,
                     view: Context
) :
    RecyclerView.Adapter<HobbiesAdapter.HobbiesView>() {
    private var listHobbies: ArrayList<String>? = mLlistHobbies
    private var view: Context? = null

    init {
        this.view = view
    }

    class HobbiesView (v: View) : RecyclerView.ViewHolder(v) {
        var tvHobbie : TextView?= null

        init {
            tvHobbie = v.findViewById(R.id.tv_hobbie)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: HobbiesView, position: Int) {
        holder.setIsRecyclable(false)
        val hobbie = listHobbies!![position]
        holder.tvHobbie?.text = hobbie
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HobbiesView {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_hobbie, parent, false)
        return HobbiesView(itemView)
    }

    override fun getItemCount(): Int {
        return listHobbies!!.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}
