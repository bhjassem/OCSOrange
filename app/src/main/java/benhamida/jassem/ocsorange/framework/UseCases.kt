package benhamida.jassem.ocsorange.framework

import benhamida.jassem.core.usecase.GetProgramDetailsUseCase
import benhamida.jassem.core.usecase.SearchProgramUseCase

data class UseCases(
    val searchProgramUseCase: SearchProgramUseCase,
    val getProgramDetailsUseCase: GetProgramDetailsUseCase
)
