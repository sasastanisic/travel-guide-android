package rs.ac.metropolitan.domain.service

import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import rs.ac.metropolitan.domain.model.Travel
import rs.ac.metropolitan.domain.repository.TravelRepository

@ExperimentalCoroutinesApi
class TravelServiceTest {

    private val travelRepository = mockk<TravelRepository>()
    private lateinit var upsertTravel: UpsertTravel
    private lateinit var getAllTravels: GetAllTravels
    private lateinit var getTravel: GetTravel
    private lateinit var deleteTravel: DeleteTravel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        upsertTravel = UpsertTravel(travelRepository)
        getAllTravels = GetAllTravels(travelRepository)
        getTravel = GetTravel(travelRepository)
        deleteTravel = DeleteTravel(travelRepository)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    @Test
    fun testUpsertTravel() = runTest {
        val travel = Travel(
            1, "Venice", "Italy", "Hotel Blue", 1000.0f,
            "One of the most beautiful cities in the entire world"
        )
        coEvery { travelRepository.upsertTravel(travel) } just runs

        upsertTravel.invoke(travel)
        coVerify { travelRepository.upsertTravel(travel) }
    }

    @Test
    fun testGetAllTravels() = runTest {
        val travels = listOf(
            Travel(
                1, "Venice", "Italy", "Hotel Blue", 1000.0f,
                "One of the most beautiful cities in the entire world"
            ),
            Travel(
                2, "Los Angeles", "USA", "Hollywood Apartment", 3500.0f,
                "City of angels"
            )
        )
        every { travelRepository.getAllTravels() } returns flowOf(travels)

        val result = getAllTravels.invoke().first()
        assert(result == travels.reversed())
    }

    @Test
    fun testGetTravelById() = runTest {
        val travel = Travel(
            1, "Venice", "Italy", "Hotel Blue", 1000.0f,
            "One of the most beautiful cities in the entire world"
        )
        coEvery { travelRepository.getTravelById(1) } returns travel

        val result = getTravel.invoke(1)
        assert(result == travel)
    }

    @Test
    fun testDeleteTravel() = runTest {
        val travel = Travel(
            1, "Venice", "Italy", "Hotel Blue", 1000.0f,
            "One of the most beautiful cities in the entire world"
        )
        coEvery { travelRepository.deleteTravel(travel) } just runs

        deleteTravel.invoke(travel)
        coVerify { travelRepository.deleteTravel(travel) }
    }

}