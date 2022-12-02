package com.example.project;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements Filterable {

   MyData[] mDataset;
    MyData[] mDataset2;
    //ArrayList<MyData>mDataset2=new ArrayList<>();
   private ItemClickListener mItemListener;

    MyAdapter(MyData[] myDataset, ItemClickListener itemClickListener) {
        mDataset = myDataset;
        mDataset2=myDataset;

        mItemListener=itemClickListener;
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter= new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            ArrayList<MyData>listData=  new ArrayList<>(Arrays.asList(mDataset2));
            ArrayList<MyData>filteredList=  new ArrayList<>();

            if(charSequence.toString().isEmpty()){
                filteredList.addAll(listData);
            }
            else{
                for(MyData data:mDataset2){
                    if(data.getName().toLowerCase().contains(charSequence.toString().toLowerCase())){
                        filteredList.add(data);
                    }
                }

            }

            FilterResults filterResults=new FilterResults();
            filterResults.values=filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

             mDataset = null;
//            ArrayList<MyData> dataArrayList= (ArrayList<MyData>) Arrays.asList(mDataset);
//            dataArrayList.clear();
           // dataArrayList.addAll((Collection<? extends MyData>) filterResults.values);
            mDataset=(MyData[]) (filterResults.values);
            notifyDataSetChanged();
        }
    };

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView price;
       // TextView description;
        ImageView image;

        MyViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.listactivity, parent,false));
            name = itemView.findViewById(R.id.name);
            price=itemView.findViewById(R.id.price);
           // description=itemView.findViewById(R.id.description);
            image=itemView.findViewById(R.id.image);
        }
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new MyViewHolder(layoutInflater, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        final MyData MyData= mDataset[position];
        holder.name.setText(mDataset[position].getName());
        holder.price.setText(mDataset[position].getPrice());
     //   holder.description.setText(mDataset[position].getDescription());
        holder.image.setImageResource(mDataset[position].getImage());
        holder.itemView.setOnClickListener(view -> { mItemListener.onItemClick(mDataset[position]);
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    public interface ItemClickListener{
        void onItemClick(MyData data);
    }


}
