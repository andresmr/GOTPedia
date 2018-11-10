package com.omniumlab.gotpedia.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.omniumlab.gotpedia.R
import com.omniumlab.gotpedia.domain.Book
import kotlinx.android.synthetic.main.item_book.view.*

class BookListAdapter(private val books: List<Book>, private val listener: (Book) -> Unit) :
    RecyclerView.Adapter<BookListAdapter.BookHolder>() {

    override fun getItemCount() = books.size

    override fun onBindViewHolder(holder: BookHolder, position: Int) {
        holder.bind(books[position], listener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BookHolder(inflatedView)
    }

    class BookHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(book: Book, listener: (Book) -> Unit) = with(itemView) {
            title.text = book.title
            isbn.text = book.isbn
            setOnClickListener { listener(book) }
        }
    }
}