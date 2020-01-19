package com.developersbreach.chips.choiceChip

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.developersbreach.chips.R

class ChoiceChipFragment : Fragment() {

    companion object {
        fun newInstance() = ChoiceChipFragment()
    }

    private lateinit var viewModel: ChoiceChipFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_choice_chip, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ChoiceChipFragmentViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
