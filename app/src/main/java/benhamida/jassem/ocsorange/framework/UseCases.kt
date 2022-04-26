package benhamida.jassem.ocsorange.framework

import benhamida.jassem.core.usecase.GetProgramDetails
import benhamida.jassem.core.usecase.SearchProgram

data class UseCases(
    val searchProgram: SearchProgram,
    val getProgramDetails: GetProgramDetails
)
