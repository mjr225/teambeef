package com.calhacksproject.teamfunkybeefwrapthings.movietrak;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Zain on 10/4/2014.
 */
public class OurAdapter extends BaseAdapter {

    private List<TextView> tvs;
    private Activity activity;

    public OurAdapter(List<TextView> tvs, Activity activity) {
        this.tvs = tvs;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return this.tvs.size();
    }

    @Override
    public Object getItem(int i) {
        return tvs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView view2 = (TextView) this.activity.getLayoutInflater().inflate(R.layout.test_tv, null);
        view2.setText(tvs.get(i).getText());

        return view2;
    }
}
