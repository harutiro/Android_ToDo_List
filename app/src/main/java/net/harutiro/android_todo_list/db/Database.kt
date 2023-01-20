package net.harutiro.android_todo_list.db

import net.harutiro.android_todo_list.ListModel
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ListModel::class], version = 1 ,exportSchema = false)
abstract class Database : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}