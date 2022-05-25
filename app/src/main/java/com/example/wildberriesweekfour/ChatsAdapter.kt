package com.example.wildberriesweekfour

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.wildberriesweekfour.databinding.ItemChatBinding

class ChatsAdapter: RecyclerView.Adapter<ChatsAdapter.ChatHolder>() {
    val chatList = ArrayList<ChatData>()

    class ChatHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ItemChatBinding.bind(item)

        fun bind(chat: ChatData) = with(binding) {
            imageView.setImageResource(chat.imageAvatar)
            tvName.text = chat.name
            tvLastMessage.text = chat.listMessages[chat.listMessages.size-1].Messages
            tvCountNewMessages.text = (chat.listMessages.size).toString()

            itemView.setOnClickListener(object : View.OnClickListener {
                override fun onClick(p0: View?) {
                    val arrlistofMessages: ArrayList<Messages> = ArrayList<Messages>(chat.listMessages)
                    val activity = p0?.getContext() as AppCompatActivity
                    val onlyChatFragment: Fragment = OnlyChatFragment()
                    val bundle = Bundle()
                    bundle.putParcelableArrayList("Messages", arrlistofMessages)
                    bundle.putString("name", tvName.text.toString())
                    bundle.putInt("numberOfList", chat.id)

                    onlyChatFragment.arguments = bundle
                    activity.supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment, onlyChatFragment).addToBackStack(null).commit()

                }
            })
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chat, parent, false)
        return ChatHolder(view)
    }

    override fun onBindViewHolder(holder: ChatHolder, position: Int) {
        holder.bind(chatList[position])
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    fun getChats(chats: List<ChatData>){
        chatList.addAll(chats)
    }

    fun getOneChat(chats: List<ChatData>){
        chatList.add(0, chats[0])
    }
}