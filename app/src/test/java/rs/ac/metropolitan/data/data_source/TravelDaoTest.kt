package rs.ac.metropolitan.data.data_source

import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
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
    fun shouldInsertTravel() = runTest {
        val travel = Travel(0, "", "", "", 0.0f, "")
        coEvery { travelDao.upsertTravel(travel) } just runs

        travelDao.upsertTravel(travel)

        coVerify { travelDao.upsertTravel(travel) }
    }

}