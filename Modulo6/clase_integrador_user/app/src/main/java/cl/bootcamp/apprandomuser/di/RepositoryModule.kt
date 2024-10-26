package cl.bootcamp.apprandomuser.di

import cl.bootcamp.apprandomuser.repository.UserRepository
import cl.bootcamp.apprandomuser.repository.UserRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun userRepository(repo: UserRepositoryImp): UserRepository

}