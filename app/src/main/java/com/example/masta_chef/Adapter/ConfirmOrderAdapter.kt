package com.example.masta_chef.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.example.masta_chef.Classes.Food_Items
import com.example.masta_chef.Classes.SelectedItems
import com.example.masta_chef.Fragments.ConfirmOrderFragment
import com.example.masta_chef.Fragments.ConfirmOrderFragmentDirections
import com.example.masta_chef.R

class ConfirmOrderAdapter(private val context: Context, var myItemList:MutableList<Food_Items>): RecyclerView.Adapter<ConfirmOrderAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.selected_item_sample,parent,false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = myItemList[position]
        val itemListFinal  = SelectedItems().selectedFoodList
        holder.titleImgV.setImageDrawable(context.resources.getDrawable(item.drawableResourceId))
        holder.titleTV.text = context.resources.getString(item.titleStringResourceId)
        holder.desTV.text = context.resources.getString(item.descriptionStringResourceId)
        holder.priceTV.text = context.resources.getString(item.priceStringResourceId)
        holder.cancelBtn.setOnClickListener(View.OnClickListener {
        myItemList.removeAt(position)
            notifyDataSetChanged()
            if(myItemList.isEmpty()){
                Toast.makeText(context,"Cart Empty!",Toast.LENGTH_SHORT).show()
            }

})

    }

    override fun getItemCount(): Int {
       return myItemList.size
    }
    class ItemViewHolder(private val view: View):RecyclerView.ViewHolder(view){
        val titleTV: TextView = view.findViewById(R.id.titleTV)
        val desTV: TextView = view.findViewById(R.id.descriptionTV)
        val priceTV: TextView = view.findViewById(R.id.priceTV)
        val titleImgV: ImageView = view.findViewById(R.id.itemImageV)
        val cancelBtn:ImageView = view.findViewById(R.id.cancel_order_btn)
    }
}