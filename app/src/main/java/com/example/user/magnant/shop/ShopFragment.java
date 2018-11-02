package com.example.user.magnant.shop;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.magnant.R;
import com.example.user.magnant.home.dokter_pribadi.DokterModel;
import com.example.user.magnant.home.dokter_pribadi.DokterPribadiAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class ShopFragment extends Fragment {
    private Toolbar toolbar;

    private RecyclerView recyclerView;
    private List<ObatModel> listObat;
    private ShopAdapter mAdapter;
    DatabaseReference dbObat;

    public ShopFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false);

        toolbar = view.findViewById(R.id.toolbar_shop);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        listObat = new ArrayList<>();
        mAdapter = new ShopAdapter(getActivity(), listObat);

        recyclerView = view.findViewById(R.id.rv_obat);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setNestedScrollingEnabled(false);

        listObat.add(new ObatModel("Prenagen",1,2000));
        listObat.add(new ObatModel("Prenagen",1,2000));
        listObat.add(new ObatModel("Prenagen",1,2000));
        listObat.add(new ObatModel("Prenagen",1,2000));
        listObat.add(new ObatModel("Prenagen",1,2000));
        listObat.add(new ObatModel("Prenagen",1,2000));
        listObat.add(new ObatModel("Prenagen",1,2000));
        listObat.add(new ObatModel("Prenagen",1,2000));

        dbObat = FirebaseDatabase.getInstance().getReference("obat");
        dbObat.addListenerForSingleValueEvent(valueEventListener);


        getActivity().setTitle("Shop");

        return view;
    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            listObat.clear();
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    ObatModel obat = snapshot.getValue(ObatModel.class);
                    listObat.add(obat);
                }
                mAdapter.notifyDataSetChanged();
            }
        }
        @Override
        public void onCancelled(DatabaseError databaseError) {

        }

    }


    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
