package cl.bootcamp.appfutbol.di

import cl.bootcamp.appfutbol.repository.FutbolRepository
import cl.bootcamp.appfutbol.repository.FutbolRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun futbolRepository(futbolRepositoryImp: FutbolRepositoryImp): FutbolRepository
}