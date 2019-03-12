package com.luan.session10_view.demomapniit;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.AutocompleteFragment;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    GoogleMap myMap;
    SupportMapFragment supportMapFragment;
    AutocompleteSupportFragment myPlaceAutoCompleteFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        supportMapFragment =(SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.myMap);
        myPlaceAutoCompleteFragment=(AutocompleteSupportFragment)getSupportFragmentManager().findFragmentById(R.id.myPlace);
        myPlaceAutoCompleteFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME));
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                myMap = googleMap;
                myMap.getUiSettings().setZoomControlsEnabled(true);
                myMap.addMarker(new MarkerOptions().position(new LatLng(21.028280,105.853882)).title("Vietname"));
                myMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(21.028280,105.853882)));
                myPlaceAutoCompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
                    @Override
                    public void onPlaceSelected(@NonNull Place place) {
                        myMap.addMarker(new MarkerOptions().position(place.getLatLng()).title(place.getName()+"_"+place.getAddress()));
                        myMap.moveCamera(CameraUpdateFactory.newLatLng(place.getLatLng()));
                    }

                    @Override
                    public void onError(@NonNull Status status) {

                    }
                });
            }
        });
    }
}
