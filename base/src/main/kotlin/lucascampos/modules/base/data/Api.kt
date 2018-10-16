package lucascampos.modules.base.data

import lucascampos.modules.base.data.model.PullRequestResponse
import lucascampos.modules.base.data.model.RepositoryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("search/repositories?q=language:Java&sort=stars&page=1")
    fun getRepositories(): Call<RepositoryResponse>

    @GET("repos/{owner}/{repository}/pulls")
    fun getPullRequests(
            @Path ("owner") owner: String,
            @Path ("repository") repository: String
    ): Call<List<PullRequestResponse>>

}