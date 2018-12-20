package at.fh.swengb.andreetto.homeexercise2

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_note_list.*

class NoteListActivity : AppCompatActivity() {

    private val notes = mutableListOf<Note>()

    private val notesAdapter = NotesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)


        Log.i("MyActivity", "onCreate")
        recycler_view.adapter = notesAdapter
        recycler_view.layoutManager = LinearLayoutManager(this)

        val sharedPreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE)

        val savedUser = sharedPreferences.getString("MY_USER_NAME", null)
        val savedAge = sharedPreferences.getInt("MY_USER_AGE", -1).toString()

        user_info.text = "${savedUser} - ${savedAge}"
    }

    override fun onStart() {
        super.onStart()
        notesAdapter.updateList(notes)
        recycler_view.adapter = notesAdapter
    }

    fun addNote(view: View) {

        finish()
        val intent = Intent(this, AddNoteActivity::class.java)
        startActivity(intent)

    }
}
