package com.hencoder.view.widget.layout

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import kotlin.math.max

class TagLayout(context: Context?, attrs: AttributeSet?) : ViewGroup(context, attrs) {
    private val childrenBounds = mutableListOf<Rect>()

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var widthUsed = 0
        var heightUsed = 0
        var lineWidthUsed = 0
        var lineMaxHeight = 0
        val specWidthSize = MeasureSpec.getSize(widthMeasureSpec)
        val specWidthMode = MeasureSpec.getMode(widthMeasureSpec)
        for ((index, child) in children.withIndex()) {
//            measureChild(child, widthMeasureSpec, 0, heightMeasureSpec, heightUsed)
            measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, heightUsed)

            if (specWidthMode != MeasureSpec.UNSPECIFIED &&
                    lineWidthUsed + child.measuredWidth > specWidthSize) {
                lineWidthUsed = 0
                heightUsed += lineMaxHeight
                lineMaxHeight = 0
//                measureChild(child, widthMeasureSpec, 0, heightMeasureSpec, heightUsed)
                measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, heightUsed)
            }

            if (index >= childrenBounds.size) {
                childrenBounds.add(Rect())
            }
            val childBounds = childrenBounds[index]
            childBounds.set(lineWidthUsed, heightUsed, lineWidthUsed + child.measuredWidth, heightUsed + child.measuredHeight)

            lineWidthUsed += child.measuredWidth
            widthUsed = max(widthUsed, lineWidthUsed)
            lineMaxHeight = max(lineMaxHeight, child.measuredHeight)
        }
        val selfWidth = widthUsed
        val selfHeight = heightUsed + lineMaxHeight
        setMeasuredDimension(selfWidth, selfHeight)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        for ((index, child) in children.withIndex()) {
            val childBounds = childrenBounds[index]
            child.layout(childBounds.left, childBounds.top, childBounds.right, childBounds.bottom)
        }
    }

    private fun measureChild(child: View, parentWidthMeasureSpec: Int, widthUsed: Int,
                             parentHeightMeasureSpec: Int, heightUsed: Int) {
        val childWidthSpec = getChildSpec(child, parentWidthMeasureSpec, widthUsed)
        val childHeightSpec = getChildSpec(child, parentHeightMeasureSpec, heightUsed)
        child.measure(childWidthSpec, childHeightSpec)
    }

    private fun getChildSpec(child: View, parentMeasureSpec: Int, used: Int): Int {
        val parentSpecSize = MeasureSpec.getSize(parentMeasureSpec)
        val parentSpecMode = MeasureSpec.getMode(parentMeasureSpec)
        val layoutParams = child.layoutParams
        var childSpecMode = 0
        var childSpecSize = 0
        when (layoutParams.width) {
            LayoutParams.MATCH_PARENT -> {
                when (parentSpecMode) {
                    MeasureSpec.EXACTLY -> {
                        childSpecMode = MeasureSpec.EXACTLY
                        childSpecSize = parentSpecSize - used
                    }
                    MeasureSpec.AT_MOST -> {
                        childSpecMode = MeasureSpec.AT_MOST
                        childSpecSize = parentSpecSize - used
                    }
                    MeasureSpec.UNSPECIFIED -> {
                        childSpecMode = MeasureSpec.UNSPECIFIED
                        childSpecSize = 0
                    }
                }
            }
            LayoutParams.WRAP_CONTENT -> {
                when (parentSpecMode) {
                    MeasureSpec.EXACTLY, MeasureSpec.AT_MOST -> {
                        childSpecMode = MeasureSpec.AT_MOST
                        childSpecSize = parentSpecSize - used
                    }
                    MeasureSpec.UNSPECIFIED -> {
                        childSpecMode = MeasureSpec.UNSPECIFIED
                        childSpecSize = 0
                    }
                }
            }
            else -> {
                childSpecMode = MeasureSpec.EXACTLY
                childSpecSize = layoutParams.width
            }
        }
        return MeasureSpec.makeMeasureSpec(childSpecSize, childSpecMode)
    }

    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return MarginLayoutParams(context, attrs)
    }
}