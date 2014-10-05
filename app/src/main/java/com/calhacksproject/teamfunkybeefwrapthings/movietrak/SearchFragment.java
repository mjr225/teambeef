package com.calhacksproject.teamfunkybeefwrapthings.movietrak;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.net.URLEncoder;
import java.util.ListIterator;

/**
 * Created by Zain on 10/4/2014.
 */
public class SearchFragment extends Fragment implements View.OnClickListener{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_main, container, false);
        Button b = (Button) v.findViewById(R.id.searchButton);
        b.setOnClickListener(this);
        return v;
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.searchButton) {
            Toast.makeText(getActivity(), "Button Clicked", Toast.LENGTH_SHORT).show();

            EditText edit = (EditText) getView().findViewById(R.id.editText);
            String searchString = edit.getText().toString();

            Toast.makeText(getActivity(), searchString, Toast.LENGTH_SHORT).show();
            final String API_KEY = "w78ab8sd5wzx3c2zuh3wakcu";

            String urlString = URLEncoder.encode(searchString);

            new RequestTask( (ListView) getView().findViewById(R.id.listViewSearch), getActivity()).execute("http://api.rottentomatoes.com/api/public/v1.0/movies.json?apikey=" +
                    API_KEY + "&q=" + urlString + "&page_limit=" + 15);





        }
    }
}
