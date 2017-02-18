package com.example.android.lifegoals;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserPageFragment extends Fragment {

    public int sample_image = R.mipmap.translation_icon;
    Intent reviewGoal;


    public UserPageFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootview = inflater.inflate(R.layout.fragment_user_page, container, false);

        final ArrayList<goal> goal_list = new ArrayList<>();

        goal_list.add(new goal("Become fluent in Russian", "Languages", sample_image));
        goal_list.add(new goal("Develop my goal-app", "Work", sample_image));


        MainGoalListAdapter listAdapter = new MainGoalListAdapter(getActivity(), goal_list);

        ListView goalMainListView = (ListView) rootview.findViewById(R.id.main_goal_listview);

        goalMainListView.setAdapter(listAdapter);

        reviewGoal = new Intent(this.getContext(), GoalReviewActivity.class);

        goalMainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(reviewGoal);
            }
        });

        return rootview;


    }

}
