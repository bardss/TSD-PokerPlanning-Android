package com.tsdproject.pokerplanning.model.utils

import com.rey.material.widget.EditText
import com.tsdproject.pokerplanning.R

object EditTextUtil{

    fun checkIfEditTextEmpty(editText: EditText): Boolean {
        val isEditTextEmpty = editText.text.isEmpty()
        if (isEditTextEmpty) {
            editText.error = ResUtil.getString(R.string.blank_edit_text_error)
        } else {
            editText.clearError()
        }
        return isEditTextEmpty
    }
}