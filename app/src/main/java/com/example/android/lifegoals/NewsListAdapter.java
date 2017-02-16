package com.example.android.lifegoals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by pbric on 14/02/2017.
 */

public class NewsListAdapter extends ArrayAdapter<news> {

    public NewsListAdapter(Context context, ArrayList<news> news_list) {
        super(context, 0, news_list);
    }

    public View getView(int position, View convertview, ViewGroup parent) {

        final View listItemView;

        if (convertview != null) {
            listItemView = convertview;
        } else {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.news, parent, false);
        }

        TextView usernameTextView = (TextView) listItemView.findViewById(R.id.user_name_txt);
        TextView contentTextView = (TextView) listItemView.findViewById(R.id.news_content_txt);
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.news_time_txt);


        //Add a special news to the first one of the listview
        if (position == 0) {

            usernameTextView.setText("test");
            contentTextView.setText("test");
            timeTextView.setText("test");

        } else {

            news currentNews = getItem(position);

            usernameTextView.setText(currentNews.getNews_username());
            contentTextView.setText(currentNews.getNews_content());
            timeTextView.setText(currentNews.getNews_time());
        }

        Button deleteButton = (Button) listItemView.findViewById(R.id.news_optionbutton);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(listItemView.getContext(), "add deleted", Toast.LENGTH_SHORT).show();
            }
        });


        return listItemView;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }


}
