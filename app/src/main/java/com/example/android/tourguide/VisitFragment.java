package com.example.android.tourguide;


import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class VisitFragment extends Fragment {

    public VisitFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(getString(R.string.visit1name), getString(R.string.visit1subname),
                getString(R.string.visit1hours), getString(R.string.visit1address)));
        locations.add(new Location(getString(R.string.visit2name), getString(R.string.visit2subname),
                getString(R.string.visit2hours), getString(R.string.visit2address)));
        locations.add(new Location(getString(R.string.visit3name), getString(R.string.visit3subname),
                getString(R.string.visit3hours), getString(R.string.visit3address)));
        locations.add(new Location(getString(R.string.visit4name), getString(R.string.visit4subname),
                getString(R.string.visit4hours), getString(R.string.visit4address)));

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.category_visit);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        View header = inflater.inflate(R.layout.category_header, listView, false);
        ImageView imageView = (ImageView) header.findViewById(R.id.list_category_image);
        imageView.setImageResource(R.drawable.visit);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        listView.addHeaderView(header);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                position--; // account for listView header
                if(position < 0) return;
                Location loc = locations.get(position);
                intent.putExtra("locName", loc.getName());
                intent.putExtra("locSubname", loc.getSubname());
                intent.putExtra("locHours", loc.getHours());
                intent.putExtra("locAddress", loc.getAddress());
                intent.putExtra("locImage", loc.getImageResourceId());
                startActivity(intent);
            }
        });
        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
    }

}
