package com.example.sleeptracker

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = arrayOf(Sleep::class), version = 1)
public abstract class SleepDatabase: RoomDatabase() {
    //create an instance of the DAO
    abstract fun sleepDao():SleepDao

    companion object {
        //create an instance of the Room Database
        //Singleton prevents multiple instances of the database
        //prevent system create another instance for the database
        @Volatile
        private var INSTANCE : SleepDatabase?=null

        fun getDatabase(context: Context) : SleepDatabase{
            val tempDB = INSTANCE
            if(tempDB!=null){
                return tempDB
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context,SleepDatabase::class.java,
                    "sleep_db"
                ).build()
                INSTANCE = instance
                return instance
            }


        }

    }
}