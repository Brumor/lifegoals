package com.example.android.lifegoals;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsThreadFragment extends Fragment {


    public NewsThreadFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootview = inflater.inflate(R.layout.fragment_news_thread, container, false);

        final ArrayList<news> news_list = new ArrayList<>();

        news_list.add(new news("Paul Bricout"));
        news_list.add(new news("Paul Bricout"));


        NewsListAdapter listAdapter = new NewsListAdapter(getActivity(), news_list);

        ListView newsListView = (ListView) rootview.findViewById(R.id.news_listview);

        newsListView.setAdapter(listAdapter);

        return rootview;
    }

}
