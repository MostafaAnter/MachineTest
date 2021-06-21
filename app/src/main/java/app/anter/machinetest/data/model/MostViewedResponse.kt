package app.anter.machinetest.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class MostViewedResponse(
    @Json(name = "status")
    var status: String?= "",
    @Json(name = "copyright")
    var copyright: String?= "",
    @Json(name = "num_results")
    var numResults: Int?= 0,
    @Json(name = "results")
    var results: List<Result>? = arrayListOf()
)