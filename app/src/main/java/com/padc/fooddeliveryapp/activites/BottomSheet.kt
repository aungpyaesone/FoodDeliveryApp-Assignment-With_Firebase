package com.padc.fooddeliveryapp.activites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.padc.fooddeliveryapp.R


class BottomSheet : BottomSheetDialogFragment() {
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

    override fun getTheme(): Int {
        return R.style.CustomBottomSheetDialog
    }
}