package cl.bootcamp.appheroes.di

import cl.bootcamp.appheroes.repository.HeroesRepository
import cl.bootcamp.appheroes.repository.HeroesRepositoryImp
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
    abstract fun heroesRepository(heroesRepositoryImp: HeroesRepositoryImp): HeroesRepository
}