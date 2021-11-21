package com.lyecdevelopers.ekibanda.ui._base

import android.content.Intent
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerAppCompatActivity

/**
 * created by jaba
 */
abstract class BaseActivity <V: ViewDataBinding> : DaggerAppCompatActivity() {
    private var mViewDataBinding: V? = null

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    abstract fun getBindingVariable(): Int

    /**
     * @return layout resource id
     */
    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
    }

    open fun getViewDataBinding(): V? {
        return mViewDataBinding
    }

    open fun performDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
    }

    open fun <Z> newIntent(clazz: Class<Z>?): Intent? {
        return Intent(this, clazz)
    }

    open fun <Z> newActivity(clazz: Class<Z>?) {
        startActivity(newIntent(clazz))
    }

}