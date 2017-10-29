package com.ecare.newu.e_care.Ambulance;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.ecare.newu.e_care.R;
import com.ecare.newu.e_care.public_portal.submit_image;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.container_ambulance, new booking()).commit();


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.rush) {
            setTitle("See Rush");
            getSupportFragmentManager().beginTransaction().replace(R.id.container_ambulance, new rush()).commit();

        } else if (id == R.id.book) {
            setTitle("Booked Ambulance");
            getSupportFragmentManager().beginTransaction().replace(R.id.container_ambulance, new booking()).commit();

        } else if (id == R.id.route) {
            setTitle("Change Route");
            getSupportFragmentManager().beginTransaction().replace(R.id.container_ambulance, new change_route()).commit();

        } else if (id == R.id.traffic) {
            setTitle("Emergency Traffic Control ");
            getSupportFragmentManager().beginTransaction().replace(R.id.container_ambulance, new emergancy()).commit();

        }
        else if (id == R.id.hos) {
            setTitle("Near Hospital");
            getSupportFragmentManager().beginTransaction().replace(R.id.container_ambulance, new view_hospital()).commit();

        }
        else if (id == R.id.police) {
            checkAndRequestPermissions();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS1 = 1;

    private boolean checkAndRequestPermissions() {
        int call = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

        List<String> listPermissionsNeeded = new ArrayList<>();
        if (call != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.CALL_PHONE);
        }

        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray
                    (new String[listPermissionsNeeded.size()]), REQUEST_ID_MULTIPLE_PERMISSIONS1);
            return false;
        }
        contact1();
        return true;
    }

    public void contact1() {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:100"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(callIntent);
    }
}
