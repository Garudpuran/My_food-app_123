package com.example.masta_chef.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.masta_chef.Classes.Food_Items
import com.example.masta_chef.Classes.SelectedItems
import com.example.masta_chef.R

class ItemAdapter(private val context: Context, private val dataset:List<Food_Items>, var myItemList:MutableList<Int>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View):RecyclerView.ViewHolder(view){
        val titleTV: TextView = view.findViewById(R.id.titleTV)
        val desTV:TextView = view.findViewById(R.id.descriptionTV)
        val priceTV:TextView = view.findViewById(R.id.priceTV)
        val titleImgV:ImageView = view.findViewById(R.id.itemImageV)
        val tryButton:Button  = view.findViewById(R.id.tryButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_rc_sample_item,parent,false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemAdapter.ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.titleImgV.setImageDrawable(context.resources.getDrawable(item.drawableResourceId))
        holder.titleTV.text = context.resources.getString(item.titleStringResourceId)
        holder.desTV.text = context.resources.getString(item.descriptionStringResourceId)
        holder.priceTV.text = context.resources.getString(item.priceStringResourceId)
        holder.tryButton.setOnClickListener(View.OnClickListener {


            if(myItemList.contains(position)){
                Toast.makeText(context,"Already added.", Toast.LENGTH_SHORT).show()
            }
            else{
                myItemList.add(position)
                Toast.makeText(context,"Item added.", Toast.LENGTH_SHORT).show()
            }

        })

    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}
