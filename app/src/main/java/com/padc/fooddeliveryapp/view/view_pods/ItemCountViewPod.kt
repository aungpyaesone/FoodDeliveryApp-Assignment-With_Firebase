package com.padc.fooddeliveryapp.view.view_pods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.padc.fooddeliveryapp.data.vos.BurgerVO
import kotlinx.android.synthetic.main.item_view_pod.view.*

class ItemCountViewPod @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private var mDelegate: Delegate? = null
    private var mFoodItem = BurgerVO()

    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }

    fun setUpListener(){
        tvIncrease.setOnClickListener {
            mDelegate?.onTapIncreased(mFoodItem)
        }

        ivDecreased.setOnClickListener {
            mDelegate?.onTapDecreased(mFoodItem)
        }

        ivDelete.setOnClickListener {
            mDelegate?.onTapDelete(mFoodItem)
        }
    }

    fun bindData(foodItem:BurgerVO){
        mFoodItem = foodItem
        tvCount.text = foodItem.count.toString()
    }

    fun setDelegate(delegate: Delegate){
        mDelegate = delegate
    }


    interface Delegate{
        fun onTapIncreased(foodItem: BurgerVO)
        fun onTapDecreased(foodItem: BurgerVO)
        fun onTapDelete(foodItem: BurgerVO)
    }
}