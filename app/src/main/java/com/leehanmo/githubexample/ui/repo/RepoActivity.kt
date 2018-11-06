package com.leehanmo.githubexample.ui.repo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import com.leehanmo.githubexample.R
import com.leehanmo.githubexample.base.BaseActivity
import com.leehanmo.githubexample.injection.annotation.ActivityScope
import dagger.Lazy
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

@ActivityScope
class RepoActivity : BaseActivity(), HasSupportFragmentInjector, RepoContract.View {

    @Inject
    lateinit var repoFragmentProvider: Lazy<RepoFragment>
    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo)

        initRepoFragment()
    }

    private fun initRepoFragment() {
        var repoFragment: RepoFragment? = supportFragmentManager.findFragmentById(R.id.repoContainer) as RepoFragment?
        if (repoFragment == null) {

            repoFragment = repoFragmentProvider.get()
            replaceFragment(R.id.repoContainer, repoFragment)
        }

        //replaceFragment(R.id.repoContainer, RepoFragment())
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }

    companion object {
        fun newIntent(context: Context, userName : String): Intent {
            val repoIntent = Intent(context, RepoActivity::class.java)
            repoIntent.putExtra("userName", userName)
            return repoIntent
        }
    }

}