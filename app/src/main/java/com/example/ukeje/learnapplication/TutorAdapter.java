package com.example.ukeje.learnapplication;

import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

public class TutorAdapter extends RecyclerView.Adapter<TutorAdapter.MyViewHolder> {

    private List<Tutor> tutorsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, location, subjects;

        public MyViewHolder(View view) {
            super(view);
            name=  view.findViewById(R.id.name);
            subjects =  view.findViewById(R.id.location);
            location = view.findViewById(R.id.subjects);
        }
    }


    public TutorAdapter(List<Tutor> tutorsList) {
        this.tutorsList = tutorsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tutor_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Tutor tutor = tutorsList.get(position);
        holder.name.setText(tutor.getName());
        holder.subjects.setText(tutor.getSubjects());
        holder.location.setText(tutor.getLocation());
    }

    @Override
    public int getItemCount() {
        return tutorsList.size();
    }


}

