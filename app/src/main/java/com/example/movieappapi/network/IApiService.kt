package com.example.movieappapi.network

import com.example.movieappapi.model.Movie
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface IApiService {
    @GET("movielist.json")
    suspend fun getMovies() : List<Movie>


    companion object {
        var apiService: IApiService? = null
        fun getInstance() : IApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl("https://howtodoandroid.com/apis/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(IApiService::class.java)
            }
            return apiService!!
        }
    }
}