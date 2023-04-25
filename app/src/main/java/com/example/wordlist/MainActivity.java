package com.example.wordlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private WordViewModel mWordViewModel;
    private WordAdapter mWordAdapter;

    private RecyclerView mRecycleView;
    private WordAdapter getmWordAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton floatingActionButton = findViewById(R.id.button_add_word);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
                    Intent intent = new Intent(MainActivity.this, WifiManager.AddNetworkResult.class);
                    startActivity(intent);
                }
            }
        });

        mRecycleView = findViewById(R.id.words_recycle_view);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mRecycleView.setHasFixedSize(true);

        mWordAdapter = new WordAdapter();
        mRecycleView.setAdapter(mWordAdapter);

        mWordViewModel = new WordViewModel(getApplication());
        mWordViewModel.getAllwords().observe(this, new Observer<List<Words>>() {
            @Override
            public void onChanged(List<Words> words) {
                mWordAdapter.setWord(words);
                Toast.makeText(MainActivity.this, "on Change worked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}