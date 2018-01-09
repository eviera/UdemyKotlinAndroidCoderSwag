package net.eviera.cursokotlindevslopes.udemykotlinandroidcoderswag.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import net.eviera.cursokotlindevslopes.udemykotlinandroidcoderswag.R
import net.eviera.cursokotlindevslopes.udemykotlinandroidcoderswag.model.Category
import org.w3c.dom.Text

/**
 * Created by emi on 1/8/2018.
 */
class CategoryAdapter(val context: Context, val categories: List<Category>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        /*
            Usando un adaptador sencillo, se inflan la vista cada vez y consume muchos recursos
            Usando el ViewHolder, puedo reusar la vista vieja (que me viene en converView) ya inflada
            y solo le seteo los valores de texto e imagen
         */

        val categoryView: View
        val holder: ViewHolder

        //La primera vez
        if (convertView == null) {
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)
            holder = ViewHolder()
            holder.categoryImage = categoryView.findViewById(R.id.categoryImage)
            holder.categoryName = categoryView.findViewById(R.id.categoryName)

            //Lo guardo en el view
            categoryView.tag = holder

        } else {

            //Aca me vuelve la vista reciclada
            holder = convertView.tag as ViewHolder
            categoryView = convertView
        }


        val category = categories[position]
        val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)

        holder.categoryName?.text = category.title
        holder.categoryImage?.setImageResource(resourceId)

        return categoryView
    }

    override fun getItem(position: Int): Any {
        return categories[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return categories.count()
    }

    private class ViewHolder {
        var categoryImage: ImageView? = null
        var categoryName: TextView? = null
    }

}