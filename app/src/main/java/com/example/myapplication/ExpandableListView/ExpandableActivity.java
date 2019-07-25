package com.example.myapplication.ExpandableListView;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;
import com.example.myapplication.Adapter.ExpandableListAdapter;
import com.example.myapplication.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableActivity extends AppCompatActivity {

    //initialize
    private Activity activity;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> groupList;
    HashMap<String, List<String>> childListofGroup;
    private int previousGroup = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable);

        activity = ExpandableActivity.this;
        findViews();
        init();
        setListener();
    }

    private void findViews() {
        expandableListView = findViewById(R.id.ExpandableListView);
    }

    private void init() {
// load list data
        loadListData();

// set adapter
        expandableListAdapter = new ExpandableListAdapter(this,groupList, childListofGroup);
        expandableListView.setAdapter(expandableListAdapter);
    }

    private void setListener() {
// Listview Group click listener
        expandableListView.setOnGroupClickListener(new ExpandableListView.
                OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                Toast.makeText(activity,
                        "Group Clicked " + groupList.get(groupPosition),
                        Toast.LENGTH_SHORT).show();

// only one group is populate using this
                if (expandableListView.isGroupExpanded(groupPosition)) {
                    expandableListView.collapseGroup(groupPosition);
                    previousGroup=-1;
                } else {
                    expandableListView.expandGroup(groupPosition);
                    if(previousGroup!=-1){
                        expandableListView.collapseGroup(previousGroup);
                    }
                    previousGroup=groupPosition;
                }
                return true;
            }
        });

// Listview Group expanded listener
        expandableListView.setOnGroupExpandListener(new ExpandableListView.
                OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(activity,
                        groupList.get(groupPosition) +
                                " Expanded", Toast.LENGTH_SHORT).show();
            }
        });

// Listview Group collasped listener
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.
                OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(activity,
                        groupList.get(groupPosition) +
                                " Collapsed", Toast.LENGTH_SHORT).show();

            }
        });
// Listview on child click listener
        expandableListView.setOnChildClickListener(new ExpandableListView.
                OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        activity,
                        groupList.get(groupPosition)
                                + " : "
                                + childListofGroup.get(
                                groupList.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();

                return false;
            }
        });
    }
    private void loadListData() {
        groupList = new ArrayList<String>();
        childListofGroup = new HashMap<String, List<String>>();

// Adding group header data
        groupList.add("Movie Names");
        groupList.add("Song Names");
        groupList.add("Book Names");

// Adding child data
        List<String> movies = new ArrayList<String>();
        movies.add("Avengers Infinity War");
        movies.add("Deadpool 2");
        movies.add("Doctor Strange");
        movies.add("Fast and Furious 8");
        movies.add("Ready Player One");

        List<String> music = new ArrayList<String>();
        music.add("Nucleya");
        music.add("Shape of You");
        music.add("Chainsmokers");
        music.add("Back To You");
        music.add("Despacito");

        List<String> books = new ArrayList<String>();
        books.add("Sacred Games");
        books.add("Our Mutual Friend");
        books.add("Story of the Eye");
        books.add("Mahabharata");
        books.add("The Discovery of India\n");

// Group header, Child data
        childListofGroup.put(groupList.get(0), movies);
        childListofGroup.put(groupList.get(1), music);
        childListofGroup.put(groupList.get(2), books);
    }
}