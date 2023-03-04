package com.example.taskapp.ui.onBoard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskapp.databinding.ItemOnBoardBinding
import com.example.taskapp.model.OnBoard
import com.example.taskapp.model.Task
import com.example.taskapp.utils.loadImage

class OnBoardAdapter(private val onClick: () -> Unit) :
    Adapter<OnBoardAdapter.OnBoardViewHolder>() {
    private val data = arrayListOf(
        OnBoard(
            "Делай себе напоминалки",
            "Добавляй себе задачи",
            "https://www.google.com/url?sa=i&url=https%3A%2F%2Fgeorgytim.ru%2Fproduktivnost-v-psixologii-chto-eto%2F&psig=AOvVaw2l1HTBMiKT1YWB8-1b8soz&ust=1677584493602000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCPCK8LHPtf0CFQAAAAAdAAAAABAQ"
        ),
        OnBoard(
            "Мы готовы ко всему!",
            "Мы продуктивные",
            "https://www.google.com/url?sa=i&url=https%3A%2F%2Fdzen.ru%2Fmedia%2Fid%2F5d80d572d5bbc300ae2cae10%2Finfografika-4-pravila-dlia-produktivnosti-rabochego-dnia-5d84985de6e8ef00adeb9561&psig=AOvVaw2l1HTBMiKT1YWB8-1b8soz&ust=1677584493602000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCPCK8LHPtf0CFQAAAAAdAAAAABAD"
        ),
        OnBoard(
            "Следи за временем",
            "Успевай везде",
            "https://www.google.com/url?sa=i&url=https%3A%2F%2F4brain.ru%2Fblog%2Fkak-vlijajut-na-produktivnost-motivacija-i-samokontrol%2F&psig=AOvVaw2l1HTBMiKT1YWB8-1b8soz&ust=1677584493602000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCPCK8LHPtf0CFQAAAAAdAAAAABAH"
        )
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardViewHolder {
        return OnBoardViewHolder(
            ItemOnBoardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class OnBoardViewHolder(private val binding: ItemOnBoardBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) {
            binding.tvTitle.text = onBoard.title
            binding.tvDesk.text = onBoard.desc
            binding.image.loadImage(onBoard.image.toString())

            binding.btnStart.isVisible = adapterPosition == data.lastIndex

            binding.btnStart.setOnClickListener {
                onClick()
            }
        }
    }
}