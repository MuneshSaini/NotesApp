package com.muneshsaini.notesapp.ui.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.muneshsaini.notesapp.R
import com.muneshsaini.notesapp.database.TaskEntry
import com.muneshsaini.notesapp.databinding.FragmentAddBinding
import com.muneshsaini.notesapp.viewmodel.TaskViewModel

class AddFragment : Fragment() {

    private val viewModel: TaskViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAddBinding.inflate(layoutInflater)
        val myAdpter = ArrayAdapter<String>(
            requireActivity(),
            android.R.layout.simple_spinner_dropdown_item,
            resources.getStringArray(R.array.priorities)
        )
        binding.apply {
            spinner3.adapter = myAdpter
            btnAdd.setOnClickListener {
                if (TextUtils.isEmpty((edttask.text))) {
                    Toast.makeText(requireContext(), "It's Impty!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                val title_str = edttask.text.toString()
                val priority = spinner3.selectedItemPosition

                val taskEntry = TaskEntry(
                    0,
                    title_str,
                    priority,
                    System.currentTimeMillis()
                )
                viewModel.insert(taskEntry)
                Toast.makeText(requireContext(),"Successfully added!",Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_addFragment_to_taskFragment)
            }
        }
        // Inflate the layout for this fragment
        return binding.root
    }
}