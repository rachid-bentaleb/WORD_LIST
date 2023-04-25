package com.example.wordlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {

    private List<Words> mWordList = new ArrayList<>();


    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.word_list_item,parent,false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
       Words currrentWord = mWordList.get(position);
       holder.textViewWord.setText(currrentWord.getWordName());
       holder.textViewType.setText(currrentWord.getWordType());
       holder.textViewMeaning.setText(currrentWord.getWordMeaning());


    }

    public void setWord(List<Words> words){
        mWordList = words;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return mWordList.size();
    }
    public static  class WordViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewWord;
        public TextView textViewMeaning;
        public TextView textViewType;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewWord = itemView.findViewById(R.id.word_text);
            textViewMeaning = itemView.findViewById(R.id.meaning);
            textViewType = itemView.findViewById(R.id.type);

        }
    }
}
