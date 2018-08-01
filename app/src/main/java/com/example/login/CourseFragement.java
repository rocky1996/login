package com.example.login;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

public class CourseFragement extends Fragment{
    private ExpandableListView eListview = null;
    private ExpandableListAdapter adapter = null;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View courseLayout = inflater.inflate ( R.layout.course,container,false);
        this.eListview = (ExpandableListView)courseLayout.findViewById(R.id.elistview);
        this.adapter = new MyExpandableListViewAdapter ( getActivity () );
        this.eListview.setAdapter ( this.adapter );
        return courseLayout;
    }
}
