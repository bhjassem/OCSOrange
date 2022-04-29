package benhamida.jassem.core.usecase

import benhamida.jassem.core.data.Program
import benhamida.jassem.core.repository.ProgramRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class SearchProgramTest {

    @MockK
    lateinit var programRepository: ProgramRepository

    @MockK
    lateinit var mockProgram: Program

    lateinit var searchProgramUseCase: SearchProgramUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        searchProgramUseCase = SearchProgramUseCase(programRepository)
    }


    @Test
    fun testSearchProgramUseCase() {
        var titleToSearch = "mock title"
        val programList = listOf(mockProgram, mockProgram)
        coEvery {programRepository.searchProgram(titleToSearch)} returns programList
        //
        val result = runBlocking {
            searchProgramUseCase.invoke(titleToSearch)
        }
        //
        coVerify {
            programRepository.searchProgram(titleToSearch)
        }
        Assert.assertEquals(
            result,
            programList
        )
    }
}