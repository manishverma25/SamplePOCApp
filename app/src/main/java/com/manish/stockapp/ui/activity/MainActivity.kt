package com.manish.stockapp.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.manish.stockapp.R
import com.manish.stockapp.ui.fragment.FirstFragment
import com.manish.stockapp.ui.fragment.SecondFragment
import com.manish.stockapp.ui.fragment.ThirdFragment

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUI()
    }


    fun setUI(){
//        bottomBar.setOnItemSelectedListener {
//            Log.d("mvv", " pos  setOnItemSelectedListener " + it)
//            when (it) {
//                0 -> openFragment(FirstFragment. newInstance("", ""))
//                1 -> openFragment(SecondFragment. newInstance("", ""))
//                2 -> openFragment(ThirdFragment. newInstance("", ""))
//            }
//        }

    }

    fun openFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)

        transaction.commit()
    }


}