package com.arviejhay.secretboard.data.model

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

actual fun Long.formatAsDate(): String {
    val sdf = SimpleDateFormat("hh:mm a", Locale.getDefault())
    return sdf.format(Date(this))
}
