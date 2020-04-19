package com.developersbreach.chips.choiceChip

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.developersbreach.chips.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_choice_chip.view.*


class ChoiceChipFragment : Fragment() {

    val ResultString : String = "SUMMARY_RESULT"

    private lateinit var mViewModel: ChoiceChipFragmentViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var mFab: FloatingActionButton
    private var mSummaryValue: String? = String()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments != null) {
            val string: String? = requireArguments().getString("Value")
            Log.e("Result", string)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_choice_chip, container, false)
        recyclerView = view.choice_recycler_view
        mFab = view.findViewById(R.id.shirts_choice_fab)
        mFab.setOnClickListener { showFilterFragment() }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel = ViewModelProvider(this).get(ChoiceChipFragmentViewModel::class.java)

        mViewModel.getShirtData().observe(viewLifecycleOwner, Observer { shirtList ->
            val shirtsAdapter = ShirtsAdapter()
            shirtsAdapter.submitList(shirtList)
            recyclerView.adapter = shirtsAdapter
        })
    }

    private fun showFilterFragment() {
        val direction = ChoiceChipFragmentDirections.actionChoiceChipFragmentToFilterFragment()
        Navigation.createNavigateOnClickListener(direction)
        Navigation.findNavController(this.requireView()).navigate(direction)
    }
}
