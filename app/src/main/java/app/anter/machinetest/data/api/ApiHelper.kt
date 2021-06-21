package app.anter.machinetest.data.api

import app.anter.machinetest.data.model.MostViewedResponse
import retrofit2.Response


/**
 * Created by Mostafa Anter on 6/21/21.
 */
interface ApiHelper {
    suspend fun getMostViewed(): Response<MostViewedResponse>
}