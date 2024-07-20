package com.akirachix.postsapp

import APIclient
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.akirachix.postsapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
//        binding=ActivityMainBinding.inflate(layoutInflater)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
//        binding.rvContacts.layoutManager = GridLayoutManager(this,1)
        binding.rvPosts.layoutManager = GridLayoutManager(this,1)
        fetchPosts()
    }
        fun fetchPosts(){
            val apiInterface = APIclient.buildApiInterface(PostsApiInterface::class.java)
            val request = apiInterface.getPost()
            request.enqueue(object : Callback<List<Post>> {
                override fun onResponse(p0: Call<List<Post>>, p1: Response<List<Post>>) {
                    if(p1.isSuccessful) {
                        val posts = p1.body()
                        posts?.let {
                            val adapter = PostsAdapter(it)
                            binding.rvPosts.adapter = adapter


                            Toast.makeText(
                                baseContext,
                                "Fetched ${posts!!.size}posts",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }

                override fun onFailure(p0: Call<List<Post>>, p1: Throwable) {
                    Toast.makeText(baseContext, p1.message.toString(), Toast.LENGTH_LONG).show()

                }
            })


        }
    }
