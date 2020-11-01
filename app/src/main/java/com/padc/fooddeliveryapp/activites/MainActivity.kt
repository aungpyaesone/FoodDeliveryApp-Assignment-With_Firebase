package com.padc.fooddeliveryapp.activites

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.padc.fooddeliveryapp.R
import com.padc.fooddeliveryapp.fragments.AccountFragment
import com.padc.fooddeliveryapp.fragments.OfferFragment
import com.padc.fooddeliveryapp.fragments.RestaurantFragment
import com.padc.shared.activites.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private var restaurantFragment = RestaurantFragment.newInstance()
    private var offerFragment = OfferFragment.newInstance()
    private var accountFragment = AccountFragment.newInstance()
    private var activeFragment : Fragment = RestaurantFragment.newInstance()

    companion object{
     fun newInstance(context:Context):Intent = Intent(context,MainActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupFragmentManager()
        callFragment(restaurantFragment)
        setUpBottomNavigation()
    }

    override fun showLoading() {
        TODO("Not yet implemented")
    }

    override fun hideLoading() {
        TODO("Not yet implemented")
    }

    private fun setUpBottomNavigation() {
        bottomNavigationView.setOnNavigationItemSelectedListener(object :BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when(item.itemId){
                    R.id.restaurant ->{callFragment(restaurantFragment)
                    return true}
                    R.id.offers ->{callFragment(offerFragment)
                        return true}
                    R.id.account ->{callFragment(accountFragment)
                        return true}
                }
                return false
            }
        })
    }


    private fun setupFragmentManager() {
        supportFragmentManager.beginTransaction().apply {
            add(R.id.container,restaurantFragment,getString(R.string.restaurants)).hide(restaurantFragment)
            add(R.id.container,offerFragment,getString(R.string.offer)).hide(offerFragment)
            add(R.id.container,accountFragment,getString(R.string.account)).hide(accountFragment)
        }.commit()

    }

    fun callFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().hide(activeFragment).show(fragment).commit()
        activeFragment = fragment

    }

}