package com.example.hau.myapplication;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by hau on 7/18/2017.
 */


public class SecondFragment extends Fragment implements OnMapReadyCallback {
    private static final int MY_PERMISSION_FINE_LOCATION = 101;
    private String title;
    private int page;
    private GoogleMap gMap;


    // newInstance constructor for creating fragment with arguments
    public static SecondFragment newInstance(int page, String title) {
        SecondFragment fragmentSecond = new SecondFragment();
        Bundle abcd = new Bundle();
        abcd.putInt("1", page);
        abcd.putString("Maps", title);
        fragmentSecond.setArguments(abcd);
        return fragmentSecond;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("1", 1);
        title = getArguments().getString("Maps");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.viewpager2, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.googlemaps);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;

        LatLng GurneyDriveHawker = new LatLng(5.440137, 100.308906);        //set the longitude and latitude
        googleMap.addMarker(new MarkerOptions().position(GurneyDriveHawker).title("Gurney Drive Hawker")); //set the marker based on the object lat&long and set the title
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(GurneyDriveHawker, 12)); //camera move and zoom

        LatLng KimberlyStreet = new LatLng(5.416390, 100.332674);
        googleMap.addMarker(new MarkerOptions().position(KimberlyStreet).title("Kimberly Hawker"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(KimberlyStreet, 12));

        LatLng ChuliaStreet = new LatLng(5.418056, 100.336607);
        googleMap.addMarker(new MarkerOptions().position(ChuliaStreet).title("Chulia Street Hawker"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ChuliaStreet, 12));

        LatLng Newlane = new LatLng(5.414842, 100.326461);
        googleMap.addMarker(new MarkerOptions().position(Newlane).title("Newlane Hawker"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Newlane, 12));

        LatLng PulauTikus = new LatLng(5.430496, 100.312053);
        googleMap.addMarker(new MarkerOptions().position(PulauTikus).title("Pulau Tikus Hawker"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(PulauTikus, 12));

        LatLng AirItam = new LatLng(5.401432, 100.278047);
        googleMap.addMarker(new MarkerOptions().position(AirItam).title("Air Itam Hawker And Market"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(AirItam, 12));

        LatLng BatuLanchang = new LatLng(5.390379, 100.306687);
        googleMap.addMarker(new MarkerOptions().position(BatuLanchang).title("Batu Lanchang Hawker And Market"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BatuLanchang, 12));

        LatLng Jelutong = new LatLng(5.389732, 100.312240);
        googleMap.addMarker(new MarkerOptions().position(Jelutong).title("Jelutong Hawker And Market"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ChuliaStreet, 12));

        LatLng PenangRoad = new LatLng(5.416950, 100.330832);
        googleMap.addMarker(new MarkerOptions().position(PenangRoad).title("Penang Road Teow Chew Chendol & Laksa"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(PenangRoad, 12));

        LatLng BayanBaru = new LatLng(5.324670, 100.2857047);
        googleMap.addMarker(new MarkerOptions().position(BayanBaru).title("Bayan Baru Market Hawker Center"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BayanBaru, 12));

        LatLng CecilStreet = new LatLng(5.407625, 100.328917);
        googleMap.addMarker(new MarkerOptions().position(CecilStreet).title("Cecil Street Market Hawker Center"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CecilStreet, 12));

        LatLng SungaiPinang = new LatLng(5.399538, 100.325550);
        googleMap.addMarker(new MarkerOptions().position(SungaiPinang).title("Sungai Pinang Food Court"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SungaiPinang, 12));

        if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            gMap.setMyLocationEnabled(true);        //show the blue dot and see own location
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSION_FINE_LOCATION);

            }
        }


    }

    //pop up a messagebox to ask user whether allow the permission or denied.
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSION_FINE_LOCATION:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                        gMap.setMyLocationEnabled(true);
                    }

                }else{
                    Toast.makeText(getContext(),"Access Denied",Toast.LENGTH_SHORT).show();

                }
                break;
        }
    }


}



