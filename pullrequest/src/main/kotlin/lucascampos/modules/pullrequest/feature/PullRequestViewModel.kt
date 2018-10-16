package lucascampos.modules.pullrequest.feature

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import lucascampos.modules.base.BaseViewModel
import lucascampos.modules.base.data.Api
import lucascampos.modules.base.data.model.PullRequestResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PullRequestViewModel(private val api: Api) : BaseViewModel<List<PullRequestResponse>>() {

    fun getPullRequests(owner: String, name: String) {
        api.getPullRequests(owner, name).enqueue(object : Callback<List<PullRequestResponse>> {
            override fun onFailure(call: Call<List<PullRequestResponse>>, t: Throwable) {
                error.postValue(t)
            }

            override fun onResponse(call: Call<List<PullRequestResponse>>, response: Response<List<PullRequestResponse>>) {
                if (response.code() == 200 && response.body() != null)
                    results.postValue(response.body())
                else
                    error.postValue(Throwable())
            }
        })
    }

}

class PullRequestViewModelFactory(
        private val api: Api
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PullRequestViewModel(api) as T
    }

}