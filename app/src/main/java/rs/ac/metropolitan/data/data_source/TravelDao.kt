package rs.ac.metropolitan.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import rs.ac.metropolitan.domain.model.Travel

@Dao
interface TravelDao {

    @Upsert
    suspend fun upsertTravel(travel: Travel)

    @Query("SELECT * FROM Travel")
    fun getAllTravels(): Flow<List<Travel>>

    @Query("SELECT * FROM Travel WHERE id = :id")
    suspend fun getTravelById(id: Int): Travel?

    @Delete
    suspend fun deleteTravel(travel: Travel)

}