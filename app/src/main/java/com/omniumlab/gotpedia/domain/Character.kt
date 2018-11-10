package com.omniumlab.gotpedia.domain

data class Character(val name: String) {
    override fun toString(): String {
        return name
    }
}