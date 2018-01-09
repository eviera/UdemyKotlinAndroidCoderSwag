package net.eviera.cursokotlindevslopes.udemykotlinandroidcoderswag.controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import net.eviera.cursokotlindevslopes.udemykotlinandroidcoderswag.R
import net.eviera.cursokotlindevslopes.udemykotlinandroidcoderswag.utilities.EXTRA_CATEGORY

class ProductsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY);

    }
}
