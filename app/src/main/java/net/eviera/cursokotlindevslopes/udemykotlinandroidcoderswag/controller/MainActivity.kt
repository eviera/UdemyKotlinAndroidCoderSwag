package net.eviera.cursokotlindevslopes.udemykotlinandroidcoderswag.controller

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import net.eviera.cursokotlindevslopes.udemykotlinandroidcoderswag.R
import net.eviera.cursokotlindevslopes.udemykotlinandroidcoderswag.adapter.CategoryAdapter
import net.eviera.cursokotlindevslopes.udemykotlinandroidcoderswag.adapter.CategoryRecycleAdapter
import net.eviera.cursokotlindevslopes.udemykotlinandroidcoderswag.services.DataService

class MainActivity : AppCompatActivity() {

    //lateinit var adapter: CategoryAdapter
    lateinit var adapter: CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //adapter = CategoryAdapter(this, DataService.categories)
        adapter = CategoryRecycleAdapter(this, DataService.categories)
        categoryListView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        categoryListView.layoutManager = layoutManager
        categoryListView.setHasFixedSize(true)
    }
}

