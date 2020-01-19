package com.developersbreach.chips


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        val materialChipsCardView: CardView = view.findViewById(R.id.material_chip_card_view)
        val entryChipCardView: CardView = view.findViewById(R.id.entry_chip_card_view)
        val choiceChipCardView: CardView = view.findViewById(R.id.choice_chip_card_view)
        val filterChipCardView: CardView = view.findViewById(R.id.filter_chip_card_view)
        val actionChipCardView: CardView = view.findViewById(R.id.action_chip_card_view)

        materialChipsCardView.setOnClickListener {
            view.findNavController().navigate(R.id.action_homeFragment_to_materialChipsFragment)
        }

        entryChipCardView.setOnClickListener {
            view.findNavController().navigate(R.id.action_homeFragment_to_entryChipFragment)
        }

        choiceChipCardView.setOnClickListener {
            view.findNavController().navigate(R.id.action_homeFragment_to_choiceChipFragment)
        }

        filterChipCardView.setOnClickListener {
            view.findNavController().navigate(R.id.action_homeFragment_to_filterChipFragment)
        }

        actionChipCardView.setOnClickListener {
            view.findNavController().navigate(R.id.action_homeFragment_to_actionChipFragment)
        }

        return view
    }

}
