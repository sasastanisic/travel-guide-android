package rs.ac.metropolitan.domain.service

import rs.ac.metropolitan.domain.model.Travel
import rs.ac.metropolitan.domain.repository.TravelRepository
import javax.inject.Inject

class GetTravel @Inject constructor(
    private val travelRepository: TravelRepository
) {

    suspend operator fun invoke(id: Int): Travel? {
        return travelRepository.getTravelById(id)
    }
}