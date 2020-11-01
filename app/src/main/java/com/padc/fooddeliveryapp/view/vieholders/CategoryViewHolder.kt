package com.padc.fooddeliveryapp.view.vieholders

import android.view.View
import androidx.core.net.toUri
import com.padc.fooddeliveryapp.data.vos.CategoryVO
import com.padc.fooddeliveryapp.uitls.load
import com.padc.shared.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.horizontial_item_view.view.*

class CategoryViewHolder(itemView: View) : BaseViewHolder<CategoryVO>(itemView) {
    override fun bindData(data: CategoryVO) {
        mData = data
        data.name?.let { itemView.tvName.text = it }
        itemView.ivFood.load(data.imgurl.toUri())
    }
}