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



        news_list.add(new news("Paul Bricout" + " à mis à jour son challenge 'programmer sa première app' : ",  " 15 % ", "Mardi 14 Février"));
        news_list.add(new news("Paul Bricout" + " à mis à jour son challenge 'programmer sa première app' : ", "J'ai fait le design des Life News ! ", "Mardi 14 Février"));
        news_list.add(new news("Paul Bricout" + " à mis à jour son challenge 'apprendre le russe' : ", " J'ai appris une nouvelle expression ! \n " + "я люблю тебя = je t'aime", "Mardi 14 Février"));
        news_list.add(new news("Paul Bricout" + " a un nouveau challenge :", "apprendre le Russe", "Mardi 14 Février"));
        news_list.add(new news("Paul Bricout" + " a un nouveau challenge :", "programmer sa première app", "Mardi 14 Février"));


        NewsListAdapter listAdapter = new NewsListAdapter(getActivity(), news_list);

        ListView newsListView = (ListView) rootview.findViewById(R.id.news_listview);

        newsListView.setAdapter(listAdapter);

        return rootview;
    }

}
