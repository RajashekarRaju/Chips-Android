package com.developersbreach.chips.entryChip

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.developersbreach.chips.R

class EntryChipFragment : Fragment() {

    companion object {
        fun newInstance() = EntryChipFragment()
    }

    private lateinit var viewModel: EntryChipFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_entry_chip, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(EntryChipFragmentViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
