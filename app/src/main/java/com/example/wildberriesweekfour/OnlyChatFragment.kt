package com.example.wildberriesweekfour

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wildberriesweekfour.databinding.FragmentOnlyChatBinding


class OnlyChatFragment : Fragment() {
    lateinit var binding: FragmentOnlyChatBinding
    private val adapter = OneChatAdapter()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnlyChatBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imageButton.setOnClickListener {
            val text = binding.editTextTextPersonName2.text.toString()
            binding.editTextTextPersonName2.text.clear()
            adapter.addMessges(Messages(text, false))
            adapter.notifyDataSetChanged()
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onStart() {
        super.onStart()
        val bundle = this.arguments
        val messages = bundle?.getParcelableArrayList<Messages>("Messages")
        binding.imageViewOnlyChat.setImageResource(R.drawable.morty)
        binding.tvNameOnlyChat.text = bundle?.getString("name")
        adapter.getMessages(messages!!.toList())
        adapter.notifyDataSetChanged()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.rvMessageItems.layoutManager = LinearLayoutManager(context)
        binding.rvMessageItems.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = OnlyChatFragment()
    }
}