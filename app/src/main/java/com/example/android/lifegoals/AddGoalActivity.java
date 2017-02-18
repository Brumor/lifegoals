package com.example.android.lifegoals;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class AddGoalActivity extends AppCompatActivity {

    Button newGoal ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_goal);

        final Toast Todo = Toast.makeText(this , "should add goal", Toast.LENGTH_SHORT);

        newGoal = (Button) findViewById(R.id.add_new_goal);
        newGoal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Todo.show();;
                finish();

            }

        });

        Spinner spinner = (Spinner) findViewById(R.id.Lenght);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.term_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

    }

}
