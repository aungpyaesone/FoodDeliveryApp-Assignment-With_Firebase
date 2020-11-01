package com.padc.fooddeliveryapp.fragments

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.net.toUri
import com.padc.fooddeliveryapp.R
import com.padc.fooddeliveryapp.data.vos.User
import com.padc.fooddeliveryapp.mvp.presenters.AccountPresenter
import com.padc.fooddeliveryapp.mvp.presenters.impls.AccountPresenterImpl
import com.padc.fooddeliveryapp.mvp.views.AccountView
import com.padc.fooddeliveryapp.uitls.load
import com.padc.shared.fragments.BaseFragment
import kotlinx.android.synthetic.main.fragment_account.*
import java.io.IOException

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AccountFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AccountFragment : BaseFragment(),AccountView {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



    private lateinit var mPresenter: AccountPresenter
    private var mBitmap:Bitmap? =null


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
        val v = inflater.inflate(R.layout.fragment_account, container, false)
        return  v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpListener()
        mPresenter.onUiReady(this)
    }

    private fun setUpListener() {
        tvSave.setOnClickListener {
         mBitmap?.let {
             mPresenter.updateUserProfile(bitmap = it)
         } ?: kotlin.run {

         }
        }

        ivEdit.setOnClickListener {
            mPresenter.onTapUpdateProfile()
        }
    }

    private fun setUpPresenter() {
       mPresenter = getPresenter<AccountPresenterImpl,AccountView>()
    }


    companion object {
        @JvmStatic
        fun newInstance() = AccountFragment()
        const val PICK_IMAGE_REQUEST = 1111

    }

    override fun openGallery() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT

        startActivityForResult(
                Intent.createChooser(intent, "Select Picture"),
                PICK_IMAGE_REQUEST
        )
    }

    override fun showUserProfile(user: User) {
        user.photoUrl?.let { ivProfile.load(it.toUri()) }
        user.email?.let { etEmail.setText(it) }
        user.name?.let { etName.setText(it) }

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
            if (data == null || data.data == null) {
                return
            }

            val filePath = data.data
            try {

                filePath?.let {
                    if (Build.VERSION.SDK_INT >= 29) {
                        val source: ImageDecoder.Source? = activity?.contentResolver?.let { it1 -> ImageDecoder.createSource(it1, it) }
                        val bitmap = source?.let { it1 -> ImageDecoder.decodeBitmap(it1) }
                        mBitmap = bitmap
                    } else {
                        val bitmap = MediaStore.Images.Media.getBitmap(activity?.contentResolver, it
                        )
                        mBitmap =  bitmap
                        ivProfile.load(it)
                    }
                }

            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}