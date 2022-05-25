package com.example.wildberriesweekfour

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.wildberriesweekfour.databinding.ItemOneChatBinding

class OneChatAdapter: RecyclerView.Adapter<OneChatAdapter.OneChatHolder>() {
    val messageList = ArrayList<Messages>()
    val repositry = Repository()

    class OneChatHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ItemOneChatBinding.bind(item)

        fun bind(message: Messages) = with(binding) {
            if (message.whoseMessage){
                tvMessageMy.visibility = View.GONE
                tvMessageCompanion.visibility = View.VISIBLE
                tvMessageCompanion.text = message.Messages
            }
            else{
                tvMessageCompanion.visibility = View.GONE
                tvMessageMy.visibility = View.VISIBLE
                tvMessageMy.text = message.Messages
            }


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OneChatHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_one_chat, parent, false)
        return OneChatHolder(view)
    }

    override fun onBindViewHolder(holder: OneChatHolder, position: Int) {
        holder.bind(messageList[position])
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    fun getMessages(messages: List<Messages>){
        messageList.addAll(messages)
    }

    fun addMessges(message: Messages){
        messageList.add(message)
    }
}