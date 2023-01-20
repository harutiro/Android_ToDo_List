package net.harutiro.android_todo_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        //===================================================================

        //リサイクラービューの作成
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        //アダプターの作成
        val adapter = RecyclerViewAdapter()
        recyclerView.adapter = adapter

        //LayoutManagerの設定
        //１つ１つのデータをどのような並びで表示させるかを決めるのがレイアウトマネージャーです。
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val list = mutableListOf(
            ListModel("title1","内容1"),
            ListModel("title2","内容2"),
            ListModel("title3","内容3"),
            ListModel("title4","内容4"),
            ListModel("title4","内容4"),
            ListModel("title4","内容4"),
            ListModel("title4","内容4"),
            ListModel("title4","内容4"),
            ListModel("title4","内容4"),
            ListModel("title4","内容4"),
            ListModel("title4","内容4"),
        )

        adapter.setList(list)
    }
}