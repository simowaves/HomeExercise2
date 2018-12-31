package at.fh.swengb.andreetto.homeexercise2

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface NoteDao {

    @Insert
    fun insert(note: Note)

    @Query ("SELECT * FROM Note")
    fun findAll():List<Note>

    @Query("DELETE FROM Note")
    fun deleteAllNotes()

    @Query("SELECT * FROM Note WHERE user = :user")
    fun findByUser(user: String):List<Note>
}