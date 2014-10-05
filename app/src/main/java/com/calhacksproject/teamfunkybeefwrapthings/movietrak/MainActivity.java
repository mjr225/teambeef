package com.calhacksproject.teamfunkybeefwrapthings.movietrak;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Scroller;

import java.util.ArrayList;

/**
 * Created by Zain on 10/5/2014.
 */
public class MainActivity extends Activity {
    ArrayList<String> movieItems = new ArrayList<String>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        Button searchButton = (Button)findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        RelativeLayout r1 = (RelativeLayout)findViewById(R.id.r1);
        ScrollView sv = new ScrollView(this);

        LinearLayout ll = new LinearLayout(this);
        sv.addView(ll);

        for(int i =0; i < movieItems.size(); i++) {
            Button b = new Button(this);
            b.setText(movieItems.get(i));
            ll.addView(b);

        }

    }

}
