package com.omniumlab.gotpedia.domain.entity

data class Character(val name: String) {
    override fun toString(): String {
        return name
    }
}