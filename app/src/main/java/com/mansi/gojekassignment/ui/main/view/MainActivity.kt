package com.mansi.gojekassignment.ui.main.view

import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mansi.gojekassignment.DataSource
import com.mansi.gojekassignment.R
import com.mansi.gojekassignment.data.api.ApiHelper
import com.mansi.gojekassignment.data.api.ApiServiceImpl
import com.mansi.gojekassignment.data.models.StackQuestionListResponse
import com.mansi.gojekassignment.databinding.ActivityMainBinding
import com.mansi.gojekassignment.ui.base.ViewModelFactory
import com.mansi.gojekassignment.ui.main.adapter.MainAdapter
import com.mansi.gojekassignment.ui.main.viewmodel.MainViewModel
import com.mansi.gojekassignment.utils.Status


class MainActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var pop : PopupMenu
    private lateinit var adapter : MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        mainViewModel = ViewModelProviders.of(this, ViewModelFactory(ApiHelper(ApiServiceImpl()))).get(MainViewModel::class.java)
        setupUI()
        setUpObserver()
        popupMenuDialog()
        onClickCall()
    }

    private fun setUpObserver() {
        mainViewModel.getQuestions().observe(this, {
            when (it.status) {
                Status.ERROR -> {
                    activityMainBinding.shimmerLayout.visibility = View.GONE
                    Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_SHORT).show()
                }
                Status.SUCCESS -> {
                    activityMainBinding.shimmerLayout.visibility = View.GONE
                    renderList(it.data)
                }
                Status.LOADING -> {
                    activityMainBinding.shimmerLayout.visibility = View.VISIBLE
                }
            }
        }
        )
    }

    private fun renderList(data : StackQuestionListResponse?) {
        data?.let { adapter.addData(it.items) }
        adapter.notifyDataSetChanged()
    }

    private fun setupUI() {
        activityMainBinding.recycleView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        activityMainBinding.recycleView.addItemDecoration(
                DividerItemDecoration(
                        activityMainBinding.recycleView.context,
                        (activityMainBinding.recycleView.layoutManager as LinearLayoutManager).orientation
                )
        )
        activityMainBinding.recycleView.adapter = adapter
        
    }

    private fun onClickCall() {
        activityMainBinding.moreIcon.setOnClickListener(this)
    }

    private fun popupMenuDialog() {
        pop = PopupMenu(activityMainBinding.moreIcon.context, activityMainBinding.moreIcon)
        pop.menuInflater.inflate(R.menu.more_menu, pop.menu)

        pop.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.sort_by_stars ->
                    Toast.makeText(
                        this@MainActivity,
                        "You Clicked : " + item.title,
                        Toast.LENGTH_SHORT
                    ).show()
                R.id.sort_by_name ->
                    Toast.makeText(
                        this@MainActivity,
                        "You Clicked : " + item.title,
                        Toast.LENGTH_SHORT
                    ).show()
            }
            true
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
         R.id.more_icon ->   pop.show()
        }
    }
}


