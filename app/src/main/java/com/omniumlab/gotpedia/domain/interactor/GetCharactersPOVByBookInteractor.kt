package com.omniumlab.gotpedia.domain.interactor

import com.omniumlab.gotpedia.data.RepositoryImpl
import com.omniumlab.gotpedia.domain.repository.CharacterRepository
import com.omniumlab.gotpedia.domain.entity.Character

class GetCharactersPOVByBookInteractor {

    private val characterRepository: CharacterRepository = RepositoryImpl()

    fun execute(title: String): List<Character>? {
        return characterRepository.retrieveCharactersByBookPOV(title)
    }
}