package com.yabahddou.heterogenousrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yabahddou.heterogenousrecyclerview.model.Book;
import com.yabahddou.heterogenousrecyclerview.model.Cat;
import com.yabahddou.heterogenousrecyclerview.model.Room;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int TYPE_HEADER = 0;
    private final int TYPE_ROOMS = 1;
    private final int TYPE_BOOKS = 2;
    private final int TYPE_CATS = 3;

    private List<Room> rooms;
    private List<Book> books;
    private List<Cat> cats;

    public MainAdapter(List<Room> rooms, List<Book> books, List<Cat> cats) {
        this.rooms = rooms;
        this.books = books;
        this.cats = cats;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.section_header, parent, false);
            return new HeaderViewHolder(view);
        } else if (viewType == TYPE_ROOMS) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_room, parent, false);
            return new RoomsViewHolder(view);
        } else if (viewType == TYPE_BOOKS) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
            return new BooksViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cat, parent, false);
            return new CatsViewHolder(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 || (position == rooms.size() + 1) || (position == rooms.size() + books.size() + 2)) {
            return TYPE_HEADER;
        } else {
            if (position > 0 && position < rooms.size() + 1) {
                return TYPE_ROOMS;
            } else if (position > rooms.size() + 1 && position < rooms.size() + books.size() + 2) {
                return TYPE_BOOKS;
            } else {//(position > rooms.size() + books.size() + 2)
                return TYPE_CATS;
            }
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        int viewType = holder.getItemViewType();
        if (viewType == TYPE_HEADER) {
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
            if (position == 0) {
                headerViewHolder.sectionTitle.setText("This is rooms header");
            } else if (position == rooms.size() + 1) {
                headerViewHolder.sectionTitle.setText("This is books header");
            } else if (position == rooms.size() + books.size() + 2) {
                headerViewHolder.sectionTitle.setText("This is cats header");
            }
        } else if (viewType == TYPE_ROOMS) {
            RoomsViewHolder roomsViewHolder = (RoomsViewHolder) holder;
            final Room currentRoom = rooms.get(position - 1);
            roomsViewHolder.bookName.setText(currentRoom.getTitle());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        } else if (viewType == TYPE_BOOKS) {
            BooksViewHolder booksViewHolder = (BooksViewHolder) holder;
            int bookPosition = position - rooms.size() - 2;
            final Book currentBook = books.get(bookPosition);
            booksViewHolder.title.setText(currentBook.getName());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        } else if (viewType == TYPE_CATS) {
            CatsViewHolder catsViewHolder = (CatsViewHolder) holder;
            int catPosition = position - rooms.size() - books.size() - 3;

            final Cat currentCat = cats.get(catPosition);
            catsViewHolder.catName.setText(currentCat.getName());
            if (catPosition % 2 == 0) {
                catsViewHolder.catImage.setImageResource(R.drawable.cat_1);
            } else {
                catsViewHolder.catImage.setImageResource(R.drawable.cat_4);
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return rooms.size() + books.size() + cats.size() + 3;//3 headers
    }

    public class RoomsViewHolder extends RecyclerView.ViewHolder {
        public final TextView bookName;

        public RoomsViewHolder(View view) {
            super(view);
            bookName = (TextView) view.findViewById(R.id.title);
        }
    }

    public class BooksViewHolder extends RecyclerView.ViewHolder {
        public final TextView title;

        public BooksViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.book_name);
        }
    }

    public class CatsViewHolder extends RecyclerView.ViewHolder {
        public final TextView catName;
        public final ImageView catImage;

        public CatsViewHolder(View view) {
            super(view);
            catName = (TextView) view.findViewById(R.id.cat_name);
            catImage = (ImageView) view.findViewById(R.id.cat_image);
        }
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {
        public final TextView sectionTitle;

        public HeaderViewHolder(View view) {
            super(view);
            sectionTitle = (TextView) view.findViewById(R.id.section_title);
        }
    }
}
