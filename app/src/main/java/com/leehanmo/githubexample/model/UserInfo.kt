package com.leehanmo.githubexample.model

import com.google.gson.annotations.SerializedName

data class UserInfo(
        @SerializedName("name") val name : String?,
        @SerializedName("avatar_url") val profileImg : String?,
        @SerializedName("blog") val blog : String?
        )