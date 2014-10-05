package com.calhacksproject.teamfunkybeefwrapthings.movietrak;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Zain on 10/4/2014.
 */
public class OurAdapter extends BaseAdapter {

    private List<Movie> movies;
    private Activity activity;

    public OurAdapter(List<Movie> movies, Activity activity) {
        this.movies = movies;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return this.movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final Movie m = movies.get(i);



        LinearLayout layout1 = (LinearLayout) this.activity.getLayoutInflater().inflate(R.layout.newsingle, null);
        layout1.setClickable(true);
        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Main.class);
                intent.putExtra("movieData", m.getTitle() + "%%" + m.getDateTheater());
                activity.startActivity(intent);
            }
        });
        TextView title = (TextView) layout1.findViewById(R.id.texttitle);
        TextView date = (TextView) layout1.findViewById(R.id.textdate);
        ImageView image = (ImageView) layout1.findViewById(R.id.moviepicture);

        title.setText(m.getTitle());
        date.setText(m.getDateTheater());


        //update ui
        layout1.invalidate();

        return layout1;
    }
}
