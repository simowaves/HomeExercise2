package at.fh.swengb.andreetto.homeexercise2

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import kotlinx.android.synthetic.main.activity_add_note.*


class AddNoteActivity : AppCompatActivity() {


    lateinit var db: NotesRoomDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        db = NotesRoomDatabase.getDatabase(this)

    }

    fun addNote(view: View) {
        val title = note_title.text.toString()
        val content = note_content.text.toString()

        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        val savedUser = sharedPreferences.getString("MY_USER_NAME", null)

        val note  = Note(title , content)


        db.noteDao.insert(note)

        finish()
        val intent = Intent(this, NoteListActivity::class.java)
        startActivity(intent)
    }
}
