package com.smith.contactapp.adapter



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smith.retrofit.Todo
import com.smith.retrofit.databinding.TodoItemBinding

class TodoAdapter(
    var list: List<Todo>
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(val binding: TodoItemBinding)
        :RecyclerView.ViewHolder(binding.root){

        fun bind(todo :Todo){
            binding.textView.text = todo.title
            if (todo.completed){
                binding.imageView.visibility =View.VISIBLE
            }else{
                binding.imageView.visibility = View.GONE // or innvisible to amke viw dispaperar
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding: TodoItemBinding =
            TodoItemBinding.inflate(LayoutInflater.from(parent.context), parent,
                false)

        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int): Unit {
        holder.bind(list.get(position))
    }
    override fun getItemCount() = list.size
}