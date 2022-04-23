package benhamida.jassem.core.usecase

import benhamida.jassem.core.repository.ProgramRepository

class GetProgramDetails(private val programRepository: ProgramRepository) {
    suspend operator fun invoke(id: String) = programRepository.getProgramDetails(id)
}