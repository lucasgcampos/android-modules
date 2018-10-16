package lucascampos.modules.base.data.model

import com.google.gson.annotations.SerializedName

data class RepositoryResponse(
        @SerializedName("items") val items: List<Repository>
)

data class Repository(
        @SerializedName("id") val id: Long,
        @SerializedName("name") val name: String,
        @SerializedName("description") val description: String,
        @SerializedName("owner") val owner: Owner,
        @SerializedName("forks") val forks: Long,
        @SerializedName("stargazers_count") val stars: Long
)

data class Owner(
        @SerializedName("login") val login: String,
        @SerializedName("avatar_url") val avatar: String
)