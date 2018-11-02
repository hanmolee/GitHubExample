package com.leehanmo.githubexample.model

import com.google.gson.annotations.SerializedName

data class Repo(
        val name : String?,
        val stargazers_count : Int?,
        val description : String?
)