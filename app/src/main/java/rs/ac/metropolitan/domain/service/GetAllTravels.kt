package rs.ac.metropolitan.domain.service

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import rs.ac.metropolitan.domain.model.Travel
import rs.ac.metropolitan.domain.repository.TravelRepository
import javax.inject.Inject

class GetAllTravels @Inject constructor(
    private val travelRepository: TravelRepository
) {

    operator fun invoke(): Flow<List<Travel>> {
        return travelRepository.getAllTravels().map {
            it.reversed()
        }
    }
}