package com.example.myapplication.data.database.mappers

import com.example.myapplication.data.database.models.FactDb
import com.example.myapplication.data.network.models.FactNw
import com.example.myapplication.domain.Fact

fun Fact.toDbModel() = FactDb(this.id, this.text, this.type)

fun FactDb.toModel() = Fact(this.id, this.text, this.type)

fun FactNw.toModel() = Fact(this.id, this.text, this.type)