package benhamida.jassem.ocsorange.framework.api

import benhamida.jassem.core.data.ProgramDetailsDTO
import benhamida.jassem.core.data.ProgramSearchDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProgramApi {

    @GET("apps/v2/contents?")
    suspend fun search(@Query("search") search: String): Response<ProgramSearchDTO?>

    @GET("/apps/v2/details/serie/{programId}")
    suspend fun getProgramDetails(@Path("programId") programId: String?): Response<ProgramDetailsDTO>
}