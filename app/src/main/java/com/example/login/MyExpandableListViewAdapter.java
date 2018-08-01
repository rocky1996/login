package com.example.login;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class MyExpandableListViewAdapter extends BaseExpandableListAdapter{
    private String[] groups = new String[]{"Android课程","IOS开发课程","Window桌面开发课程"};
    private String[][] children = new String[][]{{"Android课程1","Android课程2","Android课程3"},{"IOS开发课程1","IOS开发课程2","IOS开发课程3"},{"Window桌面开发课程1","Window桌面开发课程2","Window桌面开发课程3"}};
    private Context context;
    public MyExpandableListViewAdapter(Context context){
        this.context = context;
    }

    @Override
    public long getGroupId(int groupPosition){
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition,int childPosition){
        return childPosition;
    }

    @Override
    public boolean hasStableIds(){
        return false;
    }
    @Override
    public int getGroupCount(){
        return this.groups.length;
    }

    @Override
    public int getChildrenCount(int groupPosition){
        return this.children.length;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition){
        return 0;
    }

    @Override
    public Object getGroup(int groupPosition){
        return 0;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent){
        TextView textView = this.buildTextView ();
        textView.setText(this.getGroup(groupPosition).toString ());
        return textView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,boolean isExpanded, View convertView, ViewGroup parent){
        TextView textView = this.buildTextView ();
        textView.setText(this.getChild(groupPosition,childPosition).toString ());
        return textView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition,int childPosition){
        return false;
    }

    private TextView buildTextView(){
        TextView textView = new TextView ( this.context );
        AbsListView.LayoutParams params = new AbsListView.LayoutParams ( ViewGroup.LayoutParams.FILL_PARENT,126 );
        textView.setLayoutParams ( params );
        textView.setTextSize ( 15.0f );
        textView.setGravity ( Gravity.LEFT );
        textView.setPadding ( 64,32,3,3 );
        return textView;
    }
}
