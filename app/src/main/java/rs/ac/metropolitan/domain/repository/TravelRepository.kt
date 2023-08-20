package rs.ac.metropolitan.domain.repository

import kotlinx.coroutines.flow.Flow
import rs.ac.metropolitan.domain.model.Travel

interface TravelRepository {

    suspend fun upsertTravel(travel: Travel)

    fun getAllTravels(): Flow<List<Travel>>

    suspend fun getTravelById(id: Int): Travel?

    suspend fun deleteTravel(travel: Travel)

}