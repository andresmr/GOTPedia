package com.omniumlab.gotpedia.data.mapper

import com.omniumlab.gotpedia.data.dto.BookDTO
import com.omniumlab.gotpedia.domain.entity.Book

class BooksMapper {
    fun map(booksDTO: List<BookDTO>?): List<Book> {
        val books = ArrayList<Book>()
        booksDTO?.forEach {
            books.add(Book(it.name, it.isbn, it.numberOfPages))
        }
        return books
    }
}