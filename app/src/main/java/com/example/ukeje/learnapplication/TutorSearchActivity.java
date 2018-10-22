package com.example.ukeje.learnapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class TutorSearchActivity extends AppCompatActivity {

    private List<Tutor> tutorList = new ArrayList<>();
    private RecyclerView recyclerView;
    private TutorAdapter myAdapter;
    private Toolbar myToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_search);

        recyclerView =  findViewById(R.id.recycler_view);

        myAdapter = new TutorAdapter(tutorList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(myAdapter);

        prepareMovieData();

        myToolBar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolBar);
        //onCreateOptionMenu(R.id.myToolBar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();

        if(id == R.id.add_account){
            Intent intent = new Intent(this, SignUpActivity.class);
            startActivity(intent);
        }

        return  super.onOptionsItemSelected(item);
    }

    private void prepareMovieData() {
        Tutor tutor = new Tutor("Jimi Abaje", "Ikorodu", "French");
        tutorList.add(tutor);

        tutor = new Tutor("John Adeleke", "Festac", "Mathematics");
        tutorList.add(tutor);

        tutor = new Tutor("Francis Igwe", "Ketu", "Biology");
        tutorList.add(tutor);

        tutor = new Tutor("Ireti Doyle", "Maryland", "Chemistry");
        tutorList.add(tutor);

        tutor = new Tutor("Isaac John", "Obanikoro", "Civic Education");
        tutorList.add(tutor);

        tutor = new Tutor("Usman Farouk", "Maryland", "Mathematics");
        tutorList.add(tutor);

        tutor = new Tutor("Olabisi Stave", "Lekki", "English Language");
        tutorList.add(tutor);

        tutor = new Tutor("Chioma Obi", "Surlere", "Physics");
        tutorList.add(tutor);

        tutor = new Tutor("Yetunde Willams", "Ikorodu", "Goverment");
        tutorList.add(tutor);

        tutor = new Tutor("Matthew Ogunlana", "Okota", "Accounting");
        tutorList.add(tutor);

        tutor = new Tutor("Ayo Balogun", "Gbagada", "Economics");
        tutorList.add(tutor);

        tutor = new Tutor("Seun Samson", "Fadeyi", "English");
        tutorList.add(tutor);

        tutor = new Tutor("Bimbo Olawale", "Ikeja", "Literature");
        tutorList.add(tutor);

        tutor = new Tutor("Abasi Etuk", "Ikoyi", "Agricultural Science");
        tutorList.add(tutor);

        tutor = new Tutor("Jide Olatunde", "CMS", "Technical Drawing");
        tutorList.add(tutor);

        tutor = new Tutor("Bisi Yinka", "Apapa", "Basic Science");
        tutorList.add(tutor);

        myAdapter.notifyDataSetChanged();
    }
}
