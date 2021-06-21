package app.anter.machinetest.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class MediaMetadata(
    @Json(name = "url")
    var url: String? = "",
    @Json(name = "format")
    var format: String? = "",
    @Json(name = "height")
    var height: Int? = 0,
    @Json(name = "width")
    var width: Int? = 0
)