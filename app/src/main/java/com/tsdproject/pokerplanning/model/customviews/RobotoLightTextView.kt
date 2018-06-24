package com.tsdproject.pokerplanning.model.customviews

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import com.rey.material.widget.TextView

class RobotoLightTextView : TextView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        if (!isInEditMode) {
            typeface = Typeface.createFromAsset(context.assets, "fonts/Roboto-Light.ttf")
        }
    }
}