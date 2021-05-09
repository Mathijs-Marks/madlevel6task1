package com.example.madlevel6task1.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel6task1.R
import com.example.madlevel6task1.databinding.FragmentColourBinding
import com.example.madlevel6task1.model.ColourItem
import com.example.madlevel6task1.viewmodel.ColourViewModel
import com.google.android.material.snackbar.Snackbar

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ColourFragment : Fragment() {

    private val colours = arrayListOf<ColourItem>()
    private lateinit var colourAdapter: ColourAdapter

    private val viewModel: ColourViewModel by viewModels()

    private var _binding: FragmentColourBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentColourBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        colourAdapter = ColourAdapter(colours, ::onColourClick)
        binding.rvColours.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        binding.rvColours.adapter = colourAdapter

        observeColours()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onColourClick(colourItem: ColourItem) {
        Snackbar.make(binding.rvColours, "This colour is: ${colourItem.name}", Snackbar.LENGTH_LONG)
            .show()
    }

    private fun observeColours() {
        viewModel.colourItems.observe(viewLifecycleOwner, {
            colours.clear()
            colours.addAll(it)
            colourAdapter.notifyDataSetChanged()
        })
    }
}