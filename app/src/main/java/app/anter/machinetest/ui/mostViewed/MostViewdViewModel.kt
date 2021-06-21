package app.anter.machinetest.ui.mostViewed

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.anter.machinetest.data.model.MostViewedResponse
import app.anter.machinetest.data.reposatory.RemoteReposatory
import app.anter.machinetest.utils.NetworkHelper
import app.anter.machinetest.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Mostafa Anter on 6/21/21.
 */
@HiltViewModel
class MostViewdViewModel @Inject constructor(
    private val remoteReposatory: RemoteReposatory,
    private val networkHelper: NetworkHelper
) : ViewModel() {


    private val _mostViewed_response =
        MutableStateFlow<Resource<MostViewedResponse>>(Resource.loading(null))
    val mostViewed_response: StateFlow<Resource<MostViewedResponse>>
        get() = _mostViewed_response

    fun getMostViewd(){
        viewModelScope.launch {
            _mostViewed_response.value = Resource.loading(null)
            if (networkHelper.isNetworkConnected()){
                remoteReposatory.getMostViewed().let {
                    if (it.isSuccessful){
                        _mostViewed_response.value = Resource.success(data = it.body())
                    }else{
                        _mostViewed_response.value = Resource.error(it.errorBody().toString(), null)
                    }
                }
            }else{
                Log.e("netWork error", "no network connection")
            }
        }
    }

}