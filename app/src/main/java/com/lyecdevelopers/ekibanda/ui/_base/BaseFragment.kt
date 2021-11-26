package com.lyecdevelopers.ekibanda.ui._base

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.NavController
import androidx.navigation.Navigation
import dagger.android.support.DaggerFragment
import timber.log.Timber


/**
 * created by jaba
 */
abstract class BaseFragment<T : ViewDataBinding, V : BaseViewModel> : DaggerFragment() {
    private lateinit var mActivity: BaseActivity<*>
    private lateinit var mRootView: View
    private lateinit var mViewDataBinding: T
    private lateinit var mViewModel: V
    private lateinit var mNavController: NavController

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    abstract fun getViewModel(): V

    open fun getBaseActivity(): BaseActivity<*> {
        return mActivity
    }

    open fun getViewDataBinding(): T {
        return mViewDataBinding
    }

    /**
     * @return layout resource id
     */
    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        mRootView = mViewDataBinding.root
        setHasOptionsMenu(true)
        return mRootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            mNavController = mRootView.let { Navigation.findNavController(it) }
        } catch (e: Exception) {
            Timber.e(e)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = getViewModel()
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        if (context is BaseActivity<*>) {
            val activity: BaseActivity<*> = context as BaseActivity<*>
            mActivity = activity
        }
    }


    // loading
    protected open fun showLoading(message: String?) {
        mActivity.showLoading(message)
    }

    protected open fun hideLoading() {
        mActivity.hideLoading()
    }

    // intent
    protected open fun <Z> newIntent(clazz: Class<Z>?): Intent? {
        return Intent(getBaseActivity(), clazz)
    }

    protected open fun <Z> newActivity(clazz: Class<Z>?) {
        startActivity(newIntent(clazz))
    }
}