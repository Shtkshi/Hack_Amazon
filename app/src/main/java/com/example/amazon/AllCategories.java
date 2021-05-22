package com.example.amazon;

import android.os.Build;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.amazon.categories.clothing.men.Male_dress1;
import com.example.amazon.categories.clothing.women.Dress1;
import com.example.amazon.util.AllCategoriesAdapter;
import com.example.amazon.util.Utils;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AllCategories extends AppCompatActivity {

    ArrayList<String>NameOfProblem=new ArrayList<>();
    ArrayList<ArrayList<Integer>>icons = new ArrayList<ArrayList<Integer>>();
    ArrayList<Class>classes=new ArrayList<>();
    int disease;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_all_categories2);


        Bundle extras = getIntent().getExtras();
        assert extras != null;
        disease = extras.getInt("disease");
        Utils.change((LinearLayout) findViewById(R.id.categories), disease, this);

        AddingItems();

        RecyclerView recyclerView=findViewById(R.id.AllCategoriesRecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(AllCategories.this,LinearLayoutManager.VERTICAL,false));
        AllCategoriesAdapter Adapter=new AllCategoriesAdapter(AllCategories.this,NameOfProblem,icons,classes,disease);
        recyclerView.setAdapter(Adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }
    void AddingItems() {
        //problem name
        NameOfProblem.add("Women");
        NameOfProblem.add("Men");


        //Images for problems
        ArrayList<Integer>a=new ArrayList<>(4);

        a.add(R.drawable.womenicon);
        a.add(R.drawable.women_p);
        a.add(R.drawable.women_d);
        a.add(R.drawable.women_t);
        icons.add(a);
        ArrayList<Integer>b=new ArrayList<>(4);

        b.add(R.drawable.menicon);
        b.add(R.drawable.men_p);
        b.add(R.drawable.men_d);
        b.add(R.drawable.men_t);

        icons.add(b);

        classes.add(Dress1.class);
        classes.add(Male_dress1.class);


    }
}