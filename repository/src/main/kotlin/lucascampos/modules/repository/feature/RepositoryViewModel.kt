package lucascampos.modules.repository.feature

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import lucascampos.modules.base.BaseViewModel
import lucascampos.modules.base.data.Api
import lucascampos.modules.base.data.model.Repository
import lucascampos.modules.base.data.model.RepositoryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryViewModel(private val api: Api) : BaseViewModel<List<Repository>>() {

    fun getRepositories() {
        api.getRepositories().enqueue(object : Callback<RepositoryResponse> {
            override fun onFailure(call: Call<RepositoryResponse>, t: Throwable) {
                error.postValue(t)
            }

            override fun onResponse(call: Call<RepositoryResponse>, response: Response<RepositoryResponse>) {
                results.postValue(response.body()?.items)
            }
        })
    }

}

class RepositoryViewModelFactory(
        private val api: Api
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RepositoryViewModel(api) as T
    }

}