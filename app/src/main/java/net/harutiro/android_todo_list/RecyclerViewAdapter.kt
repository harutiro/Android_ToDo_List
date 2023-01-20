package net.harutiro.android_todo_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    //リサイクラービューに表示するリストを宣言する
    val items = mutableListOf<ListModel>()

    //データをcourseDateと結びつける
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val itemTitleTextView = view.findViewById<TextView>(R.id.item_title_text_view)
        val itemContentTextView = view.findViewById<TextView>(R.id.item_content_text_view)
    }

    //はめ込むものを指定
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    //itemsのposition番目の要素をviewに表示するコード
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = items[position]
        viewHolder.itemTitleTextView.text = item.title
        viewHolder.itemContentTextView.text = item.content
    }
    //リストの要素数を返すメソッド
    override fun getItemCount() = items.size

    fun setList(list: List<ListModel>){
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

}