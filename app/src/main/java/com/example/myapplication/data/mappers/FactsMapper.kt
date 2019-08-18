package com.example.myapplication.data.mappers

import com.example.myapplication.data.network.models.CatNw
import com.example.myapplication.domain.models.Cat

//fun Cat.toDbModel() = FactDb(this.id, this.breeds, thi)

//fun FactDb.toModel() = Cat(this.id, this.text, this.type)

fun CatNw.toModel() = Cat(id = this.id, url = this.url)