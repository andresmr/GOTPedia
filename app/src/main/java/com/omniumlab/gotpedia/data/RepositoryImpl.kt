package com.omniumlab.gotpedia.data

import com.omniumlab.gotpedia.data.mapper.BooksMapper
import com.omniumlab.gotpedia.domain.entity.Character
import com.omniumlab.gotpedia.domain.repository.BooksRepository
import com.omniumlab.gotpedia.domain.repository.BooksRepositoryListener
import com.omniumlab.gotpedia.domain.repository.CharacterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RepositoryImpl : BooksRepository, CharacterRepository {

    private val service: IceAndFireService = IceAndFireService.Factory.makeRetrofitService()
    private val booksMapper = BooksMapper()

    override fun obtain(listener: BooksRepositoryListener) {

        GlobalScope.launch(Dispatchers.Main) {
            val request = service.listBooks()
            val response = request.await()
            if (response.isSuccessful) {
                response.body()?.let { listener.onComplete(booksMapper.map(it)) }
            } else {
                listener.onError()
            }
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