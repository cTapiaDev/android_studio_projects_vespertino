package cl.bootcamp.apprandomuser.repository

import cl.bootcamp.apprandomuser.datasource.RestDataSource
import cl.bootcamp.apprandomuser.model.User
import cl.bootcamp.apprandomuser.model.UserDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface UserRepository {
    suspend fun getNewUser(): User
    suspend fun deleteUser(toDelete: User)
    fun getAllUser(): Flow<List<User>>
}

class UserRepositoryImp @Inject constructor(
    private val dataSource: RestDataSource,
    private val userDao: UserDao
): UserRepository {

    override suspend fun getNewUser(): User {
        val name = dataSource.getUserName().results[0].name!!
        val location = dataSource.getUserLocation().results[0].location!!
        val picture = dataSource.getUserPicture().results[0].picture!!
        val user = User(
            name.first,
            name.last,
            location.city,
            location.state,
            location.country,
            picture.thumbnail
        )
        userDao.insert(user)
        return user
    }

    override suspend fun deleteUser(toDelete: User) = userDao.delete(toDelete)

    override fun getAllUser(): Flow<List<User>> = userDao.getAll()

}