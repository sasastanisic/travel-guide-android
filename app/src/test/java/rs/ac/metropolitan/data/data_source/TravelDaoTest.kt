package rs.ac.metropolitan.data.data_source

import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import rs.ac.metropolitan.domain.model.Travel

@ExperimentalCoroutinesApi
class TravelDaoTest {

    private val travelDao = mockk<TravelDao>()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
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
        coEvery { travelDao.upsertTravel(travel) } just runs

        travelDao.upsertTravel(travel)
        coVerify { travelDao.upsertTravel(travel) }
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
        every { travelDao.getAllTravels() } returns flowOf(travels)

        val result = travelDao.getAllTravels().first()
        assert(result == travels)
    }

    @Test
    fun testGetTravelById() = runTest {
        val travel = Travel(
            1, "Venice", "Italy", "Hotel Blue", 1000.0f,
            "One of the most beautiful cities in the entire world"
        )
        coEvery { travelDao.getTravelById(1) } returns travel

        val result = travelDao.getTravelById(1)
        assert(result == travel)
    }

    @Test
    fun testDeleteTravel() = runTest {
        val travel = Travel(
            1, "Venice", "Italy", "Hotel Blue", 1000.0f,
            "One of the most beautiful cities in the entire world"
        )
        coEvery { travelDao.deleteTravel(travel) } just runs

        travelDao.deleteTravel(travel)
        coVerify { travelDao.deleteTravel(travel) }
    }

}