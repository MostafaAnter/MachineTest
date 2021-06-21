package app.anter.machinetest.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Result(
    @Json(name = "uri")
    var uri: String?="",
    @Json(name = "url")
    var url: String?="",
    @Json(name = "id")
    var id: Long?,
    @Json(name = "asset_id")
    var assetId: Long?,
    @Json(name = "source")
    var source: String?="",
    @Json(name = "published_date")
    var publishedDate: String?="",
    @Json(name = "updated")
    var updated: String?="",
    @Json(name = "section")
    var section: String?="",
    @Json(name = "subsection")
    var subsection: String?="",
    @Json(name = "nytdsection")
    var nytdsection: String?="",
    @Json(name = "adx_keywords")
    var adxKeywords: String?="",
    @Json(name = "column")
    var column: Any?,
    @Json(name = "byline")
    var byline: String?="",
    @Json(name = "type")
    var type: String?="",
    @Json(name = "title")
    var title: String?="",
    @Json(name = "abstract")
    var `abstract`: String?="",
    @Json(name = "des_facet")
    var desFacet: List<String>?,
    @Json(name = "org_facet")
    var orgFacet: List<String>?,
    @Json(name = "per_facet")
    var perFacet: List<String>?,
    @Json(name = "geo_facet")
    var geoFacet: List<String>?,
    @Json(name = "media")
    var media: List<Media>?,
    @Json(name = "eta_id")
    var etaId: Int?
)