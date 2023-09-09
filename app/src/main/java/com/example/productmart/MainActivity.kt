package com.example.productmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var adapter: HomeAdapter
    lateinit var vm:HomeViewModel
    lateinit var rv_home:RecyclerView
    lateinit var progress_home:ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_home=findViewById(R.id.rv_home)
        progress_home=findViewById(R.id.progress_home)
        vm=ViewModelProvider(this).get(HomeViewModel::class.java)
        initAdapter()
        vm.fetchAllProduct()
        vm.productListLiveData?.observe(this, Observer {
            if (it!=null)
            {
                rv_home.visibility= View.VISIBLE
                adapter.setData(it as ArrayList<Product>)
            }
            else{
                Toast.makeText(this@MainActivity,"Something went wrong",Toast.LENGTH_SHORT).show()
            }
            progress_home.visibility=View.GONE
        })
    }

    private fun initAdapter() {
        adapter= HomeAdapter(this)
        rv_home.layoutManager=LinearLayoutManager(this)
        rv_home.adapter=adapter
    }
}