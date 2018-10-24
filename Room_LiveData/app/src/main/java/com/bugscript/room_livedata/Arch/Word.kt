package com.bugscript.room_livedata.Arch

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "word_table")
class Word(@PrimaryKey(autoGenerate = false) @ColumnInfo(name = "word")val word :String)