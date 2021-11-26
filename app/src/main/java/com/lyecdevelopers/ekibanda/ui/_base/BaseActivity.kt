package com.lyecdevelopers.ekibanda.ui._base

import android.content.Intent
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.lyecdevelopers.ekibanda.utils.CustomLoader
import dagger.android.support.DaggerAppCompatActivity

/**
 * created by jaba
 */
abstract class BaseActivity<V : ViewDataBinding> : DaggerAppCompatActivity() {
    private lateinit var mViewDataBinding: V
    private val LOADER_TAG = "LOADER_TAG"
    private val progressBar: CustomLoader = CustomLoader("PLEASE WAIT")

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

    // view binding
    fun getViewDataBinding(): V {
        return mViewDataBinding
    }

    open fun performDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
    }

    // loading
    fun showLoading(message: String?) {
        message?.let { progressBar.setMessage(it) }
        val ft = supportFragmentManager
        if (ft.findFragmentByTag(LOADER_TAG) == null) {
            progressBar.show(ft, LOADER_TAG)
        }
    }

    fun hideLoading() {
        progressBar.dismiss()
    }




    // intent
    open fun <Z> newIntent(clazz: Class<Z>?): Intent? {
        return Intent(this, clazz)
    }

    open fun <Z> newActivity(clazz: Class<Z>?) {
        startActivity(newIntent(clazz))
    }

    // share app
    fun shareApp() {
        val sendIntent = Intent()
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Lets Share Ekibanda ")
        sendIntent.type = "text/plain"
        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }


}