package net.eviera.cursokotlindevslopes.udemykotlinandroidcoderswag.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import net.eviera.cursokotlindevslopes.udemykotlinandroidcoderswag.R
import net.eviera.cursokotlindevslopes.udemykotlinandroidcoderswag.model.Product

class ProductAdapter(val context: Context, val products: List<Product>) : RecyclerView.Adapter<ProductAdapter.Holder>() {

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(products[position], context)
    }

    override fun getItemCount(): Int {
        return products.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.product_list_item, parent, false)
        return Holder(view)
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val productImage = itemView.findViewById<ImageView>(R.id.productImage)
        private val productName =  itemView.findViewById<TextView>(R.id.productName)
        private val productPrice =  itemView.findViewById<TextView>(R.id.productPrice)

        fun bind(product: Product, context: Context) {
            val resourceId = context.resources.getIdentifier(product.image, "drawable", context.packageName)
            productImage?.setImageResource(resourceId)
            productName?.text = product.title
            productPrice?.text = product.price

            //Para implementar un onclick
            itemView.setOnClickListener {
                //itemClicked(product)
            }


        }

    }

}