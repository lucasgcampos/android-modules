package lucascampos.modules.base.data.model

import com.google.gson.annotations.SerializedName

class PullRequestResponse(
        @SerializedName("title") val title: String,
        @SerializedName("user") val owner: Owner,
        @SerializedName("body") val description: String
)