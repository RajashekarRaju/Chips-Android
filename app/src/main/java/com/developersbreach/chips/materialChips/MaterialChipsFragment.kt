package com.developersbreach.chips.materialChips


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.developersbreach.chips.R
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

/**
 * A simple [Fragment] subclass.
 */
class MaterialChipsFragment : Fragment() {

    private lateinit var mEntryChipGroup: ChipGroup
    private lateinit var mChoiceChipGroup: ChipGroup
    private lateinit var mFilterChipGroup: ChipGroup
    private lateinit var mActionChipGroup: ChipGroup
    private lateinit var mViewModel: MaterialChipsFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_material_chips, container, false)

        mViewModel = ViewModelProviders.of(this).get(MaterialChipsFragmentViewModel::class.java)

        mEntryChipGroup = view.findViewById(R.id.entry_chip_group)
        mChoiceChipGroup = view.findViewById(R.id.choice_chip_group)
        mFilterChipGroup = view.findViewById(R.id.filter_chip_group)
        mActionChipGroup = view.findViewById(R.id.action_chip_group)

        setEntryChipGroup(mEntryChipGroup)
        setChoiceChipGroup(mChoiceChipGroup)
        setFilterChipGroup(mFilterChipGroup)
        setActionChipGroup(mActionChipGroup)

        return view
    }

    private fun setEntryChipGroup(entryChipGroup: ChipGroup) {
        mViewModel.getEntryChipData().observe(this, Observer { entryChipList ->
            val layoutInflater: LayoutInflater = LayoutInflater.from(entryChipGroup.context)
            val chipList: List<Chip> = entryChipList.map { entryChipData ->
                val chip: Chip = layoutInflater.inflate(R.layout.item_entry_chip, entryChipGroup, false) as Chip
                chip.text = entryChipData.chipName
                chip.setChipIconResource(entryChipData.chipIcon)
                chip.setChipIconTintResource(R.color.colorWhite)
                chip
            }

            addChipsToGroup(entryChipGroup, chipList)
        })
    }

    private fun setChoiceChipGroup(choiceChipGroup: ChipGroup) {
        mViewModel.getChoiceChipData().observe(this, Observer { choiceChipList ->
            val layoutInflater: LayoutInflater = LayoutInflater.from(choiceChipGroup.context)
            val chipList: List<Chip> = choiceChipList.map { choiceChipData ->
                val chip = layoutInflater.inflate(R.layout.item_choice_chip, choiceChipGroup, false) as Chip
                chip.text = choiceChipData
                chip
            }

            addChipsToGroup(choiceChipGroup, chipList)
        })
    }

    private fun setFilterChipGroup(filterChipGroup: ChipGroup) {
        mViewModel.getFilterChipData().observe(this, Observer { filterChipList ->
            val layoutInflater: LayoutInflater = LayoutInflater.from(filterChipGroup.context)
            val chipList: List<Chip> = filterChipList.map { filterChipData ->
                val chip = layoutInflater.inflate(R.layout.item_filter_chip, filterChipGroup, false) as Chip
                chip.text = filterChipData
                chip
            }

            addChipsToGroup(filterChipGroup, chipList)
        })
    }

    private fun setActionChipGroup(actionChipGroup: ChipGroup) {
        mViewModel.getActionChipData().observe(this, Observer { actionChipList ->
            val layoutInflater: LayoutInflater = LayoutInflater.from(actionChipGroup.context)
            val chipList: List<Chip> = actionChipList.map { actionChipData ->
                val chip = layoutInflater.inflate(R.layout.item_action_chip, actionChipGroup, false) as Chip
                chip.text = actionChipData.chipName
                chip.setChipIconResource(actionChipData.chipIcon)
                chip
            }

            addChipsToGroup(actionChipGroup, chipList)
        })
    }

    private fun addChipsToGroup(chipGroup: ChipGroup, chipList: List<Chip>) {
        chipGroup.removeAllViews()
        for (currentChip in chipList) {
            chipGroup.addView(currentChip)
        }
    }

}
