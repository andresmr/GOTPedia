package com.omniumlab.gotpedia.domain.repository

import com.omniumlab.gotpedia.domain.entity.Character

interface CharacterRepository {
    fun retrieveCharactersByBookPOV(title: String): List<Character>?
}