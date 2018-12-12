package com.leehanmo.githubexample.ui.repo

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import com.leehanmo.githubexample.R
import com.leehanmo.githubexample.base.BaseActivity
import com.leehanmo.githubexample.injection.annotation.ActivityScope
import com.leehanmo.githubexample.model.Repo
import com.leehanmo.githubexample.util.USER_NAME
import dagger.Lazy
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

@ActivityScope
class RepoActivity : BaseActivity(), HasSupportFragmentInjector {

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

            val args = Bundle()
            args.putString(USER_NAME, getUserName())
            repoFragment = repoFragmentProvider.get()
            repoFragment?.arguments = args

            replaceFragment(R.id.repoContainer, repoFragment)
        }
    }

    private fun getUserName() : String {
        return intent.getStringExtra(USER_NAME)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }

    companion object {
        fun newIntent(context: Context, userName : String): Intent {
            val repoIntent = Intent(context, RepoActivity::class.java)
            repoIntent.putExtra(USER_NAME, userName)
            return repoIntent
        }
    }

}