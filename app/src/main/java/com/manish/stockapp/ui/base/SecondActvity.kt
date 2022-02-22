package com.manish.stockapp.ui.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.manish.stockapp.R
import com.manish.stockapp.ui.home.Fragment2
import com.manish.stockapp.ui.home.Fragment3
import com.manish.stockapp.ui.home.FragmentOne
import kotlinx.android.synthetic.main.main_activity.*


class SecondActvity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_actvity)

        setupBottomBar()
    }

    fun setupBottomBar() {
        bottomBar.setOnItemSelectedListener {
            Log.d("mvv"," !!!! it $it ")
            when (it) {
                0 -> openFragment(FragmentOne.newInstance("FragmentOne","FragmentOne"),"FragmentOne")
                1 -> openFragment(Fragment2.newInstance("Fragment2","Fragment2"),"Fragment2")
                2 -> openFragment(Fragment3.newInstance("Fragment3","Fragment3"),"Fragment3")
            }
        }

        bottomBar.onItemSelected = { pos ->
            Log.d("mvv"," >>>>> onItemSelected $pos ")
            when (pos) {
                0 -> openFragment(FragmentOne.newInstance("FragmentOne","FragmentOne"),"FragmentOne")
                1 -> openFragment(Fragment2.newInstance("Fragment2","Fragment2"),"Fragment2")
                2 -> openFragment(Fragment3.newInstance("Fragment3","Fragment3"),"Fragment3")
            }
        }
        bottomBar
        openFragment(FragmentOne.newInstance("FragmentOne","FragmentOne"),"FragmentOne")

    }


    fun openFragment(fragment: Fragment,tag :String) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment,tag)
        transaction.addToBackStack(tag);
        Log.d("mvv"," fragment.tag  ${fragment.tag}")
        transaction.commit()
    }
}
