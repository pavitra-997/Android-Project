package com.example.project;


import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    MyData[] datalist= new MyData[]{
            new MyData("Millenia bangle","185.00 $","Pretty little diamond stones are designed together to create this beautiful sparkling bangle.",R.drawable.bangles_1),
            new MyData("Essential Round Necklace","$5666.00","This pendant is inspired by the concept of birthstones, precious stones that correspond to different birth months.",R.drawable.pendent_5),
            new MyData("Circular Silhouette Necklace","$5600.00","You’ll love this gorgeously chic floral-themed necklace from our latest gold necklace collection.",R.drawable.pendent_7),
            new MyData("Heart Silhouette Necklace","$900.00","Chic & classy diamond pendants from the latest jewellery collection.",R.drawable.pendent_8),
            new MyData("Round-Embellished Band","$881.00","Diamonds can be affordable & attractive. Check out this beautiful diamond ring.",R.drawable.ring_1),
            new MyData("Eternal Ellipse Band","$3915.00","Watch your girl go “wow” as she opens her special wedding gift. This gorgeous diamond ring, studded with sparkling, pure diamonds.",R.drawable.ring_2),
            new MyData("Half Tapering Band","$1362.00","Simple yet classy, that’s what makes this diamond ring special.",R.drawable.ring_4),
            new MyData("Signature Eternal Band","$1633.00","When you feel it, say it. Express your love with this gorgeous diamond ring. See her sparkle in love!",R.drawable.ring_6),

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        recyclerView = findViewById(R.id.rView);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        

        mAdapter = new MyAdapter(datalist, new MyAdapter.ItemClickListener() {
            @Override
            public void onItemClick(MyData data) {

              
                String name= data.getName();
                String price= data.getPrice();
                String description= data.getDescription();
                int image= data.getImage();
                MyData selectedData= new MyData(name,price,description,image);
                Intent myIntent = new Intent(ListActivity.this, DetailsActivity.class);
//                myIntent.putExtra("name", name);
//                myIntent.putExtra("price", price);
//                myIntent.putExtra("description", description);
//                myIntent.putExtra("image",image);
                myIntent.putExtra("data",selectedData);
                startActivity(myIntent);

            }
        });
        recyclerView.setAdapter(mAdapter);

        ImageView homebutton= findViewById(R.id.homebutton);
        homebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent productList = new Intent(ListActivity.this,MainActivity.class);
                startActivity(productList);
            }
        });
        ImageView listbutton= findViewById(R.id.listbutton);
        listbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent productList = new Intent(ListActivity.this,ListActivity.class);
                startActivity(productList);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem item=menu.findItem(R.id.action_search);
        SearchView searchView= (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
             mAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}