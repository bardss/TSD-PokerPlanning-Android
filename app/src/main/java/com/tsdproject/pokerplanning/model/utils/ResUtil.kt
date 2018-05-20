package com.tsdproject.pokerplanning.model.utils

import com.tsdproject.pokerplanning.base.ApplicationContext

object ResUtil {

    fun getString(resourceId: Int): String {
        return ApplicationContext.appContext.getString(resourceId)
    }
}
