package com.smith.retrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smith.contactapp.adapter.TodoAdapter
import com.smith.retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        todoAdapter= TodoAdapter(listOf())
        binding.recyclview.adapter=todoAdapter

//retofit here is not supposed to appear in the main activity by profess
        /// fragment and co routines




        val todos : Call<List<Todo>> = RetrofitProvider.service.getAllTodos()

        todos.enqueue(object : Callback<List<Todo>> {
            override fun onResponse(call: Call<List<Todo>>, response: Response<List<Todo>>) {
               if (response.isSuccessful){
                   response.body()?.let{ todos ->
                       todoAdapter.list = todos
                       todoAdapter.notifyDataSetChanged()
                   }

               }

            }

            override fun onFailure(call: Call<List<Todo>>, t: Throwable) {

            }

        })
    }
}