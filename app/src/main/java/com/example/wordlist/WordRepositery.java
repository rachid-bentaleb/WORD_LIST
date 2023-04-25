package com.example.wordlist;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepositery {

    private WordsDao mWordDao;
    private LiveData<List<Words>> getAllWords;

    public WordRepositery (Application app){
        WordRoomDB db = WordRoomDB.getInstance(app);
        mWordDao = db.wordsdao();
        getAllWords = mWordDao.getAllWords();
    }
    //operation

    //insert
    public void Insert(Words word){
      new InsertAsyncTask(mWordDao).execute(word);
    }
    //delete
    public void Delete(Words word){
     new DeleteAsyncTask(mWordDao).execute(word);
    }
    //update
    public void Update(Words word){
    new UpdateAsyncTask(mWordDao).execute(word);
    }
    //getallwords

    public  LiveData<List<Words>> getAllWords(){
        return getAllWords;
    }
    //delet all Words
    public void DeleteAllwords(){
      new DeletAllwordAsyncTask(mWordDao).execute();
    }

    private static  class  InsertAsyncTask extends AsyncTask<Words,Void,Void>{

        private  WordsDao mwordao;
        public InsertAsyncTask(WordsDao wordsDao){
            mwordao = wordsDao;
        }


        @Override
        protected Void doInBackground(Words... words) {
            mwordao.insert(words[0]);
            return null;
        }
    }

    private static  class  DeleteAsyncTask extends AsyncTask<Words,Void,Void>{

        private  WordsDao mwordao;
        public DeleteAsyncTask(WordsDao wordsDao){
            mwordao = wordsDao;
        }


        @Override
        protected Void doInBackground(Words... words) {
            mwordao.delete(words[0]);
            return null;
        }
    }

    private static  class  UpdateAsyncTask extends AsyncTask<Words,Void,Void>{

        private  WordsDao mwordao;
        public UpdateAsyncTask(WordsDao wordsDao){
            mwordao = wordsDao;
        }


        @Override
        protected Void doInBackground(Words... words) {
            mwordao.update(words[0]);
            return null;
        }
    }

    private static  class  DeletAllwordAsyncTask extends AsyncTask<Void,Void,Void>{

        private  WordsDao mwordao;
        public DeletAllwordAsyncTask(WordsDao wordsDao){
            mwordao = wordsDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mwordao.deletewords();
            return null;
        }
    }




}
