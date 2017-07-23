package com.example.hau.myapplication;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hau on 7/18/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.Item> {
    ArrayList<String> items;

    Context context;
    public Adapter(Context context, ArrayList<String> items)//Constructor
    {
        this.context = context;
        this.items = items;
    }

    @Override
    public Item onCreateViewHolder(ViewGroup parent, int viewType) //
    {
        LayoutInflater inflater=LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.items_row,parent,false);
        Item item = new Item(row);
        return item;
    }

    @Override
    public void onBindViewHolder(Item holder, int position) {
        Log.i("Test", "Inserted " + items.get(position));
        holder.textView.setText(items.get(position));

    }

    @Override
    public int getItemCount() {

        return items.size();
    }

    public class Item extends RecyclerView.ViewHolder{
        TextView textView;
        public Item(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.items);
        }


    }
}
