package net.harutiro.android_todo_list

import androidx.room.Entity
import androidx.room.PrimaryKey


//memoテーブルを作ってくれる
@Entity
data class ListModel (
    //プライマリーキーの作成自動でIDも割り振られる
    @PrimaryKey val uid: Int,
    var title:String = "",
    var content:String = ""
)