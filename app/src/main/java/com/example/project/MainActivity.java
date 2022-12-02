package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button textMenu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        textMenu = findViewById(R.id.textMenu);




        CarouselView carousel = (CarouselView) findViewById(R.id.carousel);
        carousel.setPageCount(3);
        carousel.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                switch (position){
                    case 0:
                        imageView.setImageResource(R.drawable.image1);
                        break;
                    case 1:
                        imageView.setImageResource(R.drawable.image2);
                        break;
                    default:
                        imageView.setImageResource(R.drawable.image3);
                }
            }

        });

        textMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent productList = new Intent(MainActivity.this,ListActivity.class);
                startActivity(productList);
            }
        });

        ImageView homebutton= findViewById(R.id.homebutton);
        homebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent productList = new Intent(MainActivity.this,MainActivity.class);
                startActivity(productList);
            }
        });
        ImageView listbutton= findViewById(R.id.listbutton);
        listbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent productList = new Intent(MainActivity.this,ListActivity.class);
                startActivity(productList);
            }
        });



    }
}