package com.example.user.magnant.controlling.monitoring;

import android.content.Intent;
import android.os.Parcelable;
import android.speech.RecognizerIntent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.arlib.floatingsearchview.suggestions.SearchSuggestionsAdapter;
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;
import com.example.user.magnant.MainActivity;
import com.example.user.magnant.R;

import java.util.ArrayList;
import java.util.List;

public class AddMonitoringActivity extends AppCompatActivity {
    private FloatingSearchView mSearchView;
    private FloatingActionButton fb_add_item;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_monitoring);

        fb_add_item = findViewById(R.id.fb_add_item);
        mSearchView = findViewById(R.id.floating_search_view);
        toolbar = findViewById(R.id.toolbar_addMonitoring);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fb_add_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Data Gizi sudah ditambahkan", Toast.LENGTH_SHORT).show();
            }
        });


        mSearchView.setOnBindSuggestionCallback(new SearchSuggestionsAdapter.OnBindSuggestionCallback() {
            @Override
            public void onBindSuggestion(View suggestionView, ImageView leftIcon, TextView textView, com.arlib.floatingsearchview.suggestions.model.SearchSuggestion item, int itemPosition) {


            }
        });
        

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(AddMonitoringActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
