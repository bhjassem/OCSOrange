package benhamida.jassem.core.repository

import benhamida.jassem.core.data.Program
import benhamida.jassem.core.data.ProgramDetails

interface ProgramDataSource {
    suspend fun search(title: String): List<Program>
    suspend fun getDetails(detailLink: String): ProgramDetails
}