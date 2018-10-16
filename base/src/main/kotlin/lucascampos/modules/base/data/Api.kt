package lucascampos.modules.base.data

import lucascampos.modules.base.data.model.RepositoryResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("search/repositories?q=language:Java&sort=stars&page=1")
    fun getRepositories(): Call<RepositoryResponse>

}