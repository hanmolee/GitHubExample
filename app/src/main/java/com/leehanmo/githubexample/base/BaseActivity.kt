package com.leehanmo.githubexample.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    open fun replaceFragment(frameId : Int, fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .add(frameId, fragment, fragment::javaClass.name)
                .commitAllowingStateLoss()
    }
}