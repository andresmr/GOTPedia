package com.omniumlab.gotpedia.data.mapper

import com.omniumlab.gotpedia.data.dto.BookDTO
import com.omniumlab.gotpedia.domain.entity.Book

class BooksMapper {
    fun map(booksDTO: List<BookDTO>): List<Book> {
        val books = ArrayList<Book>()
        for (bookDTO in booksDTO) {
            books.add(Book(bookDTO.name, bookDTO.isbn, bookDTO.numberOfPages))
        }
        return books
    }
}