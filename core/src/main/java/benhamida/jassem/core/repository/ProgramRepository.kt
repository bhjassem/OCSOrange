package benhamida.jassem.core.repository

class ProgramRepository(private val dataSource: ProgramDataSource) {

    suspend fun searchProgram(title: String) = dataSource.search(title)

    suspend fun getProgramDetails(detailLink: String) = dataSource.getDetails(detailLink)

}