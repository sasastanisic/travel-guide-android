package rs.ac.metropolitan.domain.service

import rs.ac.metropolitan.domain.model.Travel
import rs.ac.metropolitan.domain.repository.TravelRepository
import javax.inject.Inject

class DeleteTravel @Inject constructor(
    private val travelRepository: TravelRepository
) {

    suspend operator fun invoke(travel: Travel) {
        travelRepository.deleteTravel(travel)
    }
}