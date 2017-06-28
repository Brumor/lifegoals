package com.example.android.lifegoals;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.util.ArrayList;

import static com.example.android.lifegoals.MainActivity.GoalDbReference;
import static com.example.android.lifegoals.MainActivity.mChildEventListener;


public class UserPageFragment extends Fragment {

    Intent reviewGoal;


    public UserPageFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootview = inflater.inflate(R.layout.fragment_user_page, container, false);

        final ArrayList<goal> goal_list = new ArrayList<>();

        final MainGoalListAdapter listAdapter = new MainGoalListAdapter(getActivity(), goal_list);

        final ListView goalMainListView = (ListView) rootview.findViewById(R.id.main_goal_listview);

        goalMainListView.setAdapter(listAdapter);

        //Starts the Goal Review Activity when I click on an Item in the list
        reviewGoal = new Intent(this.getContext(), GoalReviewActivity.class);
        goalMainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                reviewGoal.putExtra("title", listAdapter.getItem(position).getGoal_name());
                reviewGoal.putExtra("type", listAdapter.getItem(position).getGoal_type());
                reviewGoal.putExtra("content", listAdapter.getItem(position).getGoal_description());
                startActivity(reviewGoal);
            }

        });


        //Automatically add new goals here
        mChildEventListener = new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                goal lifegoal = dataSnapshot.getValue(goal.class);
                listAdapter.add(lifegoal);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        GoalDbReference.addChildEventListener(MainActivity.mChildEventListener);

        return rootview;


    }

}
