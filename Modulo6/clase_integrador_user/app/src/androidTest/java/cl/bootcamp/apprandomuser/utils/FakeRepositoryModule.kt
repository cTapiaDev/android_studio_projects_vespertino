package cl.bootcamp.apprandomuser.utils

import cl.bootcamp.apprandomuser.di.RepositoryModule
import cl.bootcamp.apprandomuser.model.User
import cl.bootcamp.apprandomuser.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [RepositoryModule::class]
)
class FakeRepositoryModule {

    @Provides
    @Singleton
    fun userRepository(): UserRepository = object : UserRepository {

        private val users = MutableStateFlow<List<User>>(emptyList())

        override suspend fun getNewUser(): User {
            val userList = users.value
            val newUser = User(
                "Name ${userList.size}",
                "LastName ${userList.size}",
                "City",
                "State",
                "Country",
                "Image"
            )
            users.value = users.value.toMutableList().apply { add(newUser) }
            return newUser
        }

        override suspend fun deleteUser(toDelete: User) {
            users.value = users.value.toMutableList().apply { remove(toDelete) }
        }

        override fun getAllUser(): Flow<List<User>> = users

    }

}