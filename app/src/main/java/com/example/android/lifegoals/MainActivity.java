package com.example.android.lifegoals;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    public final static String TAG = "101Lg";
    public static final int RC_SIGN_IN = 1;

    //daclare every Firebase components
    public FirebaseDatabase GoalFirebaseDb;
    public static ChildEventListener mChildEventListener;
    private FirebaseAuth LfGAuth;
    private FirebaseAuth.AuthStateListener LfGAuthListener;
    public FirebaseUser currentUser;
    public static DatabaseReference GoalDbReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        // Declare the Viewpager that will hold the Fragments
        final ViewPager viewPager = (ViewPager) findViewById(R.id.main_view_pager);

        //Initialize FirebaseDatabase  and Auth system
        GoalFirebaseDb = FirebaseDatabase.getInstance();
        LfGAuth = FirebaseAuth.getInstance();

        LfGAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                currentUser = firebaseAuth.getCurrentUser();

                if (currentUser != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + currentUser.getUid());

                    //Give the database a reference and setting up the adapter if the user is signed in
                    GoalDbReference = GoalFirebaseDb.getReference().child("user/" + currentUser.getDisplayName() +"/goal" );
                    MainPageViewAdapter mainPageViewAdapter = new MainPageViewAdapter(getSupportFragmentManager());
                    viewPager.setAdapter(mainPageViewAdapter);

                } else {

                    //Firebase API
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)
                                    .build(),
                            RC_SIGN_IN);
                }

            }
        };

    }

    public void openNewActivity(View view) {
        Intent act = new Intent(this, AddGoalActivity.class);
        act.putExtra("CurrentUserId", currentUser.getUid());
        startActivity(act);
    }

    @Override
    public void onStart() {
        super.onStart();
        LfGAuth.addAuthStateListener(LfGAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (LfGAuthListener != null) {
            LfGAuth.removeAuthStateListener(LfGAuthListener);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        LfGAuth.addAuthStateListener(LfGAuthListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (LfGAuthListener != null) {
            LfGAuth.removeAuthStateListener(LfGAuthListener);
        }
    }

}