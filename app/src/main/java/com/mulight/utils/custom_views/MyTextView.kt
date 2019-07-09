package com.mulight.utils.custom_views

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.mulight.R
import com.mulight.utils.bases.Cons

class MyTextView : AppCompatTextView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val attrsArray = getContext().obtainStyledAttributes(attrs, R.styleable.MyTextView)
        val isTitle = attrsArray.getBoolean(R.styleable.MyTextView_isTitle, false)

        typeface = if (isTitle)
            Cons.TYPEFACE_TITLE
        else
            Cons.TYPEFACE_NORMAL

        attrsArray.recycle()
    }


}