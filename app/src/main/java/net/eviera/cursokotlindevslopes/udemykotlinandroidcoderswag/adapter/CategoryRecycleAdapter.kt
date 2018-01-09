package net.eviera.cursokotlindevslopes.udemykotlinandroidcoderswag.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import net.eviera.cursokotlindevslopes.udemykotlinandroidcoderswag.R
import net.eviera.cursokotlindevslopes.udemykotlinandroidcoderswag.model.Category

class CategoryRecycleAdapter(val context: Context, val categories: List<Category>, val itemClicked: (Category) -> Unit) : RecyclerView.Adapter<CategoryRecycleAdapter.Holder>() {

    override fun onBindViewHolder(holder: Holder?, position: Int) {
        holder?.bindCategory(categories[position], context)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    //Cuando se necesita crear un nuevo viewholder
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.category_list_item, parent, false)
        return Holder(view, itemClicked)
    }

    inner class Holder(itemView: View?, val itemClicked: (Category) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val categoryImage = itemView?.findViewById<ImageView>(R.id.categoryImage)
        private val categoryName = itemView?.findViewById<TextView>(R.id.categoryName)

        fun bindCategory(category: Category, context: Context) {
            val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
            categoryImage?.setImageResource(resourceId)
            categoryName?.text = category.title

            //Para implementar un onclick
            itemView.setOnClickListener {
                itemClicked(category)
            }


        }
    }
}