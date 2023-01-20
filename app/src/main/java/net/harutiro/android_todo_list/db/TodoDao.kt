package net.harutiro.android_todo_list.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import net.harutiro.android_todo_list.ListModel

@Dao
interface TodoDao {

    @Insert
    fun insertAll(list: ListModel)

    @Delete
    fun delete(list: ListModel)

    @Query("SELECT * FROM listmodel")
    fun getAll(): List<ListModel>
}