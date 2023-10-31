package com.atilsamancioglu.annotationmastery.service

import com.atilsamancioglu.annotationmastery.util.AuthTokenNeeded
import retrofit2.http.GET

interface FantasticAPI {

    //https://raw.githubusercontent.com/atilsamancioglu/K21-JSONDataSet/master/crypto.json
    //https://raw.githubusercontent.com/atilsamancioglu/JokesAppJsonData/main/chuck.json

    @GET("K21-JSONDataSet/master/crypto.json")
    suspend fun getCryptos()

    @AuthTokenNeeded //we should attach a token to get this data
    @GET("JokesAppJsonData/main/chuck.json")
    suspend fun getJokes()
}