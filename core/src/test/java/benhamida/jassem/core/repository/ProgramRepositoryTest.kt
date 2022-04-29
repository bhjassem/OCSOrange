package benhamida.jassem.core.repository

import benhamida.jassem.core.data.Program
import benhamida.jassem.core.data.ProgramDetails
import benhamida.jassem.core.repository.ProgramRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ProgramRepositoryTest {

    @MockK
    lateinit var dataSource: ProgramDataSource

    @MockK
    lateinit var mockProgramDetails: ProgramDetails

    @MockK
    lateinit var mockProgram: Program

    lateinit var programRepository: ProgramRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        programRepository = ProgramRepository(dataSource)
    }


    @Test
    fun testSearchProgram() {
        //GIVEN
        var mockProgramTitle = "mock title"
        var programList = listOf(mockProgram, mockProgram, mockProgram)
        coEvery {dataSource.search(mockProgramTitle)} returns programList

        //WHEN
        val result = runBlocking {
            programRepository.searchProgram(mockProgramTitle)
        }

        coVerify {
            dataSource.search(mockProgramTitle)
        }

        //THEN
        Assert.assertEquals(
            result,
            programList
        )
    }


    @Test
    fun testGetProgramDetails() {
        //GIVEN
        var mockDetailsLink = "mock detailLink"
        coEvery {dataSource.getDetails(mockDetailsLink)} returns mockProgramDetails

        //WHEN
        val result = runBlocking {
            programRepository.getProgramDetails(mockDetailsLink)
        }

        coVerify {
            dataSource.getDetails(mockDetailsLink)
        }

        //THEN
        Assert.assertEquals(
            result,
            mockProgramDetails
        )
    }
}