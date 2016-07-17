package com.example.android.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailFragment extends Fragment {

    Uri geoloc;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle extras = getActivity().getIntent().getExtras();
        String name = extras.getString("locName");
        String subname = extras.getString("locSubname");
        String hours = extras.getString("locHours");
        String address = extras.getString("locAddress");
        int image = extras.getInt("locImage");

        if(address != null) geoloc = Uri.parse("geo:0,0?q=" + name + "%20" + address.replace(" ", "%20"));

        View rootView = inflater.inflate(R.layout.detail_activity, container, false);

        TextView nameView = (TextView) rootView.findViewById(R.id.details_title);
        nameView.setText(name);

        TextView subnameView = (TextView) rootView.findViewById(R.id.details_subtitle);
        if(subname.equals("")){
            subnameView.setVisibility(View.GONE);
        } else {
            subnameView.setText(subname);
        }

        TextView hoursView = (TextView) rootView.findViewById(R.id.details_hours);
        if(hours.equals("")){
            hoursView.setVisibility(View.GONE);
        } else {
            hoursView.setText(hours);
        }

        TextView addressView = (TextView) rootView.findViewById(R.id.details_address);
        if(address.equals("")){
            addressView.setVisibility(View.GONE);
        } else {
            addressView.setText(address);
        }

        ImageView imageView = (ImageView) rootView.findViewById(R.id.details_image);
        if(image == -1){
            imageView.setVisibility(View.GONE);
        } else {
            imageView.setImageResource(image);
        }

        View btn = rootView.findViewById((R.id.map_btn));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(geoloc != null) showMap(geoloc);
            }
        });
        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    public void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
