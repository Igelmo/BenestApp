package com.example.benestapp.data

import com.example.benestapp.domain.RelaxingImagesRepository
import com.example.benestapp.domain.structure.DogImage
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RelaxingImagesDataRepository : RelaxingImagesRepository {
    override fun getDogImages(): List<DogImage> {
        val list = listOf<DogImage>()
        val retrofit = Retrofit.Builder().baseUrl("https://dog.ceo/api/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        return list
    }
}