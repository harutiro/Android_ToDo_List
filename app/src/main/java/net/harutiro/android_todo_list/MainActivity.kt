package net.harutiro.android_todo_list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.harutiro.android_todo_list.db.TodoDao
import net.harutiro.android_todo_list.db.TodoDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var db:TodoDatabase
    private lateinit var dao:TodoDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //編集画面に飛ばす
        findViewById<FloatingActionButton>(R.id.add_fab).setOnClickListener {
            val intent = Intent(this,EditActivity::class.java)
            startActivity(intent)
        }

        //===================================================================


        db = Room.databaseBuilder(
            this,
            TodoDatabase::class.java,
            "memo.db"
        ).build()

        dao = db.todoDao()

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

//        val list = mutableListOf(
//            ListModel(1,"title1","内容1"),
//            ListModel(1,"title2","内容2"),
//            ListModel(1,"title3","内容3"),
//            ListModel(1,"title4","内容4"),
//            ListModel(1,"title4","内容4"),
//            ListModel(1,"title4","内容4"),
//            ListModel(1,"title4","内容4"),
//            ListModel(1,"title4","内容4"),
//            ListModel(1,"title4","内容4"),
//            ListModel(1,"title4","内容4"),
//            ListModel(1,"title4","内容4"),
//        )



        //読み込む時は別のスレッドで読みこむ
        GlobalScope.launch{
            val list = dao.getAll()

            //反映させる時はUIスレッドに戻す
            this@MainActivity.runOnUiThread{
                adapter.setList(list)
            }

        }


    }
}