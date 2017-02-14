package com.example.android.lifegoals;

public class goal {

    private String goal_name;

    private String goal_type;

    private int goal_icon;

    public goal (String Name, String Type, int Icon) {
        goal_name = Name;

        goal_type = Type;

        goal_icon = Icon;

    }

    public String getGoal_name () {
        return goal_name;
    }

    public String getGoal_type() {return goal_type;}

    public int getGoal_icon() {return goal_icon;}


}
