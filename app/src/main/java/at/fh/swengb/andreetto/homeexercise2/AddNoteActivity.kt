package at.fh.swengb.andreetto.homeexercise2

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_note.*


class AddNoteActivity : AppCompatActivity() {


    lateinit var db: NotesRoomDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        db = NotesRoomDatabase.getDatabase(applicationContext)

    }

    fun addNote(view: View) {
        val title = note_title.text.toString()
        if (title == "") {
            Toast.makeText(applicationContext,"Please add a title",Toast.LENGTH_SHORT).show()
        }
        else {

            val content = note_content.text.toString()

            val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
            val savedUser = sharedPreferences.getString("MY_USER_NAME", null)

            val note = Note(title, content, savedUser)


            db.noteDao.insert(note)

            finish()
        }
    }
}
