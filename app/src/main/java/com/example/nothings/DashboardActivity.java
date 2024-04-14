package com.example.nothings;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.nothings.fragments.Dashboard;
import com.example.nothings.fragments.Expense;
import com.example.nothings.fragments.Income;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.dashboard);

    }

    Dashboard dashboardFragment = new Dashboard();
    Expense expenseFragment = new Expense();
    Income incomeFragment = new Income();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.income:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, incomeFragment).commit();
                return true;

            case R.id.dashboard:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, dashboardFragment).commit();
                return true;

            case R.id.expense:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, expenseFragment).commit();
                return true;
        }
        return false;
    }
}