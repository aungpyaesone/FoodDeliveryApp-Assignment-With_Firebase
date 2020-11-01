package com.padc.fooddeliveryapp.activites

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.net.toUri
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.padc.fooddeliveryapp.R
import com.padc.fooddeliveryapp.adapters.BurgerListAdapter
import com.padc.fooddeliveryapp.adapters.PopularFoodItemAdapter
import com.padc.fooddeliveryapp.data.vos.BurgerVO
import com.padc.fooddeliveryapp.mvp.presenters.DetailPresenter
import com.padc.fooddeliveryapp.mvp.presenters.impls.DetailPresenterImpl
import com.padc.fooddeliveryapp.mvp.views.DetailView
import com.padc.fooddeliveryapp.uitls.load
import com.padc.shared.activites.BaseActivity
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.detail_layout.*

class DetailActivity : BaseActivity(),DetailView {

    private lateinit var mPresenter: DetailPresenter
    private lateinit var mAdapter : BurgerListAdapter
    private lateinit var mPopularAdapter : PopularFoodItemAdapter

    companion object{
        const val DOCUMENT_ID = "document_id"
        const val IMG_URL = "image_url"
        const val TITLE = "title"
        fun newInstance(context: Context,docId:String,imgUrl:String?,title:String?) =
                Intent(context,DetailActivity::class.java).apply {
                    putExtra(DOCUMENT_ID,docId)
                    putExtra(IMG_URL,imgUrl)
                    putExtra(TITLE,title)
                }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setUpPresenter()
        setUpListener()
        setUpRecycler()
        val documentId = intent.getStringExtra(DOCUMENT_ID)
        intent.getStringExtra(IMG_URL)?.toUri()?.let { ivBurgerImage.load(it) }
        intent.getStringExtra(TITLE)?.let{ tvRestaurantTitle.text = it }
        documentId?.let { mPresenter.onUiReady(this, it) }


    }

    private fun setUpListener() {
        btnAddTocart.setOnClickListener {
         mPresenter.onTapGoToCart()
        }
    }

    private fun setUpRecycler() {
        rvBurgerList.apply {
            layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)
            adapter = mAdapter
        }

        rvBurgers.apply {
            layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
            adapter = mPopularAdapter
        }


    }

    private fun setUpPresenter() {
        mPresenter = getPresenter<DetailPresenterImpl,DetailView>()
        mAdapter = BurgerListAdapter(mPresenter)
        mPopularAdapter = PopularFoodItemAdapter(mPresenter)
    }

    override fun showDetailList(detailList: List<BurgerVO>) {
      mAdapter.setData(detailList)
    }

    override fun showPopularChoiceList(popularChoiceList: List<BurgerVO>) {
        mPopularAdapter.setData(popularChoiceList)
    }

    override fun showAddToCart() {
        btnAddTocart.visibility = View.VISIBLE
    }

    override fun navigateToOrderScreen() {
        startActivity(BasketActivity.newInstance(this))
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }
}