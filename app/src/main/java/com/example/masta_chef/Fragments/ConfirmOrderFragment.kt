package com.example.masta_chef.Fragments

import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.example.masta_chef.Adapter.ConfirmOrderAdapter
import com.example.masta_chef.Classes.Food_Items
import com.example.masta_chef.Classes.SelectedItems
import com.example.masta_chef.Data.FoodItemDataResource
import com.example.masta_chef.databinding.FragmentConfirmOrderBinding


class ConfirmOrderFragment : Fragment() {
    private var _binding: FragmentConfirmOrderBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    val args: ConfirmOrderFragmentArgs by this.navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentConfirmOrderBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding.confirmOrderRcView
        val itemPosition = args.selectedItemsArray
        val itemListFinal  = SelectedItems().selectedFoodList
        val ItemList = FoodItemDataResource().loadItems()
        var totalBill = 0
        for(i in itemPosition){
            itemListFinal.add(ItemList[i])
            totalBill += getString(ItemList[i].priceStringResourceId).toInt()
        }
        binding.totalTv.text = totalBill.toString()


        recyclerView.adapter = ConfirmOrderAdapter(requireContext(),itemListFinal)


  }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}