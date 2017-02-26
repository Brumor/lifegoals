package com.example.android.lifegoals;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AddGoalActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    public static final String FRIENDLY_MSG_LENGHT_KEY = "100";
    public static final int DEFAULT_MSG_LENGTH_LIMIT = 1000;
    public static final int RC_SIGN_IN = 1;
    private static final int RC_PHOTO_PICKER =  2;

    Button newGoalButton;
    Spinner termSpinner;
    Spinner typeSpinner;
    String currentUserId;
    EditText titleEdTxt;
    EditText descriptionEdTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_goal);

        Intent i = getIntent();
        currentUserId = i.getStringExtra("CurrentUserId");

        newGoalButton = (Button) findViewById(R.id.add_new_goal);
        newGoalButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                addGoalToDb();
                finish();
            }

        });

        titleEdTxt = (EditText) findViewById(R.id.goal_title_et);
        descriptionEdTxt = (EditText) findViewById(R.id.goal_description_et);
        termSpinner = (Spinner) findViewById(R.id.goal_term_spinner);
        typeSpinner = (Spinner) findViewById(R.id.goal_type_spinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> termAdapter = ArrayAdapter.createFromResource(this, R.array.term_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> typeAdapter = ArrayAdapter.createFromResource(this, R.array.type_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        termAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        termSpinner.setAdapter(termAdapter);
        typeSpinner.setAdapter(typeAdapter);

    }

    public void addGoalToDb() {
        goal lifegoal = new goal(titleEdTxt.getText().toString(),
                descriptionEdTxt.getText().toString(),
                typeSpinner.getSelectedItem().toString(),
                termSpinner.getSelectedItem().toString(),
                currentUserId);

        MainActivity.GoalDbReference.push().setValue(lifegoal);

        // Clear input box
    }

}
