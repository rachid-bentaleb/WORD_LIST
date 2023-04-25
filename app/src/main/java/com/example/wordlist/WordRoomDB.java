package com.example.wordlist;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database( entities = Words.class, version = 1)
public abstract class WordRoomDB  extends RoomDatabase {

    private static WordRoomDB instance;

    public abstract WordsDao wordsdao();

    //Singlton
    public static synchronized WordRoomDB getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),WordRoomDB.class,"word-database").fallbackToDestructiveMigration().addCallback(roomCallback).build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDataAsyncTasck(instance).execute();

        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };

    private static class PopulateDataAsyncTasck extends AsyncTask<Void,Void,Void>{
        private WordsDao mWordsDao;

        PopulateDataAsyncTasck(WordRoomDB db){
            mWordsDao = db.wordsdao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mWordsDao.insert(new Words("book","Book","noun"));
            mWordsDao.insert(new Words("book","Book","noun"));
            mWordsDao.insert(new Words("book","Book","noun"));
            return null;
        }
    }
}

