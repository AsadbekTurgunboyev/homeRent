package com.example.renthome;

import static com.example.renthome.Const.ROLE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.renthome.fragment.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;
    PreferenceData data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViews();
        data = new PreferenceData(this);
        bottomNavigationView.setOnItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, new HomeFragment()).commit();
    }
    private void initViews() {
        bottomNavigationView = findViewById(R.id.bottomNav);
        frameLayout = findViewById(R.id.frame);

    }

    NavigationBarView.OnItemSelectedListener navListener = item -> {

        Fragment selectedFragment = null;
        switch (item.getItemId()) {
            case R.id.icHome:
                selectedFragment = new HomeFragment();
                break;


        }
        if (selectedFragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,selectedFragment).commit();
        }
        return true;
    };


}