package at.fh.swengb.andreetto.homeexercise2


import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity
class Note (@PrimaryKey val noteTitle: String, val noteContent: String, val user:String) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Note

        if (noteTitle != other.noteTitle) return false
        if (noteContent != other.noteContent) return false

        return true
    }

    override fun hashCode(): Int {
        var result = noteTitle.hashCode()
        result = 31 * result + noteContent.hashCode()
        return result
    }
}

