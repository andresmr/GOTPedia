package com.omniumlab.gotpedia.data

import com.omniumlab.gotpedia.data.mapper.BooksMapper
import com.omniumlab.gotpedia.domain.entity.Book
import com.omniumlab.gotpedia.domain.entity.Character
import com.omniumlab.gotpedia.domain.repository.BooksRepository
import com.omniumlab.gotpedia.domain.repository.CharacterRepository

class RepositoryImpl : BooksRepository, CharacterRepository {

    private val service: IceAndFireService = IceAndFireService.Factory.makeRetrofitService()
    private val booksMapper = BooksMapper()

    override suspend fun obtain(): List<Book> {
        val request = service.listBooks()
        val response = request.execute()
        if (response.isSuccessful) {
            return booksMapper.map(response.body())
        }
        return emptyList()
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