package com.padc.fooddeliveryapp.activites

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.padc.fooddeliveryapp.R
import com.padc.fooddeliveryapp.mvp.presenters.GetStartPresenter
import com.padc.fooddeliveryapp.mvp.presenters.impls.GetStartPresenterImpl
import com.padc.fooddeliveryapp.mvp.views.GetStartView
import com.padc.shared.activites.BaseActivity
import kotlinx.android.synthetic.main.activity_get_start_screen.*

class GetStartScreenActivity : BaseActivity(),GetStartView {

    private lateinit var mPresenter : GetStartPresenter

    companion object {
        fun newInstance(context: Context): Intent =
            Intent(context, GetStartScreenActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_start_screen)
        setUpPresenter()
        setUpListener()
        mPresenter.onUiReady(this)
    }

    private fun setUpPresenter() {
        mPresenter = getPresenter<GetStartPresenterImpl,GetStartView>()
    }

    override fun navigateToIntroScreen() {
        startActivity(IntroActivity.newInstance(this))
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    private fun setUpListener() {
        btnGetStart.setOnClickListener {
            mPresenter.onTapGetStart()
        }
    }
}