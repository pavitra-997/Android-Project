package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    static ArrayList<MyData> datalist= new ArrayList<MyData>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView = findViewById(R.id.cartView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        MyData selectedData=(MyData)getIntent().getParcelableExtra("data");
        datalist.add(selectedData);

        mAdapter = new CartAdapter(datalist);
        recyclerView.setAdapter(mAdapter);
//        Button checkOutButton = findViewById(R.id.checkOutButton);
//        checkOutButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//
//            public void onClick(View view){
//                Intent myIntent = new Intent(CartActivity.this, CheckOut.class);
//                myIntent.putExtra("data",selectedData);
//                startActivity(myIntent);
//
//
//            }
//        });

        double sum = (datalist.stream().mapToDouble(p -> Double.parseDouble(p.getPrice().replace('$', ' '))).sum());
        String sum1= Double.toString(sum);
        Button btnPayment = (Button) findViewById(R.id.checkOutButton);
        btnPayment.setText("Your Cart Total: $"+sum1);
        btnPayment.setOnClickListener(view -> {
            setContentView(R.layout.activity_check_out);
        });


        ImageView homebutton= findViewById(R.id.homebutton);
        homebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent productList = new Intent(CartActivity.this,MainActivity.class);
                startActivity(productList);
            }
        });
        ImageView listbutton= findViewById(R.id.listbutton);
        listbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent productList = new Intent(CartActivity.this,ListActivity.class);
                startActivity(productList);
            }
        });
    }
}