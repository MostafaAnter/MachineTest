package app.anter.machinetest.data.api

import app.anter.machinetest.data.model.MostViewedResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

/**
 * Created by Mostafa Anter on 6/21/21.
 */
interface ApiService {
    @GET("/svc/mostpopular/v2/mostviewed/all-sections/7.json?api-key=kjWL3IMsOTCUgfZWnsq9HJix6bGqMjGS")
    suspend fun getMostViewed(
        @Header("App-ID") appID: String = "c5555ca5-304f-4f7a-918f-bc6963b55c5e",
        @Header("Content-Type") contentType: String = "application/json",
        @Header("Lang") langauge: String = "en",
        @Header("DeviceType") deviceType: String = "Android"
    ): Response<MostViewedResponse>
}