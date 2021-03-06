package com.example.toko;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.toko.Task;

@Database(entities = {Task.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TaskDao taskDao();
}