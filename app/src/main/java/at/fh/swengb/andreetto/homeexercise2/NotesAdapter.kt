package at.fh.swengb.andreetto.homeexercise2

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.noteitem.view.*

class NotesAdapter(): RecyclerView.Adapter<NotesViewHolder>() {

    var notesList = listOf<Note>()

    fun updateList(newList: List<Note>) {
        notesList = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): NotesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val noteItemView = inflater.inflate(R.layout.noteitem, parent, false)
        return NotesViewHolder(noteItemView)
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    override fun onBindViewHolder(viewHolder: NotesViewHolder, position: Int) {
        val note = notesList[position]
        viewHolder.bindItem(note) // Unresolved reference, i.e. the function bindItem does not exist. Why?
    }
}

class NotesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bindItem(note: Note) {
        itemView.item_title.text = note.noteTitle
        itemView.item_title.text = note.noteContent
    }
}