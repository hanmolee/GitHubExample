package com.leehanmo.githubexample.model

import com.google.gson.annotations.SerializedName

data class Repo(
        @SerializedName("name") val name : String?,
        @SerializedName("stargazers_count") val star : Int?,
        @SerializedName("description") val description : String?
)