package com.example.wordlist;

import static android.os.FileObserver.DELETE;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@SuppressWarnings("ALL")
@Dao
public interface WordsDao {

   @Insert
    void insert(Words word);

   @Update
    void update(Words word);

   @Delete
    void delete (Words word);

    @Query("DELETE FROM wordtable")
    default void deletewords() {

    }

    @Query("SELECT * From WordTable")
   LiveData<List<Words>> getAllWords();

}
