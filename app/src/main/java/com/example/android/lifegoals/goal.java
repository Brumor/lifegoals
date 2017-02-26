package com.example.android.lifegoals;

public class goal {

    private String goal_name;

    private String goal_description;

    private String goal_type;

    private String goal_term;

    private String goal_user;

    public goal (String Name, String Description, String Type, String Term, String User) {
        goal_name = Name;

        goal_description = Description;

        goal_type = Type;

        goal_term = Term;

        goal_user = User;

    }

    //datasnapchot needs an empty constructor for some reason
    public goal () {}

    public String getGoal_name () {
        return goal_name;
    }

    public String getGoal_description () {return goal_description;}

    public String getGoal_type() {return goal_type;}

    public String getGoal_term () {return goal_term;}

    public String getGoal_user() {return goal_user;}


}
