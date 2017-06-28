package com.example.android.lifegoals;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GoalReviewActivity extends AppCompatActivity {

    Button closeButton;

    private TextView titleTextView;
    private TextView typeTextView;
    private TextView contentTextView;

    private String review_title;
    private String review_type;
    private String review_content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_review);

        titleTextView = (TextView) findViewById(R.id.review_goal_title);
        typeTextView = (TextView) findViewById(R.id.review_goal_type);
        contentTextView = (TextView) findViewById(R.id.review_goal_content);

        Intent i = getIntent();
        review_title = i.getStringExtra("title");
        review_type = i.getStringExtra("type");
        review_content = i.getStringExtra("content");

        titleTextView.setText(review_title);
        typeTextView.setText(review_type);
        contentTextView.setText(review_content);

        closeButton = (Button) findViewById(R.id.closebutton);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
