package net.harutiro.android_todo_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.room.Room
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.harutiro.android_todo_list.db.TodoDao
import net.harutiro.android_todo_list.db.TodoDatabase

class EditActivity : AppCompatActivity() {

    private lateinit var db:TodoDatabase
    private lateinit var dao: TodoDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        db = Room.databaseBuilder(
            this,
            TodoDatabase::class.java,
            "memo.db"
        ).build()

        dao = db.todoDao()

        findViewById<Button>(R.id.edit_save_button).setOnClickListener {
            val title = findViewById<EditText>(R.id.edit_title_edit_text).text.toString()
            val content = findViewById<EditText>(R.id.edit_content_edit_text).text.toString()

            GlobalScope.launch{
                dao.insertAll(ListModel( uid=0 ,title = title , content = content))
            }

            Snackbar.make(findViewById(android.R.id.content),"保存しました", Snackbar.LENGTH_SHORT).show()
        }
    }
}