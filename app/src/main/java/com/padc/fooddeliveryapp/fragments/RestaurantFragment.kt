package com.padc.fooddeliveryapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.padc.fooddeliveryapp.R
import com.padc.fooddeliveryapp.activites.DetailActivity
import com.padc.fooddeliveryapp.adapters.HomePopularChoiceAdapter
import com.padc.fooddeliveryapp.adapters.HorizontalAdapter
import com.padc.fooddeliveryapp.adapters.VerticalAdapter
import com.padc.fooddeliveryapp.data.vos.BurgerVO
import com.padc.fooddeliveryapp.data.vos.CategoryVO
import com.padc.fooddeliveryapp.data.vos.RestaurantVO
import com.padc.fooddeliveryapp.mvp.presenters.HomePresenter
import com.padc.fooddeliveryapp.mvp.presenters.impls.HomePresenterImpls
import com.padc.fooddeliveryapp.mvp.views.HomeView
import com.padc.shared.fragments.BaseFragment
import kotlinx.android.synthetic.main.fragment_restaurant.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RestaurantFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RestaurantFragment : BaseFragment(), HomeView {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mPresenter: HomePresenter
    private lateinit var mAdapter : HorizontalAdapter
    private lateinit var mSecondAdapter : VerticalAdapter
    private lateinit var mHomePopularChoiceAdapter : HomePopularChoiceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurant, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpRecycler()
        mPresenter.onUiReady(this)
    }

    private fun setUpPresenter() {
        mPresenter = getPresenter<HomePresenterImpls, HomeView>()
        mAdapter = HorizontalAdapter()
        mSecondAdapter = VerticalAdapter(mPresenter)
        mHomePopularChoiceAdapter = HomePopularChoiceAdapter(mPresenter)
    }

    private fun setUpRecycler() {
        rvHomeOne.adapter = mAdapter
        rvHomeTwo.adapter = mSecondAdapter
    }

    companion object {

        @JvmStatic
        fun newInstance() = RestaurantFragment()
    }

    override fun showRestaurantList(restaurantList: List<RestaurantVO>) {
        mSecondAdapter.setData(restaurantList)

    }

    override fun showCategoryList(categoryList: List<CategoryVO>) {
       mAdapter.setData(categoryList)
    }

    override fun showPopularFoodList(popularFoodList: List<BurgerVO>) {
        mHomePopularChoiceAdapter.setData(popularFoodList)
    }


    override fun navigateToDetailScreen(restaurantVO: RestaurantVO) {
        startActivity(activity?.applicationContext?.let { DetailActivity.newInstance(it,restaurantVO.documentId,restaurantVO.imageurl,restaurantVO.name) })
    }

    override fun displayViewType(viewType: Int) {
        when(viewType){
            0 ->{
               viewTypeOne(viewType)
            }
            1 ->{ viewTypeTwo(viewType) }
        }
    }

    private fun viewTypeOne(viewType: Int){
        rvHomeOne.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = mAdapter
        }

        rvHomeTwo.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = mSecondAdapter
            mSecondAdapter.setViewType(viewType)

        }
    }

    private fun viewTypeTwo(viewType: Int){
        deliveryTo.visibility = View.GONE
        spinnerBar.visibility = View.GONE
        rvHomeOne.visibility = View.GONE
        tvPopularChoice.visibility = View.VISIBLE
        tvNewRestaurant.visibility = View.VISIBLE

        rvPopularChoice.apply {
            visibility = View.VISIBLE
            layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
            adapter = mHomePopularChoiceAdapter
        }

        rvHomeTwo.apply{
            layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)
            adapter = mSecondAdapter
            mSecondAdapter.setViewType(viewType)
        }


    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }
}