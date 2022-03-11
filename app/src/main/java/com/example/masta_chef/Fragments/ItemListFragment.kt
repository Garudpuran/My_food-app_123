package com.example.masta_chef.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.masta_chef.Adapter.ItemAdapter
import com.example.masta_chef.Classes.Food_Items
import com.example.masta_chef.Classes.SelectedItems
import com.example.masta_chef.Data.FoodItemDataResource
import com.example.masta_chef.databinding.FragmentItemListBinding

class ItemListFragment : Fragment() {
    private var _binding: FragmentItemListBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    val selItemList = SelectedItems()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myDataSet = FoodItemDataResource().loadItems()
        val myItemList = mutableListOf<Int>()
        recyclerView = binding.itemRcViewMain
        recyclerView.adapter = ItemAdapter(requireContext(),myDataSet,myItemList)
        recyclerView.setHasFixedSize(true)


        binding.proceedBtn.setOnClickListener(View.OnClickListener {
            if(myItemList.isEmpty()){
                Toast.makeText(requireContext(),"Add items first.",Toast.LENGTH_SHORT).show()
            }
            else {
                val action = ItemListFragmentDirections.actionItemListFragmentToConfirmOrderFragment(myItemList.toIntArray())
                binding.proceedBtn.findNavController().navigate(action)
            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}