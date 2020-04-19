package com.developersbreach.chips.choiceChip

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class ChoiceChipFragmentViewModel(application: Application): AndroidViewModel(application) {

    private val mShirtData = MutableLiveData<List<Shirts>>()
    private val mShirtSizeData = MutableLiveData<List<String>>()
    private val mShirtTypeData = MutableLiveData<List<String>>()
    private val mShirtColorData = MutableLiveData<List<String>>()

    fun getShirtData(): MutableLiveData<List<Shirts>> {
        mShirtData.value = mShirtList
        return mShirtData
    }

    fun getShirtSizeData(): MutableLiveData<List<String>> {
        mShirtSizeData.value = mShirtSizeList
        return mShirtSizeData
    }

    fun getShirtTypeData(): MutableLiveData<List<String>> {
        mShirtTypeData.value = mShirtTypeList
        return mShirtTypeData
    }

    fun getShirtColorData(): MutableLiveData<List<String>> {
        mShirtColorData.value = mShirtColorList
        return mShirtColorData
    }

    private val mShirtSizeList: List<String> = listOf(
        "38", "40", "42"
    )

    private val mShirtTypeList: List<String> = listOf(
        "Small", "Medium", "Long"
    )

    private val mShirtColorList: List<String> = listOf(
        "Blue", "Black", "Teal"
    )

    private val mShirtList: List<Shirts> = listOf(
        Shirts("38", "Small", "Blue"),
        Shirts("38", "Small", "Black"),
        Shirts("38", "Small", "Teal"),
        Shirts("38", "Medium", "Blue"),
        Shirts("38", "Medium", "Black"),
        Shirts("38", "Medium", "Teal"),
        Shirts("38", "Long", "Blue"),
        Shirts("38", "Long", "Black"),
        Shirts("38", "Long", "Teal"),
        Shirts("40", "Medium", "Blue"),
        Shirts("40", "Medium", "Black"),
        Shirts("40", "Medium", "Teal"),
        Shirts("40", "Small", "Blue"),
        Shirts("40", "Small", "Black"),
        Shirts("40", "Small", "Teal"),
        Shirts("40", "Long", "Blue"),
        Shirts("40", "Long", "Black"),
        Shirts("40", "Long", "Teal"),
        Shirts("42", "Long", "Blue"),
        Shirts("42", "Long", "Black"),
        Shirts("42", "Long", "Teal"),
        Shirts("42", "Small", "Blue"),
        Shirts("42", "Small", "Black"),
        Shirts("42", "Small", "Teal"),
        Shirts("42", "Medium", "Blue"),
        Shirts("42", "Medium", "Black"),
        Shirts("42", "Medium", "Teal")
    )
}
