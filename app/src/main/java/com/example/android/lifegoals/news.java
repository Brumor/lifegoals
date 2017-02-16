package com.example.android.lifegoals;

/**
 * Created by pbric on 14/02/2017.
 */

public class news {

    String news_username;
    String news_content;
    String news_time;

    public news (String UserName, String Content, String Time) {

        news_username = UserName;
        news_content = Content;
        news_time = Time;

    }

    public String getNews_username () {return news_username;}
    public String getNews_content () {return news_content;}
    public String getNews_time () {return  news_time;}

}
