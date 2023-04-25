package com.example.wordlist;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordRepositery mRepository;
    private LiveData<List<Words>> mAllwords;


    public WordViewModel(@NonNull Application application) {
        super(application);
        mRepository = new WordRepositery(application);
        mAllwords = mRepository.getAllWords();

    }

    public void insert(Words word){
        mRepository.Insert(word);
    }
    public void delete(Words word){
        mRepository.Delete(word);
    }
    public void update(Words word){
        mRepository.Update(word);
    }
    public void deletAllword(Words word){
        mRepository.DeleteAllwords();
    }
    public LiveData<List<Words>> getAllwords(){
        return mAllwords;
    }






}
