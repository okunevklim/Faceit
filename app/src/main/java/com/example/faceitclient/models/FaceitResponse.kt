package com.example.faceitclient.models
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class FaceitResponse(
    val issuer: String?,
    @SerializedName("token_endpoint")
    val tokenEndpoint: String?
) : Serializable
