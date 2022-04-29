package benhamida.jassem.core.usecase

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

class GetProgramDetailsTest {

    @MockK
    lateinit var programRepository: ProgramRepository

    @MockK
    lateinit var mockProgramDetails: ProgramDetails

    lateinit var getProgramDetailsUseCase: GetProgramDetailsUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        getProgramDetailsUseCase = GetProgramDetailsUseCase(programRepository)
    }


    @Test
    fun testGetProgramDetailsUseCase() {
        var mockDetailsLink = "mock detailLink"
        coEvery {programRepository.getProgramDetails(mockDetailsLink)} returns mockProgramDetails
        //
        val result = runBlocking {
            getProgramDetailsUseCase.invoke(mockDetailsLink)
        }
        //
        coVerify {
            programRepository.getProgramDetails(mockDetailsLink)
        }
        Assert.assertEquals(
            result,
            mockProgramDetails
        )
    }
}