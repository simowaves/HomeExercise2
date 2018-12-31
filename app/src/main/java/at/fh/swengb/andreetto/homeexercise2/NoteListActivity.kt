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

    lateinit var db: NotesRoomDatabase

    private lateinit var savedUser:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)


        Log.i("MyActivity", "onCreate")
        recycler_view.adapter = notesAdapter
        recycler_view.layoutManager = LinearLayoutManager(this)

        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)

        savedUser = sharedPreferences.getString("MY_USER_NAME", null)
        val savedAge  = sharedPreferences.getInt("MY_USER_AGE", -1).toString()

        user_info.text = "Notes for ${savedUser}, ${savedAge}"
        Log.i("MyActivity", "onCreate User: ${savedUser}  Age: ${savedAge}")

        db = NotesRoomDatabase.getDatabase(this)
        notesAdapter.updateList(db.noteDao.findAll())
    }

    override fun onResume() {
        super.onResume()

        notesAdapter.updateList(db.noteDao.findAll())
        filter_user.text = "FILTER"
        recycler_view.adapter = notesAdapter
    }

    fun filterUser (view: View){
        if (filter_user.text == "FILTER") {
            notesAdapter.updateList(db.noteDao.findByUser(savedUser))
            filter_user.text = "ALL"
        } else {
            notesAdapter.updateList(db.noteDao.findAll())
            filter_user.text = "FILTER"
        }
    }

    fun addNote(view: View) {

        val intent = Intent(this, AddNoteActivity::class.java)
        startActivity(intent)

    }

    fun clearNotes(view: View){
        db.noteDao.deleteAllNotes()
        notesAdapter.updateList(db.noteDao.findAll())
    }
}
