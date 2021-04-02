package com.mansi.gojekassignment.ui.main.view

import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mansi.gojekassignment.R
import com.mansi.gojekassignment.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var pop : PopupMenu
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        // Popup Menu Dialog
        popupMenuDialog()
        // Click Listener Calls
        onClickCall()
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


