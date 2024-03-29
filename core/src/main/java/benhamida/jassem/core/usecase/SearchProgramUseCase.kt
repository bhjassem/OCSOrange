package benhamida.jassem.core.usecase

import benhamida.jassem.core.repository.ProgramRepository

class SearchProgramUseCase(private val programRepository: ProgramRepository) {
    suspend operator fun invoke(title: String) = programRepository.searchProgram(title)
}