package com.omniumlab.gotpedia.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View.GONE
import android.view.View.VISIBLE
import com.omniumlab.gotpedia.R
import com.omniumlab.gotpedia.domain.Book
import com.omniumlab.gotpedia.presenter.BookListPresenter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert

class BookListView : AppCompatActivity(), BookListPresenter.View {

    private lateinit var presenter: BookListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = LinearLayoutManager(this)
        presenter = BookListPresenter(this)
    }

    override fun showLoading() {
        progressBar.visibility = VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = GONE
    }

    override fun showBookList(books: List<Book>) {
        val adapter = BookListAdapter(books) {
            presenter.onBookClick(it.title)
        }
        recyclerView.adapter = adapter
    }

    override fun showPOVCharacters(bookTitle: String, characters: String) {
        alert(characters) {
            title = bookTitle
        }.show()
    }
}