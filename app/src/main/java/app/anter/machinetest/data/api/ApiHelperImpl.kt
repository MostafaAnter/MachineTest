package app.anter.machinetest.data.api

import app.anter.machinetest.data.model.MostViewedResponse
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Mostafa Anter on 6/21/21.
 */
class ApiHelperImpl @Inject constructor(val apiService: ApiService): ApiHelper {
    override suspend fun getMostViewed(): Response<MostViewedResponse> = apiService.getMostViewed()
}