package cl.bootcamp.integradorwallet.repository

import cl.bootcamp.integradorwallet.datasource.RestDataSource
import cl.bootcamp.integradorwallet.model.User
import cl.bootcamp.integradorwallet.model.UserDao
import cl.bootcamp.integradorwallet.model.UserWallet
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface WalletRepository {
    suspend fun getUserById(id: Int): UserWallet
    suspend fun getAllUserAPI(): ArrayList<UserWallet>
    fun getAllUserRoom(): Flow<List<User>>

}

class WalletRepositoryImp @Inject constructor(
    private val dataSource: RestDataSource,
    private val userDao: UserDao
): WalletRepository {
    override suspend fun getUserById(id: Int): UserWallet {
        val data = dataSource.getUserById(id).body()!!
        val user = UserWallet(
            id = data.id,
            nombre = data.nombre,
            pais = data.pais,
            imagenLink = data.imagenLink,
            cuenta = data.cuenta,
            saldo = data.saldo,
            depositos = data.depositos
        )
        return user
    }

    override suspend fun getAllUserAPI(): ArrayList<UserWallet> {
        val data = dataSource.getUsers()
        data.forEach {
            val user = User(
                id = it.id,
                nombre = it.nombre,
                pais = it.pais,
                imagenLink = it.imagenLink,
                cuenta = it.cuenta,
                saldo = it.saldo,
                depositos = it.depositos
            )
            userDao.insert(user)
        }
        return ArrayList(data)
    }

    override fun getAllUserRoom(): Flow<List<User>> = userDao.getAll()

}