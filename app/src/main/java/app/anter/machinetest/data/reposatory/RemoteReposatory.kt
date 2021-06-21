package app.anter.machinetest.data.reposatory

import app.anter.machinetest.data.api.ApiHelper
import app.anter.machinetest.data.model.MostViewedResponse
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Mostafa Anter on 6/21/21.
 */
class RemoteReposatory @Inject constructor(private val apiHelper: ApiHelper) {
    suspend fun getMostViewed(): Response<MostViewedResponse> = apiHelper.getMostViewed()
}