package com.example.android.lifegoals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by pbric on 12/02/2017.
 */

public class MainGoalListAdapter extends ArrayAdapter<goal> {

    public MainGoalListAdapter(Context context, ArrayList<goal> goal_list) {
        super(context, 0, goal_list);
    }

    public View getView (int position, View convertview, ViewGroup parent) {
        View listItemView = convertview;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.goal, parent, false);
        }

        goal currentGoal = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.goal_name);
        TextView typeTextView = (TextView) listItemView.findViewById(R.id.goal_type);
        ImageView iconImageView = (ImageView) listItemView.findViewById(R.id.icon_type);

        nameTextView.setText(currentGoal.getGoal_name());
        typeTextView.setText(currentGoal.getGoal_type());
        iconImageView.setImageResource(R.mipmap.translation_icon);


        return listItemView;
    }
}
