package cl.bootcamp.appwishlist.repository

import cl.bootcamp.appwishlist.model.Wish
import cl.bootcamp.appwishlist.room.WishDao
import kotlinx.coroutines.flow.Flow

class WishRepository(private val wishDao: WishDao) {

    suspend fun addAWish(wish: Wish) = wishDao.addWish(wish)

    suspend fun updateAWish(wish: Wish) = wishDao.updateWish(wish)

    suspend fun deleteAWish(wish: Wish) = wishDao.deleteWish(wish)

    fun getWishes(): Flow<List<Wish>> = wishDao.getAllWishes()

    fun getAWishById(id: Long): Flow<Wish> { return wishDao.getAWishById(id) }

}