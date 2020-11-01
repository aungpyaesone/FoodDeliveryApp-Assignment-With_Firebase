package com.padc.fooddeliveryapp.activites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.padc.fooddeliveryapp.R
import com.padc.fooddeliveryapp.data.vos.BurgerVO
import com.padc.fooddeliveryapp.mvp.presenters.CheckOutPresenter
import com.padc.fooddeliveryapp.mvp.presenters.impls.CheckOutPresenterImpl
import com.padc.fooddeliveryapp.mvp.views.CheckOutView
import com.padc.shared.fragments.BaseFragment
import kotlinx.android.synthetic.main.checkout_bottom_sheet.*


class BottomSheet : BottomSheetDialogFragment(),CheckOutView {
    private var mOrderList:List<BurgerVO> = arrayListOf()

    private lateinit var mPresenter: CheckOutPresenter
    companion object{
        fun newInstance() = BottomSheet()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.checkout_bottom_sheet,container,false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpListener()
        mPresenter.onUiReady(this)
    }

    private fun setUpListener() {
        btnTrackOrder.setOnClickListener {
            mPresenter.onTapTrackOrder(mOrderList)
            dismiss()
            activity?.finish()
            startActivity(context?.let { it1 -> MainActivity.newInstance(it1)})
        }
    }

    fun setOrderList(orderList:List<BurgerVO>)
    {
        mOrderList = orderList
    }

    fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(CheckOutPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun getTheme(): Int {
        return R.style.CustomBottomSheetDialog
    }

    override fun showErrorMessage(error: String) {
        TODO("Not yet implemented")
    }

    override fun showLoading() {
        TODO("Not yet implemented")
    }

    override fun hideLoading() {
        TODO("Not yet implemented")
    }
}