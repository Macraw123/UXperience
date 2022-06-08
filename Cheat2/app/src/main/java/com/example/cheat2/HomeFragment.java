package com.example.cheat2;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HomeFragment extends Fragment {

    ArrayList<ModelData> arrayList = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        arrayList.add(new ModelData(R.drawable.ic_baseline_wheelchair_pickup_24, "1", "One"));
        arrayList.add(new ModelData(R.drawable.ic_baseline_wheelchair_pickup_24, "2", "Two"));
        arrayList.add(new ModelData(R.drawable.ic_baseline_wheelchair_pickup_24, "3", "Three"));
        arrayList.add(new ModelData(R.drawable.ic_baseline_wheelchair_pickup_24, "4", "Four"));
        arrayList.add(new ModelData(R.drawable.ic_baseline_wheelchair_pickup_24, "5", "Five"));

        ListAdapter numbersArrayAdapter = new ListAdapter(getActivity(), arrayList);
        // create the instance of the ListView to set the numbersViewAdapter
        ListView numbersListView = view.findViewById(R.id.list);

        // set the numbersViewAdapter for ListView
        numbersListView.setAdapter(numbersArrayAdapter);

        numbersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(position == 0) {
                    //code specific to first list item
//                    Toast.makeText(view.getContext(),"Place Your First Option Code",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(view.getContext(), ImageSlider.class);
                    startActivity(i);
                }

            }
        });

        return view;
    }
}