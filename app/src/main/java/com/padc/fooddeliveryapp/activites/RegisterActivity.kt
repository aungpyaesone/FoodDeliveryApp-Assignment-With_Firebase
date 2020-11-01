package com.padc.fooddeliveryapp.activites

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.padc.fooddeliveryapp.R
import com.padc.fooddeliveryapp.mvp.presenters.RegisterPresenter
import com.padc.fooddeliveryapp.mvp.presenters.impls.RegisterPresenterImpl
import com.padc.fooddeliveryapp.mvp.views.RegisterView
import com.padc.shared.activites.BaseActivity
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.etEmail

class RegisterActivity : BaseActivity(),RegisterView {

    private lateinit var mPresenter: RegisterPresenter

    companion object{
        fun newInstance(context: Context):Intent = Intent(context,RegisterActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        setUpPresenter()
        setUpListener()
        mPresenter.onUiReady(this)
    }

    private fun setUpPresenter() {
        mPresenter = getPresenter<RegisterPresenterImpl,RegisterView>()
    }

    override fun navigateToHomeScreen() {
        startActivity(MainActivity.newInstance(this))
    }

    override fun navigateToLoginScreen() {
        startActivity(LoginActivity.newInstance(this))
    }

    override fun navigateBack() {
        onBackPressed()
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
       progressBar.visibility = View.GONE
    }

    private fun setUpListener() {
        btnRegister.setOnClickListener {
            mPresenter.onTapRegister(etEmail.text.toString(),
            tvPassword.text.toString(),
            etUserName.text.toString())
        }

        tvLogin.setOnClickListener {
           mPresenter.onTapLogin()
        }

        ivBack.setOnClickListener {
            Toast.makeText(this,"hi",Toast.LENGTH_SHORT).show()
            mPresenter.onTapBack()
        }
    }

}