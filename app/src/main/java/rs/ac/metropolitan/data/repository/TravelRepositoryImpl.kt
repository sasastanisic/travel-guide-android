package rs.ac.metropolitan.data.repository

import kotlinx.coroutines.flow.Flow
import rs.ac.metropolitan.data.data_source.TravelDao
import rs.ac.metropolitan.domain.model.Travel
import rs.ac.metropolitan.domain.repository.TravelRepository

class TravelRepositoryImpl(
    private val travelDao: TravelDao
) : TravelRepository {

    override suspend fun upsertTravel(travel: Travel) {
        travelDao.upsertTravel(travel)
    }

    override fun getAllTravels(): Flow<List<Travel>> {
        return travelDao.getAllTravels()
    }

    override suspend fun getTravelById(id: Int): Travel? {
        return travelDao.getTravelById(id)
    }

    override suspend fun deleteTravel(travel: Travel) {
        travelDao.deleteTravel(travel)
    }

}