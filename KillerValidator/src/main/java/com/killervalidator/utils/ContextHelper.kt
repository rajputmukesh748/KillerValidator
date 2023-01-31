package com.killervalidator.utils

import android.content.Context
import java.lang.ref.WeakReference

object ContextHelper {

    private var context: WeakReference<Context>? = null


    /**
     * Set Context with Weak Reference
     * */
    fun setContext(context: Context) {
        safeCallBlock {
            this.context = WeakReference(context)
        }
    }


    /**
     * Get Context
     * */
    fun getContext(): Context? = context?.get()

}