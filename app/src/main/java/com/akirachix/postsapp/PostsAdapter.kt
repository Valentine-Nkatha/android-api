package com.akirachix.postsapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akirachix.postsapp.databinding.PostsListsBinding

class PostsAdapter(var postslist:List<Post>):RecyclerView.Adapter<postsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): postsViewHolder {
        val binding = PostsListsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return postsViewHolder(binding)

//        val binding = ContactsListItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
//        return ContactsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: postsViewHolder, position: Int) {
        var manyposts=postslist[position]
        holder.binding.tvTitle.text=manyposts.title
        holder.binding.tvBody.text= manyposts.body
    }

    override fun getItemCount(): Int {
        return postslist.size
    }
}
class postsViewHolder(var binding: PostsListsBinding):RecyclerView.ViewHolder(binding.root)