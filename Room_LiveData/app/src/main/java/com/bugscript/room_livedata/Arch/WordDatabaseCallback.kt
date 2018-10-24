package com.bugscript.room_livedata.Arch

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.RoomDatabase
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.IO
import kotlinx.coroutines.experimental.launch
import com.bugscript.room_livedata.Arch.WordRoomDatabase

class WordDatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback() {

    override fun onOpen(db: SupportSQLiteDatabase) {
        super.onOpen(db)
        WordRoomDatabase.INSTANCE?.let { database ->
            scope.launch(Dispatchers.IO) {
                populateDatabase(database.wordDao())
            }
        }
    }
    fun populateDatabase(wordDao: WordDao) {
        wordDao.deleteAll()
        var word = Word("Hello")
        wordDao.insert(word)
        word = Word("World!")
        wordDao.insert(word)
    }
}