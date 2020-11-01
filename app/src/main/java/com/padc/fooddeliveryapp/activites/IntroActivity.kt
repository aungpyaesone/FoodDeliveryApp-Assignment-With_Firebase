package com.padc.fooddeliveryapp.activites

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.padc.fooddeliveryapp.R
import com.padc.fooddeliveryapp.adapters.ViewPagerTwoAdapter
import com.padc.fooddeliveryapp.mvp.presenters.IntroPresenter
import com.padc.fooddeliveryapp.mvp.presenters.impls.IntroPresenterImpl
import com.padc.fooddeliveryapp.mvp.views.IntroView
import com.padc.shared.activites.BaseActivity
import kotlinx.android.synthetic.main.activity_intro.*


class IntroActivity : BaseActivity(),IntroView {

    private lateinit var mPresenter:IntroPresenter

    companion object{
        fun newInstance(context: Context): Intent = Intent(context,IntroActivity::class.java)
    }
    private var viewPagerTwoAdapter : ViewPagerTwoAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        setUpPresenter()
        setUpViewPager()
        setUpListener()
        mPresenter.onUiReady(this)
    }

    private fun setUpPresenter() {
        mPresenter = getPresenter<IntroPresenterImpl,IntroView>()
    }

    override fun navigateToLoginScreen() {
       startActivity(LoginActivity.newInstance(this))
    }

    override fun navigateToRegisterScreen() {
       startActivity(RegisterActivity.newInstance(this))
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    private fun setUpListener() {
        btnCreateAccount.setOnClickListener {
            mPresenter.onTapCreateAccount()
        }

        tvLogin.setOnClickListener {
            mPresenter.onTapLogin()
        }

    }

    private fun setUpViewPager() {
        viewPagerTwoAdapter = ViewPagerTwoAdapter(this)
        introViewPager.adapter = viewPagerTwoAdapter
        TabLayoutMediator(tabLayout,introViewPager){tab,position->{

        }}.attach()

    }
}