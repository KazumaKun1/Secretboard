package com.arviejhay.secretboard.data.model

import platform.Foundation.NSDate
import platform.Foundation.NSDateFormatter
import platform.Foundation.NSLocale
import platform.Foundation.currentLocale

actual fun Long.formatAsDate(): String {
    val date = NSDate()
    val formatter = NSDateFormatter()
    formatter.dateFormat = "hh:mm a"
    formatter.locale = NSLocale.currentLocale
    return formatter.stringFromDate(date)
}