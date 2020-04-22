package com.example.aljar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
//import androidx.fragment.app.ListFragment;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.aljar.fragments.CartFragment;
import com.example.aljar.fragments.DeliveryFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.aljar.fragments.ListFragment;
public class MainFunction extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_function);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(ListFragment.newInstance("", ""));
    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.FrameContainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_list:
                            openFragment(ListFragment.newInstance("", ""));
                            return true;
                        case R.id.navigation_delivery:
                            openFragment(DeliveryFragment.newInstance("", ""));
                            return true;
                        case R.id.navigation_cart:
                            openFragment(CartFragment.newInstance("", ""));
                            return true;
                    }
                    return false;
                }
            };

}
