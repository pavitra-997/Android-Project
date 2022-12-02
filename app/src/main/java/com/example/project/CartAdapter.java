package com.example.project;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Console;
import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartHolder> {
    public ArrayList<MyData> myDataset;

    public CartAdapter(ArrayList<MyData> mDataset) {
        this.myDataset = mDataset;
        Log.i("info","Details page invoked");
    }

    @NonNull
    @Override
    public CartAdapter.CartHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new CartHolder(layoutInflater, parent).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.CartHolder holder, int position) {

         MyData MyData= myDataset.get(position);
        holder.name.setText(MyData.getName());
        holder.price.setText(MyData.getPrice());
        holder.image.setImageResource(MyData.getImage());
        Log.i("info","Details page invoked2");
   //     holder.description.setText(MyData.getDescription());
    }

    @Override
    public int getItemCount() {
        return myDataset.size();
    }

    public class CartHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView price;
        ImageView image;
        Button deleteButton;
        private CartAdapter adapter;
    //  TextView description;
        CartHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.cartview, parent,false));
            name = itemView.findViewById(R.id.name);
            price=itemView.findViewById(R.id.price);
            image=itemView.findViewById(R.id.image);
            itemView.findViewById(R.id.deleteButton).setOnClickListener(view->{

                adapter.myDataset.remove(getAdapterPosition());
                adapter.notifyItemRemoved(getAdapterPosition());
            });
         // description=itemView.findViewById(R.id.description);


        }
        public CartHolder linkAdapter(CartAdapter adapter){
            this.adapter=adapter;
            return this;
        }

    }

}
