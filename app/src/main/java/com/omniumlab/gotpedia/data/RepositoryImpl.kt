package com.omniumlab.gotpedia.data

import com.omniumlab.gotpedia.data.mapper.BooksMapper
import com.omniumlab.gotpedia.domain.entity.Character
import com.omniumlab.gotpedia.domain.entity.Result
import com.omniumlab.gotpedia.domain.entity.convertToHttpError
import com.omniumlab.gotpedia.domain.repository.BooksRepository
import com.omniumlab.gotpedia.domain.repository.CharacterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RepositoryImpl : BooksRepository, CharacterRepository {

    private val service: IceAndFireService = IceAndFireService.Factory.makeRetrofitService()
    private val booksMapper = BooksMapper()

    override suspend fun obtain() =
        withContext(Dispatchers.IO) {
            val request = service.listBooks()
            val response = request.execute()
            if (response.isSuccessful) {
                Result.Success(booksMapper.map(response.body()))
            } else {
                Result.Error(response.code().convertToHttpError())
            }
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