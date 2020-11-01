package com.padc.fooddeliveryapp.activites

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.padc.fooddeliveryapp.R
import com.padc.fooddeliveryapp.adapters.OrderListAdapter
import com.padc.fooddeliveryapp.data.vos.BurgerVO
import com.padc.fooddeliveryapp.mvp.presenters.OrderPresenter
import com.padc.fooddeliveryapp.mvp.presenters.impls.OrderPresenterImpls
import com.padc.fooddeliveryapp.mvp.views.OrderView
import com.padc.shared.activites.BaseActivity
import kotlinx.android.synthetic.main.activity_basket.*

class BasketActivity : BaseActivity(),OrderView {

    private lateinit var mPresenter: OrderPresenter
    private lateinit var mAdapter : OrderListAdapter
    private lateinit var mBottomSheet: BottomSheet
    private var mOrderList:List<BurgerVO> = arrayListOf()

    companion object{
        fun newInstance(context: Context) = Intent(context,BasketActivity::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basket)
        setUpPresenter()
        setUpRecycler()
        setUpListener()
        mPresenter.onUiReady(this)
    }

    private fun setUpListener() {
        btnCheckOut.setOnClickListener {
            mPresenter.onTapCheckOut()
        }
    }

    private fun setUpRecycler() {
        mAdapter = OrderListAdapter(mPresenter)
        rvOrder.apply {
            layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)
            adapter = mAdapter
        }


    }

    private fun setUpPresenter() {
        mPresenter = getPresenter<OrderPresenterImpls,OrderView>()
    }

    override fun showOrderList(orderList: List<BurgerVO>) {
        mAdapter.setData(orderList)
        mOrderList = orderList
    }

    @SuppressLint("SetTextI18n")
    override fun showTotalPrice(totalPrice: Int) {
        tvAmount.text = "$ $totalPrice"
    }

    override fun showBottomSheet() {
        mBottomSheet = BottomSheet.newInstance()
        mBottomSheet.show(supportFragmentManager,mBottomSheet.tag)
        mBottomSheet.setOrderList(mOrderList)
    }

    override fun showLoading() {

    }

    override fun hideLoading() {
        TODO("Not yet implemented")
    }
}