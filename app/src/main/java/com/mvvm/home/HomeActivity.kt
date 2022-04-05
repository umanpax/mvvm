package com.mvvm.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mvvm.R

class HomeActivity : AppCompatActivity() {

    private  var viewModel = HomeViewModel()
    private lateinit var tvUserName: TextView
    private lateinit var adapter: HobbiesAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initViews()
        initObservers()
        initData()
    }

    private fun initViews() {
        tvUserName = findViewById(R.id.tv_username)
        recyclerView = findViewById(R.id.recycler_view_hobbies)
    }

    private fun initData() {
        viewModel.getUserName()
        viewModel.getLastName()
        viewModel.getHobbies()
    }

    @SuppressLint("SetTextI18n")
    private fun initObservers() {
        viewModel.liveDataUserName.observe(this) { username ->
            tvUserName.text = username
        }
        viewModel.liveDataLastName.observe(this) { lastName ->
            tvUserName.text = tvUserName.text.toString() + " " + lastName
        }
        viewModel.liveDataHobbies.observe(this) { hobbies ->
            initRecycler(hobbies)
        }
    }

    private fun initRecycler(listHobbies: ArrayList<String>) {
        adapter = HobbiesAdapter(listHobbies, this, viewModel)
        val llm = LinearLayoutManager(this)
        llm.orientation = RecyclerView.VERTICAL
        recyclerView.visibility = View.VISIBLE
        recyclerView.layoutManager = llm
        recyclerView.adapter = adapter
    }

}