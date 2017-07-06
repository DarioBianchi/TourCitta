package com.example.bianc.tourcitta;

import android.content.Intent;
import android.icu.util.GregorianCalendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by bianc on 20/06/2017.
 */

public class CommentsActivity extends AppCompatActivity {
    private ArrayList<Comments> listComments = new ArrayList<Comments>();


    private static final String TAG = "CommentsActivity";
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    private DatabaseReference mDatabase;
    private String mUserId;
    private Button btn;
    private EditText et;
    private String luogo;
    private ArrayAdapter<Comments> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(myToolbar);


        getSupportActionBar().setLogo(R.drawable.icona_dettagli);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        // Initialize Firebase Auth and Database Reference
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        et =  (EditText) findViewById(R.id.input_insert_todo);
        btn =(Button) findViewById(R.id.button_add);
        adapter = new ArrayAdapter<Comments>(this, android.R.layout.simple_list_item_1, listComments);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras!=null) {
            luogo = (String) extras.getSerializable("luogo");
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Comments comments = new Comments(mFirebaseUser.getEmail(),et.getText().toString(),(new Date()).getTime());
                mDatabase.child("Comments").child(luogo).push().setValue(comments);
                et.setText("");
            }
        });

        // Use Firebase to populate the list.
        mDatabase.child("Comments").child(luogo).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String email = (String) dataSnapshot.child("utente").getValue();
                String msg =(String) dataSnapshot.child("msg").getValue();
                long date = (long) dataSnapshot.child("data").getValue();
                Comments comments = new Comments(email,msg,date);
                adapter.add(comments);
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });


    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        // or call onBackPressed()
        return true;
    }



}
