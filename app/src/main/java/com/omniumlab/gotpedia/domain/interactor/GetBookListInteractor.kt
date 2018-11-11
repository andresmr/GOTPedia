package com.omniumlab.gotpedia.domain.interactor

import com.omniumlab.gotpedia.data.books
import com.omniumlab.gotpedia.domain.entity.Book

class GetBookListInteractor {
    fun execute(): List<Book> {
        return books
    }

}