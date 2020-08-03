package com.sid.rxjavarxandroidcodingwithmitch.frompublisher;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import okhttp3.ResponseBody;

public class MainViewModel extends ViewModel {

    private Repository repository;

    public MainViewModel() {
        repository = Repository.getInstance();
    }

    public LiveData<ResponseBody> makeQuery(){
        return repository.makeReactiveQuery();
    }
}