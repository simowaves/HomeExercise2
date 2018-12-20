package at.fh.swengb.andreetto.homeexercise2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNoteActivity : AppCompatActivity() {


    private val notes = mutableListOf<Note>()

    private val noteAdapter = NotesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
    }

    fun addNote(view: View) {
        val title = note_title.text.toString()
        val content = note_content.text.toString()

        val note = Note(title, content)

        notes.add(note)

        Log.i("Notes","${note}")
        noteAdapter.updateList(notes)

        finish()
        val intent = Intent(this, NoteListActivity::class.java)
        startActivity(intent)
    }
}
