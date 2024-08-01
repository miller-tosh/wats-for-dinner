package com.example.watsfordinner.ui.generate;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GenerationViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public GenerationViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}