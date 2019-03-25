package net.eviera.cursokotlindevslopes.udemykotlinandroidcoderswag.controller

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_products.*
import net.eviera.cursokotlindevslopes.udemykotlinandroidcoderswag.R
import net.eviera.cursokotlindevslopes.udemykotlinandroidcoderswag.adapter.ProductAdapter
import net.eviera.cursokotlindevslopes.udemykotlinandroidcoderswag.services.DataService
import net.eviera.cursokotlindevslopes.udemykotlinandroidcoderswag.utilities.EXTRA_CATEGORY

class ProductsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY);
        val products = DataService.getProducts(categoryType)

        val orientation = resources.configuration.orientation
        val cols = when(orientation) {
            Configuration.ORIENTATION_LANDSCAPE -> 3
            else -> 2
        }

        productListView.adapter = ProductAdapter(this, products)
        productListView.layoutManager = GridLayoutManager(this, cols)
    }
}
