package com.developersbreach.chips.materialChips

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.developersbreach.chips.R

class MaterialChipsFragmentViewModel(application: Application): AndroidViewModel(application) {

    data class ChipData(val chipName: String, val chipIcon: Int)

    private var mEntryChipData = MutableLiveData<List<ChipData>>()
    private var mChoiceChipData = MutableLiveData<List<String>>()
    private var mFilterChipData = MutableLiveData<List<String>>()
    private var mActionChipData = MutableLiveData<List<ChipData>>()

    fun getEntryChipData(): MutableLiveData<List<ChipData>> {
        mEntryChipData.value = mEntryChipList
        return mEntryChipData
    }

    fun getChoiceChipData(): MutableLiveData<List<String>> {
        mChoiceChipData.value = mChoiceChipList
        return mChoiceChipData
    }

    fun getFilterChipData(): MutableLiveData<List<String>> {
        mFilterChipData.value = mFilterChipList
        return mFilterChipData
    }

    fun getActionChipData(): MutableLiveData<List<ChipData>> {
        mActionChipData.value = mActionChipList
        return mActionChipData
    }

    private var mEntryChipList = listOf(
        ChipData("Happy", R.drawable.ic_sentiment_very_satisfied),
        ChipData("Child", R.drawable.ic_child),
        ChipData("Face", R.drawable.ic_face),
        ChipData("Sad", R.drawable.ic_sentiment_very_dissatisfied),
        ChipData("Satisfied", R.drawable.ic_sentiment_satisfied)
    )

    private var mChoiceChipList = listOf(
        "Extra Soft", "Soft", "Medium", "Hard", "Extra Hard"
    )

    private var mFilterChipList = listOf(
        "Action", "Adventure", "Puzzle", "Racing", "Trivia"
    )

    private var mActionChipList = listOf(
        ChipData("Add to Favorites", R.drawable.ic_favorite),
        ChipData("Book Hotel", R.drawable.ic_book_hotel),
        ChipData("Bookmark", R.drawable.ic_bookmark),
        ChipData("Set Alarm", R.drawable.ic_alarm),
        ChipData("Directions", R.drawable.ic_directions)
    )
}