package com.example.dz22_dependency_inject_hilt

import android.view.View
import androidx.core.view.isVisible


fun View.visibilityOn() {
    this.isVisible = true
}
fun View.visibilityOff() {
    this.isVisible = false
}
