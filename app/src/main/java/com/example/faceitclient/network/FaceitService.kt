package com.example.faceitclient.network

import com.example.faceitclient.models.FaceitResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface FaceitService {
    @GET
    fun authUser(
        @Query("response_type") responseType: String,
        @Query("client_id") clientID: String,
        @Query("redirect_popup") isRedirecting: Boolean
    ): Single<FaceitResponse>
}