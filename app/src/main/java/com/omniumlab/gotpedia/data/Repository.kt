package com.omniumlab.gotpedia.data

import com.omniumlab.gotpedia.domain.entity.Book
import com.omniumlab.gotpedia.domain.entity.Character

val books = listOf(
    Book("Juego de Tronos", "123456A", 578),
    Book("Choque de Reyes", "123456B", 498),
    Book("Tormenta de espadas", "123456C", 700),
    Book("Festín de cuervos", "123456D", 987),
    Book("Baile con dragones", "123456E", 682)
)

val charactersPOV = listOf(
    Character("Arya Stark"),
    Character("Brandon Stark"),
    Character("Catelyn Stark"),
    Character("Eddard Stark"),
    Character("Jon Snow"),
    Character("Sansa Stark"),
    Character("Tyrion Lannister"),
    Character("Will"),
    Character("Daenerys Targaryen")
)

val charactersByBook = mapOf(
    "Juego de Tronos" to charactersPOV,
    "Choque de Reyes" to charactersPOV,
    "Tormenta de espadas" to charactersPOV,
    "Festín de cuervos" to charactersPOV,
    "Baile con dragones" to charactersPOV
)