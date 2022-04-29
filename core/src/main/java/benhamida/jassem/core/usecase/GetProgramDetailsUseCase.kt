package benhamida.jassem.core.usecase

import benhamida.jassem.core.repository.ProgramRepository

class GetProgramDetailsUseCase(private val programRepository: ProgramRepository) {
    suspend operator fun invoke(detailLink: String) = programRepository.getProgramDetails(detailLink)
}