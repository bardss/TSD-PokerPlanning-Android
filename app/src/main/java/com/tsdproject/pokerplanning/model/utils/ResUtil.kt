package com.tsdproject.pokerplanning.model.utils

import android.graphics.drawable.Drawable
import com.tsdproject.pokerplanning.base.ApplicationContext

object ResUtil {

    fun getString(resourceId: Int): String {
        return ApplicationContext.appContext.getString(resourceId)
    }

    fun getDrawable(resourceId: Int): Drawable {
        return ApplicationContext.appContext.getDrawable(resourceId)
    }

    fun getColor(resourceId: Int): Int {
        return ApplicationContext.appContext.resources.getColor(resourceId)
    }
}
