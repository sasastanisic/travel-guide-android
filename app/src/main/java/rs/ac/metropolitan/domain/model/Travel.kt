package rs.ac.metropolitan.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Travel(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val country: String,
    val accommodation: String,
    val budget: Float,
    val notes: String

)