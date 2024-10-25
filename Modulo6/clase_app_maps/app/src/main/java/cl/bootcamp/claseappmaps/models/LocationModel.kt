package cl.bootcamp.claseappmaps.models

import com.google.android.gms.maps.model.LatLng

data class LocationModel(
    val name: String,
    val coordinates: LatLng
)
