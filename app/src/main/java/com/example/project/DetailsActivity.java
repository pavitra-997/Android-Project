package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        TextView name;
        TextView price;
        TextView description;
        ImageView image;
        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        description = findViewById(R.id.description);
        image=findViewById(R.id.image);

        Button button=findViewById(R.id.addToCart);

        Intent intent=getIntent();
       // Log.i("info","Details page invoked");
        MyData selectedData=(MyData)getIntent().getParcelableExtra("data");
        name.setText(selectedData.getName());
        price.setText(selectedData.getPrice());
        description.setText(selectedData.getDescription());
        image.setImageResource(selectedData.getImage());
//        name.setText(intent.getStringExtra("name"));
//        price.setText(intent.getStringExtra("price"));
//        description.setText(intent.getStringExtra("description"));
//        image.setImageResource(intent.getIntExtra("image",0));


        button.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View view){
                Intent myIntent = new Intent(DetailsActivity.this, CartActivity.class);
                myIntent.putExtra("data",selectedData);
                startActivity(myIntent);


            }
        });

        ImageView homebutton= findViewById(R.id.homebutton);
        homebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent productList = new Intent(DetailsActivity.this,MainActivity.class);
                startActivity(productList);
            }
        });
        ImageView listbutton= findViewById(R.id.listbutton);
        listbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent productList = new Intent(DetailsActivity.this,ListActivity.class);
                startActivity(productList);
            }
        });
    }

}