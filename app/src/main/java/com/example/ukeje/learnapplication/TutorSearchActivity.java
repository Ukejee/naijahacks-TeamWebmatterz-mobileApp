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
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TutorSearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    public List<Tutor> tutorList = new ArrayList<>();
    private RecyclerView recyclerView;
    public TutorAdapter myAdapter;
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

        SearchView simpleSearchView =  findViewById(R.id.searchview);
        CharSequence query = simpleSearchView.getQuery();

        simpleSearchView.setOnQueryTextListener(this);


    }

        @Override
        public boolean onQueryTextSubmit(String query) {

            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {

            return false;
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
        Tutor tutor = new Tutor("Jimi Abaje", "Ikorodu", "French","jimi@gmail.com"
                                ,"Male","Just Starting","J.S.S, S.S.S","password",
                                "I have a B.Sc and M.Sc in French with a flaire for teaching.");
        tutorList.add(tutor);

        tutor = new Tutor("John Adeleke", "Festac", "Mathematics","adeleke@gmail.com"
                        ,"Male","Less than three years","J.S.S, S.S.S, Undergraduates"
                        ,"password",
                "I have a B.Sc and M.Sc in Industrial Mathematics with a flaire for teaching.");
        tutorList.add(tutor);

        tutor = new Tutor("Francis Igwe", "Ketu", "Biology","igwe@gmail.com","Male"
                        ,"4 - 10 years","J.S.S, S.S.S","password","I have a" +
                    " B.Sc in Microbiology.");
        tutorList.add(tutor);

        tutor = new Tutor("Ireti Doyle", "Maryland", "Chemistry","ireti@gmail.com","Female"
                        ,"Over 10 years","J.S.S, S.S.S","password","I have a B.Sc " +
                "in Chemistyr");
        tutorList.add(tutor);

        tutor = new Tutor("Isaac John", "Obanikoro", "Civic Education","isaac@gmail.com",
                        "Male","Just Starting","J.S.S,S.S.S","password",
                "I have a B.Sc  in Political Science with a flaire for teaching.");
        tutorList.add(tutor);

        tutor = new Tutor("Usman Farouk", "Maryland", "Mathematics","usman@gmail.com",
                        "Male","Over 10 years","Undergraduates","password",
                        "I have a B.Sc, M.Sc and Phd in Mathematics.");
        tutorList.add(tutor);

        tutor = new Tutor("Olabisi Stave", "Lekki", "English Language","steve@gmail.com",
                "Male","Just Starting","J.S.S,S.S.S","password",
                "I have a B.Sc in English Language.");
        tutorList.add(tutor);

        tutor = new Tutor("Chioma Obi", "Surlere", "Physics","chioma@gmail.com",
                "Female","Over 10 years","Undergraduates","password",
                "I have a B.Sc, M.Sc and Phd in Physics.");
        tutorList.add(tutor);

        tutor = new Tutor("Yetunde Willams", "Ikorodu", "Goverment","yetunde@gmail.com",
                "Female"," 4 - 10 years","S.S.S","password",
                "I have a B.Sc in Politica Science.");
        tutorList.add(tutor);

        tutor = new Tutor("Matthew Ogunlana", "Okota", "Accounting","ogunlana@gmail.com",
                "Male","Over 3 years","J.S.S,S.S.S,Undergraduates","password",
                "I have a B.Sc and M.Sc in Financial Accounting.");
        tutorList.add(tutor);

        tutor = new Tutor("Ayo Balogun", "Gbagada", "Economics","ayo@gmail.com",
                "Male","Over 10 years","Undergraduates","password",
                "I have a B.Sc, M.Sc and Phd in Economics.");
        tutorList.add(tutor);

        tutor = new Tutor("Seun Samson", "Fadeyi", "English","seun@gmail.com",
                "Male","Just Starting","Primary,J.S.S,S.S.S","password",
                "I have a B.Sc in English Language.");
        tutorList.add(tutor);

        tutor = new Tutor("Bimbo Olawale", "Ikeja", "Literature","bimbo@gmail.com",
                "Female","Over 3 years","S.S.S","password",
                "I have a B.Sc in English Language.");
        tutorList.add(tutor);

        tutor = new Tutor("Abasi Etuk", "Ikoyi", "Agricultural Science","abasi@gmail.com",
                "Male","Over 10 years","J.S.S,S.S.S","password",
                "I have a B.Sc in Botany");
        tutorList.add(tutor);

        tutor = new Tutor("Jide Olatunde", "CMS", "Technical Drawing","jide@gmail.com",
                "Male","Just Starting","S.S.S","password",
                "I have a B.Sc in Civil Engineering.");
        tutorList.add(tutor);

        tutor = new Tutor("Bisi Yinka", "Apapa", "Basic Science","bisi@gmail.com",
                "Female","Over 10 years","Primary,J.S.S,S.S.S","password",
                "I have a B.Sc in BioChemistry.");
        tutorList.add(tutor);


        myAdapter.notifyDataSetChanged();
    }
}
