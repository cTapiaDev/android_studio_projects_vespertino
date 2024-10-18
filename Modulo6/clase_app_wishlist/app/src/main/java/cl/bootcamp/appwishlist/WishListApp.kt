package cl.bootcamp.appwishlist

import android.app.Application
import cl.bootcamp.appwishlist.room.Graph

class WishListApp : Application(){
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}