package com.omniumlab.gotpedia.domain.interactor

import com.omniumlab.gotpedia.data.charactersByBook
import com.omniumlab.gotpedia.domain.entity.Character

class GetCharactersPOVByBookInteractor {
    fun execute(title: String): List<Character>? {
        return charactersByBook[title]
    }
}