package benhamida.jassem.ocsorange.framework

import benhamida.jassem.core.data.Program
import benhamida.jassem.core.data.ProgramDetails
import benhamida.jassem.core.repository.ProgramDataSource
import benhamida.jassem.ocsorange.framework.api.ProgramApi
import javax.inject.Inject

class ApiProgramDataSource @Inject constructor(private val programApi: ProgramApi): ProgramDataSource {

    override suspend fun search(title: String): List<Program> {
        val response = programApi.search(title)
        var ret: List<Program> = ArrayList()
        if (response.isSuccessful && response.body() != null) {
            val content = response.body()!!
            content?.contents?.let {
                ret = it
            }
        }
        return ret
    }

    override suspend fun getDetails(id: String): ProgramDetails {
        val response = programApi.getProgramDetails(id)
        var ret = ProgramDetails()
        if (response.isSuccessful && response.body() != null) {
            val content = response.body()!!
            content?.contents?.let {
                ret = it
            }
        }
        return ret
    }
}