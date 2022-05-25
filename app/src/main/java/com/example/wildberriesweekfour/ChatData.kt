package com.example.wildberriesweekfour

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


data class ChatData(
    val id: Int,
    val imageAvatar: Int,
    val name: String,
    var listMessages: List<Messages>,
    val isNewMessage: Boolean
)
