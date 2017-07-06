package com.example.bianc.tourcitta;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.Manifest;


import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;

import static com.example.bianc.tourcitta.R.id.map;
import static com.example.bianc.tourcitta.R.id.title;


public class MapsActivity extends FragmentActivity implements GoogleMap.OnInfoWindowClickListener, GoogleMap.OnMarkerClickListener, OnMapReadyCallback,
        GoogleMap.OnMyLocationButtonClickListener, ActivityCompat.OnRequestPermissionsResultCallback{

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private boolean mPermissionDenied = false;
    private GoogleMap mMap;

    private Marker m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.tool_bar_nosupport);
        setActionBar(myToolbar);
        //setSupportActionBar(myToolbar);

        // Display icon in the toolbar
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(true);
        getActionBar().setLogo(R.drawable.icona_mappa);
        getActionBar().setDisplayUseLogoEnabled(true);

        myToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId()==R.id.action_logout){
                    FirebaseAuth.getInstance().signOut();
                    Intent intent = new Intent(getApplicationContext(), LogInActivity.class);
                    startActivity(intent);
                    finish();
                    return true;
                }
                return false;
            }
        });
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);
        mapFragment.getMapAsync(this);




    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setOnMyLocationButtonClickListener(this);
        enableMyLocation();

        // Add some markers to the map
        m1 = mMap.addMarker(new MarkerOptions()
                .position(Luoghi.cattedraleDiComo)
                .title("Cattedrale di Como"));
        m1.setTag(0);
        m2 = mMap.addMarker(new MarkerOptions()
                .position(Luoghi.teatroSociale)
                .title("Teatro Sociale"));
        m2.setTag(0);
        m3 = mMap.addMarker(new MarkerOptions()
                .position(Luoghi.bibliotecaComunalediComo)
                .title("Biblioteca Comunale di Como"));
        m3.setTag(0);
        m4 = mMap.addMarker(new MarkerOptions()
                .position(Luoghi.chiesaCattolicaParrocchialeSGiuliano)
                .title("Chiesa Cattolica Parrocchiale S.Giuliano"));
        m4.setTag(0);
        m5 = mMap.addMarker(new MarkerOptions()
                .position(Luoghi.chiesaDiSanGiacomo)
                .title("Chiesa di S.Giacomo"));
        m5.setTag(0);
        m6 = mMap.addMarker(new MarkerOptions()
                .position(Luoghi.funicolareComoBrunate)
                .title("Funicolare Como - Brunate"));
        m6.setTag(0);
        m7 = mMap.addMarker(new MarkerOptions()
                .position(Luoghi.parrocchiaSantAgata)
                .title("Parrocchia Sant. Agata"));
        m7.setTag(0);
        m8 = mMap.addMarker(new MarkerOptions()
                .position(Luoghi.parrocchiaSDonnino)
                .title("Parrocchia S.Donnino"));
        m8.setTag(0);
        m9 = mMap.addMarker(new MarkerOptions()
                .position(Luoghi.tempioVoltiano)
                .title("Tempio Voltiano"));
        m9.setTag(0);
        m10 = mMap.addMarker(new MarkerOptions()
                .position(Luoghi.parrocchiaSFedele)
                .title("Parrocchia S.Fedele"));
        m10.setTag(0);
        m11 = mMap.addMarker(new MarkerOptions()
                .position(Luoghi.parrocchiaSSCrocifisso)
                .title("Parrocchia S.S.Crocifisso"));
        m11.setTag(0);
        m12 = mMap.addMarker(new MarkerOptions()
                .position(Luoghi.sanBartolomeo)
                .title("Chiesa Cattolica Parrocchiale S.Bartolomeo"));
        m12.setTag(0);


        // Set a listener for marker click.
        mMap.setOnMarkerClickListener(this);

        // Set a listener for info window events.
        mMap.setOnInfoWindowClickListener(this);


    }

    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
// Permission to access the location is missing.
            PermissionUtils.requestPermission(this, LOCATION_PERMISSION_REQUEST_CODE,
                    Manifest.permission.ACCESS_FINE_LOCATION, true);
        } else if (mMap != null) {
// Access to the location has been granted to the app.
            mMap.setMyLocationEnabled(true);
        }
    }

    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();
// Return false so that we don't consume the event and the default behavior still occurs
// (the camera animates to the user's current position).
        return false;
    } @
            Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE) {
            return;
        }
        if (PermissionUtils.isPermissionGranted(permissions, grantResults,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
// Enable the my location layer if the permission has been granted.
            enableMyLocation();
        } else {
// Display the missing permission error dialog when the fragments resume.
            mPermissionDenied = true;
        }
    }

    protected void onResumeFragments() {
        super.onResumeFragments();
        if (mPermissionDenied) {
// Permission was not granted, display error dialog.
            showMissingPermissionError();
            mPermissionDenied = false;
        }
    }
    /**
     * Displays a dialog with error message explaining that the location permission is missing.
     */
    private void showMissingPermissionError() {
        PermissionUtils.PermissionDeniedDialog
                .newInstance(true).show(getSupportFragmentManager(), "dialog");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onMarkerClick(final Marker marker) {
        // Return false to indicate that we have not consumed the event and that we wish
        return false;
    }

    @Override
    public void onInfoWindowClick (Marker marker) {
        Intent intent = new Intent(MapsActivity.this,DetailsActivity.class);
        Bundle extras = new Bundle();
        extras.putSerializable("luogo",marker.getTitle());
        intent.putExtras(extras);
        MapsActivity.this.startActivity(intent, extras);


    }


}
