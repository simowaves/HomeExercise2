package at.fh.swengb.andreetto.homeexercise2

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun addUser(view: View) {

        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)

        // Storing Inputted UserData
        sharedPreferences.edit().putString("MY_USER_NAME", user_name.text.toString()).apply()
        sharedPreferences.edit().putInt("MY_USER_AGE", user_age.text.toString().toIntOrNull() ?: 42).apply()

        finish()
        val intent = Intent(this, NoteListActivity::class.java)
        startActivity(intent)
    }
}
