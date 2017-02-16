package com.example.android.lifegoals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by pbric on 14/02/2017.
 */

public class NewsListAdapter extends ArrayAdapter<news> {

    public NewsListAdapter(Context context, ArrayList<news> news_list) {
        super(context, 0, news_list);
    }

    public View getView (int position, View convertview, ViewGroup parent) {
        View listItemView = convertview;

        if (listItemView == null) {listItemView = LayoutInflater.from(getContext()).inflate(R.layout.news, parent, false);}

        news currentNews = getItem(position);

        TextView usernameTextView = (TextView) listItemView.findViewById(R.id.user_name_txt);
        TextView contentTextView = (TextView) listItemView.findViewById(R.id.news_content_txt);
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.news_time_txt);

        usernameTextView.setText(currentNews.getNews_username());
        contentTextView.setText(currentNews.getNews_content());
        timeTextView.setText(currentNews.getNews_time());


        return listItemView;
    }

}
