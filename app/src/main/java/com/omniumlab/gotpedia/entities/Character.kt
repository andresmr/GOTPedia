package com.omniumlab.gotpedia.entities

data class Character(val name: String) {
    override fun toString(): String {
        return name
    }
}