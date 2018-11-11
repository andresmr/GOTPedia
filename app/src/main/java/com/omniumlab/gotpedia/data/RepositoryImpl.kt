package com.omniumlab.gotpedia.data

import com.omniumlab.gotpedia.data.dto.BookDTO
import com.omniumlab.gotpedia.data.mapper.BooksMapper
import com.omniumlab.gotpedia.domain.entity.Character
import com.omniumlab.gotpedia.domain.repository.BooksRepository
import com.omniumlab.gotpedia.domain.repository.BooksRepositoryListener
import com.omniumlab.gotpedia.domain.repository.CharacterRepository

class RepositoryImpl : BooksRepository, CharacterRepository {

    private val booksMapper = BooksMapper()

    override fun obtain(listener: BooksRepositoryListener) {
        val booksDTO = listOf(
            BookDTO("Juego de Tronos", "123456A", 578),
            BookDTO("Choque de Reyes", "123456B", 498),
            BookDTO("Tormenta de espadas", "123456C", 700),
            BookDTO("Festín de cuervos", "123456D", 987),
            BookDTO("Baile con dragones", "123456E", 682)
        )
        listener.onComplete(booksMapper.map(booksDTO))
    }

    override fun retrieveCharactersByBookPOV(title: String): List<Character>? {
        return listOf(
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
    }
}