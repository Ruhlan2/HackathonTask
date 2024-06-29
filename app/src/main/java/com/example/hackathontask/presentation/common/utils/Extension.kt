package com.example.hackathontask.presentation.common.utils

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import androidx.annotation.StringRes
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.hackathontask.databinding.TermsDialogBinding
import com.example.hackathontask.presentation.common.base.setSafeOnClickListener

fun Context.createTermsAndConditionDialog(
    onConfirmOnClick: () -> Unit,
    @StringRes term: Int
): Dialog {
    val dialog = Dialog(this, androidx.appcompat.R.style.Theme_AppCompat_Dialog)
    val binding = TermsDialogBinding.inflate(LayoutInflater.from(this))

    dialog.setCancelable(false)
    dialog.setContentView(binding.root)
    dialog.window?.setBackgroundDrawableResource(android.R.color.transparent);
    dialog.window?.setLayout(
        ConstraintLayout.LayoutParams.MATCH_PARENT,
        ConstraintLayout.LayoutParams.MATCH_PARENT
    )

    with(binding) {
        buttonCancel.setSafeOnClickListener {
            dialog.cancel()
        }
        buttonConfirm.setSafeOnClickListener {
            onConfirmOnClick()
        }
        textTerms.text = getString(term)
    }

    return dialog
}