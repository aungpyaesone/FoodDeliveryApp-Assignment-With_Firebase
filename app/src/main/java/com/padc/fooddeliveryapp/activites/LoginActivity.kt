package com.padc.fooddeliveryapp.activites

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.padc.fooddeliveryapp.R
import com.padc.fooddeliveryapp.mvp.presenters.LoginPresenter
import com.padc.fooddeliveryapp.mvp.presenters.impls.LoginPresenterImpl
import com.padc.fooddeliveryapp.mvp.views.LoginView
import com.padc.shared.activites.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : BaseActivity(),LoginView {

    private lateinit var mPresenter: LoginPresenter

    companion object{
        fun newInstance(context: Context): Intent = Intent(context,LoginActivity::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setUpPresenter()
        setUpListener()

        mPresenter.onUiReady(this)
    }

    private fun setUpPresenter() {
        mPresenter = getPresenter<LoginPresenterImpl, LoginView>()
    }

    private fun setUpListener() {
        btnLogin.setOnClickListener {
            mPresenter.onTapLogin(etEmail.text.toString(),tvPassword.text.toString())
        }
        tvSignup.setOnClickListener {
           mPresenter.onTapRegister()
        }

        ivBack.setOnClickListener {
            Toast.makeText(this,"hi", Toast.LENGTH_SHORT).show()
            mPresenter.onTapBack()
        }


    }
    override fun navigateToHomeScreen() {
        startActivity(MainActivity.newInstance(this))
        finish()
    }

    override fun navigateToRegisterScreen() {
        startActivity(RegisterActivity.newInstance(this))
    }

    override fun navigateToBack() {
       onBackPressed()
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }
}