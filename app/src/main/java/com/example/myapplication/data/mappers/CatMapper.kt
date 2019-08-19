package com.example.myapplication.data.mappers

import com.example.myapplication.data.network.models.CatNw
import com.example.myapplication.domain.models.Cat

fun CatNw.toModel() = Cat(id = this.id, url = this.url)