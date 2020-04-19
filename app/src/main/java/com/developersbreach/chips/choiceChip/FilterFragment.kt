package com.developersbreach.chips.choiceChip

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.developersbreach.chips.R
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.snackbar.Snackbar


class FilterFragment : Fragment() {

    private lateinit var mViewModel: ChoiceChipFragmentViewModel
    private lateinit var mShirtSizeChipGroup: ChipGroup
    private lateinit var mShirtTypeChipGroup: ChipGroup
    private lateinit var mShirtColorChipGroup: ChipGroup
    private lateinit var mFilterSelectedButton: Button
    private lateinit var mClearSelectionConstraint: ConstraintLayout


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // get the views and attach the listener
        val view: View = inflater.inflate(R.layout.filter_fragment, container, false)

        mViewModel = ViewModelProvider(this).get(ChoiceChipFragmentViewModel::class.java)
        mShirtSizeChipGroup = view.findViewById(R.id.shirt_size_chip_group)
        mShirtTypeChipGroup = view.findViewById(R.id.shirt_type_chip_group)
        mShirtColorChipGroup = view.findViewById(R.id.shirt_color_chip_group)
        mFilterSelectedButton = view.findViewById(R.id.add_to_card_button)
        mClearSelectionConstraint = view.findViewById(R.id.clear_selection_constraint_layout)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setShirtSizeChipGroup(mShirtSizeChipGroup)
        setShirtTypeChipGroup(mShirtTypeChipGroup)
        setShirtColorChipGroup(mShirtColorChipGroup)
        setFilterSelectionButton(
            mFilterSelectedButton,
            mShirtSizeChipGroup,
            mShirtTypeChipGroup,
            mShirtColorChipGroup
        )
        setClearSelectionListener(mClearSelectionConstraint)
    }

    private fun setFilterSelectionButton(
        addToCartButton: Button, shirtSizeChipGroup: ChipGroup,
        shirtTypeChipGroup: ChipGroup, shirtColorChipGroup: ChipGroup
    ) {
        addToCartButton.setOnClickListener {

            val checkedSizeId: Int = shirtSizeChipGroup.checkedChipId
            val checkedTypeId: Int = shirtTypeChipGroup.checkedChipId
            val checkedColorId: Int = shirtColorChipGroup.checkedChipId

            if (checkedSizeId != -1 && checkedTypeId != -1 && checkedColorId != -1) {

                val shirtSizeChip: Chip = shirtSizeChipGroup.findViewById(checkedSizeId)
                val shirtTypeChip: Chip = shirtTypeChipGroup.findViewById(checkedTypeId)
                val shirtColorChip: Chip = shirtColorChipGroup.findViewById(checkedColorId)
                val shirtSize: String = shirtSizeChip.text.toString()
                val shirtType: String = shirtTypeChip.text.toString()
                val shirtColor: String = shirtColorChip.text.toString()

                val summaryText = "$shirtSize $shirtType $shirtColor"
                showFilterFragment(summaryText)

            } else {
                Toast.makeText(context, "Select All Chips", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showFilterFragment(summaryText: String) {
        val args = Bundle()
        val action = R.id.action_filterFragment_to_choiceChipFragment
        args.putString("Value", summaryText)
        Navigation.findNavController(this.requireView()).navigate(action, args)
    }

    private fun setClearSelectionListener(clearSelectionConstraint: ConstraintLayout) {
        clearSelectionConstraint.setOnClickListener { view ->
            mShirtSizeChipGroup.clearCheck()
            mShirtTypeChipGroup.clearCheck()
            mShirtColorChipGroup.clearCheck()
            Snackbar.make(view, "Removed Selection", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun setShirtSizeChipGroup(shirtSizeChipGroup: ChipGroup) {
        val inflater: LayoutInflater = LayoutInflater.from(shirtSizeChipGroup.context)
        mViewModel.getShirtSizeData().observe(viewLifecycleOwner, Observer { shirtSizeList ->
            setChipGroup(shirtSizeList, inflater, shirtSizeChipGroup)
        })
    }

    private fun setShirtTypeChipGroup(shirtTypeChipGroup: ChipGroup) {
        val inflater: LayoutInflater = LayoutInflater.from(shirtTypeChipGroup.context)
        mViewModel.getShirtTypeData().observe(viewLifecycleOwner, Observer { shirtTypeList ->
            setChipGroup(shirtTypeList, inflater, shirtTypeChipGroup)
        })
    }

    private fun setShirtColorChipGroup(shirtColorChipGroup: ChipGroup) {
        val inflater: LayoutInflater = LayoutInflater.from(shirtColorChipGroup.context)
        mViewModel.getShirtColorData().observe(viewLifecycleOwner, Observer { shirtSizeList ->
            setChipGroup(shirtSizeList, inflater, shirtColorChipGroup)
        })
    }

    private fun setChipGroup(
        shirtPropertyList: List<String>,
        inflater: LayoutInflater,
        shirtPropertyChipGroup: ChipGroup
    ) {
        val chipList: List<Chip> = shirtPropertyList.map { shirtProperty ->
            val chip =
                inflater.inflate(R.layout.item_choice_chip, shirtPropertyChipGroup, false) as Chip
            chip.text = shirtProperty
            chip
        }

        shirtPropertyChipGroup.removeAllViews()
        for (currentChip in chipList) {
            shirtPropertyChipGroup.addView(currentChip)
        }
    }

    companion object {
        fun newInstance(): FilterFragment {
            return FilterFragment()
        }
    }
}