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

    private List<Object> objectList;

    public MainAdapter(List<Object> object) {
        this.objectList = object;
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

        if(objectList.get(position) instanceof Room){
            return TYPE_ROOMS;
        } else if (objectList.get(position) instanceof Book){
            return TYPE_BOOKS;
        } else if (objectList.get(position) instanceof Cat){
            return TYPE_CATS;
        }

        return -1;


    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        int viewType = holder.getItemViewType();

        if (viewType == TYPE_ROOMS) {
            RoomsViewHolder roomsViewHolder = (RoomsViewHolder) holder;
            Room currentRoom = (Room) objectList.get(position);
            roomsViewHolder.bookName.setText(currentRoom.getTitle());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        } else if (viewType == TYPE_BOOKS) {
            BooksViewHolder booksViewHolder = (BooksViewHolder) holder;
            Book currentBook = (Book) objectList.get(position);
            booksViewHolder.title.setText(currentBook.getName());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        } else if (viewType == TYPE_CATS) {
            CatsViewHolder catsViewHolder = (CatsViewHolder) holder;

            final Cat currentCat = (Cat) objectList.get(position);
            catsViewHolder.catName.setText(currentCat.getName());
            if (position % 2 == 0) {
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
        return this.objectList.size();// + 3;//3 headers
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
