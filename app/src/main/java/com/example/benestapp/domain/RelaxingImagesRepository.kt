package com.example.benestapp.domain

import com.example.benestapp.domain.structure.DogImage

interface RelaxingImagesRepository {
    fun getDogImages(): List<DogImage>
}