package com.example.wildberriesweekfour

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Messages(val Messages: String, val whoseMessage: Boolean): Parcelable
