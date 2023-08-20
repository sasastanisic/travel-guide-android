package rs.ac.metropolitan.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import rs.ac.metropolitan.domain.model.Travel

@Database(
    entities = [Travel::class],
    version = 1
)

abstract class TravelDatabase : RoomDatabase() {
    abstract val travelDao: TravelDao

    companion object {
        const val DATABASE_NAME = "travel_db"
    }
}