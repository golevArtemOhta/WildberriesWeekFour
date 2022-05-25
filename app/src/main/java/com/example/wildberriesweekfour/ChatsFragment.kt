package com.example.wildberriesweekfour

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wildberriesweekfour.databinding.FragmentChatsBinding
import android.widget.AbsListView

import androidx.recyclerview.widget.RecyclerView


class ChatsFragment : Fragment() {
    private lateinit var mBinding: FragmentChatsBinding
    val repositry = Repository()
    var chatItems: MutableList<ChatData> = mutableListOf()
    private val adapter = ChatsAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentChatsBinding.inflate(layoutInflater)
        return mBinding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        mBinding.rvChatItems.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0) {
                    // Scrolling up
                } else {
                    chatItems = repositry.getChats().toMutableList()
                    adapter.getChats(chatItems)
                    adapter.notifyDataSetChanged()
                    mBinding.swipeRefresh.isRefreshing = false
                }
            }

        })


        mBinding.swipeRefresh.setOnRefreshListener {
            //chatItems.clear()
            chatItems = repositry.getOneChat().toMutableList()
            adapter.getOneChat(chatItems)
            adapter.notifyDataSetChanged()
            mBinding.swipeRefresh.isRefreshing = false
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onStart() {
        super.onStart()
            chatItems = repositry.getChats().toMutableList()
            adapter.getChats(chatItems)
            adapter.notifyDataSetChanged()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mBinding.rvChatItems.layoutManager = LinearLayoutManager(context)
        mBinding.rvChatItems.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = ChatsFragment()
    }
}