package com.calhacksproject.teamfunkybeefwrapthings.movietrak;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zain on 10/4/2014.
 */
public class MainFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.mainfragment, container, false);
        ListView lv = (ListView) v.findViewById(R.id.listView1);



        List movieItems = Main.movieItems;
        OurAdapter homeadapter = new OurAdapter(movieItems, this.getActivity());

        lv.setAdapter(homeadapter);




        Button b = (Button) v.findViewById(R.id.findButton);
        b.setOnClickListener(this);
        return v;
    }



    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.findButton) {
            Toast.makeText(getActivity(), "Button Clicked", Toast.LENGTH_SHORT).show();
            Main mainActivity = (Main) getActivity();
            mainActivity.fragmentSwitcher();

        }
    }
}
