package app.anter.machinetest.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Media(
    @Json(name = "type")
    var type: String?="",
    @Json(name = "subtype")
    var subtype: String?="",
    @Json(name = "caption")
    var caption: String?="",
    @Json(name = "copyright")
    var copyright: String?="",
    @Json(name = "approved_for_syndication")
    var approvedForSyndication: Int?= 0 ,
    @Json(name = "media-metadata")
    var mediaMetadata: List<MediaMetadata>? = arrayListOf()
)