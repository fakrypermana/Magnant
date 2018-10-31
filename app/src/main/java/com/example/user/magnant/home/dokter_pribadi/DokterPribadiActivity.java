package com.example.user.magnant.home.dokter_pribadi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.user.magnant.MyApplication;
import com.example.user.magnant.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class DokterPribadiActivity extends AppCompatActivity {

    private static final String TAG = DokterPribadiActivity.class.getSimpleName();
    private static final String URL = "https://api.myjson.com/bins/1g8twq";

    private RecyclerView recyclerView;
    private List<DokterModel> dokterList;
    private DokterPribadiAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokter_pribadi);

        recyclerView = findViewById(R.id.rv_dokter_pribadi);
        dokterList = new ArrayList<>();
        mAdapter = new DokterPribadiAdapter(this,dokterList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setNestedScrollingEnabled(false);

        fetchItems();

    }

    private void fetchItems() {
        JsonArrayRequest request = new JsonArrayRequest(URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if (response == null) {
                            Toast.makeText(getApplicationContext(),"Couldn't fetch the items! Pleas try again.", Toast.LENGTH_LONG).show();
                            return;
                        }

                        List<DokterModel> items = new Gson().fromJson(response.toString(), new TypeToken<List<DokterModel>>() {
                        }.getType());
                        Log.i(TAG, "onResponse: magi"+items);
                        dokterList.clear();
                        dokterList.addAll(items);

                        // refreshing recycler view
                        mAdapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // error in getting json
                Log.e(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(), "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        Log.i(TAG, "onResponse: magi"+request.toString());
        MyApplication.getInstance().addToRequestQueue(request);
    }

}
