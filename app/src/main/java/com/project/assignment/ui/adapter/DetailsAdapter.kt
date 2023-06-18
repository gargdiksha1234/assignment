package com.project.assignment.ui.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.RecyclerView
import com.project.assignment.R
import com.project.assignment.databinding.UserlistLayoutBinding
import com.project.assignment.model.response.UserListResponse


class DetailsAdapter(
    private val arraylistdata: UserListResponse,
    private val onclick: (Int) -> Unit,
    private val context: Context
): RecyclerView.Adapter<DetailsAdapter.RecyclerViewHolder>() {

    private lateinit var binding:UserlistLayoutBinding

    inner class RecyclerViewHolder(val binding: UserlistLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int){
            binding.root.setOnClickListener{
               onclick(position)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        binding= UserlistLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val data = arraylistdata.get(position)
       binding.tvName.text=context.getString(R.string.name)+data.name
        binding.tvUserName.text=context.getString(R.string.user_name)+ data.username
        binding.tvEmail.text=context.getString(R.string.email)+ data.email
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return arraylistdata.size
    }
}