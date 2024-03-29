package benhamida.jassem.ocsorange.framework.di

import android.content.Context
import benhamida.jassem.core.repository.ProgramRepository
import benhamida.jassem.core.usecase.GetProgramDetailsUseCase
import benhamida.jassem.core.usecase.SearchProgramUseCase
import benhamida.jassem.ocsorange.framework.ApiProgramDataSource
import benhamida.jassem.ocsorange.framework.UseCases
import benhamida.jassem.ocsorange.framework.api.ApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun provideProgramApi() = ApiClient.createApiService()

    @Provides
    @Singleton
    fun provideProgramDataSource(@ApplicationContext context: Context) = ApiProgramDataSource(provideProgramApi())

    @Provides
    @Singleton
    fun provideProgramRepository(@ApplicationContext context: Context) = ProgramRepository(provideProgramDataSource(context))

    @Provides
    @Singleton
    fun provideUseCases(@ApplicationContext context: Context) = UseCases(
        SearchProgramUseCase(provideProgramRepository(context)),
        GetProgramDetailsUseCase(provideProgramRepository(context))
    )
}