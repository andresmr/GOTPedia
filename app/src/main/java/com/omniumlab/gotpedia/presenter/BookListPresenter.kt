package com.omniumlab.gotpedia.presenter

import com.omniumlab.gotpedia.data.books
import com.omniumlab.gotpedia.data.charactersByBook
import com.omniumlab.gotpedia.domain.Book

class BookListPresenter(private val view: View) {

    init {
        view.showLoading()
        view.showBookList(books)
        view.hideLoading()
    }

    fun onBookClick(bookTitle: String) {
        view.showPOVCharacters(bookTitle, charactersByBook[bookTitle].toString())
    }

    interface View {
        fun showLoading()
        fun hideLoading()
        fun showBookList(books: List<Book>)
        fun showPOVCharacters(bookTitle: String, characters: String)
    }
}