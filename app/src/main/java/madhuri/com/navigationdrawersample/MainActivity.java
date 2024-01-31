package madhuri.com.navigationdrawersample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navigationview);
        toolbar = findViewById(R.id.toolbar);

        //Set up toolbar work like actionbar
        setSupportActionBar(toolbar);

        //Method of Toggle Listner
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this,
                drawerLayout, toolbar, R.string.open_Drawer, R.string.close_drawer);

        //add in drawer layout
        drawerLayout.addDrawerListener(toggle);

        //manage stack to sync
        toggle.syncState();


        //add click on it and select one from multiple
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.mettress) {
                    loadFragment(new MettresFragment());
                    Toast.makeText(MainActivity.this, "Mattress", Toast.LENGTH_LONG).show();
                } else if (id == R.id.sofa) {
                    loadFragment(new SofaFragment());
                    Toast.makeText(MainActivity.this, "Sofa", Toast.LENGTH_LONG).show();
                } else if(id == R.id.pillow){
                    loadFragment(new PillowFragment());
                    Toast.makeText(MainActivity.this, "pillow", Toast.LENGTH_LONG).show();
                } else if (id == R.id.modernbed) {
                    loadFragment(new ModernBedFragment());
                    Toast.makeText(MainActivity.this, "ModernBed", Toast.LENGTH_LONG).show();
                } else if (id == R.id.kitchen) {
                    loadFragment(new KitchenFragment());
                    Toast.makeText(MainActivity.this, "Kitchen", Toast.LENGTH_LONG).show();
                } else if (id == R.id.slider) {
                    loadFragment(new SliderFragment());
                    Toast.makeText(MainActivity.this, "Slider Drawer", Toast.LENGTH_LONG).show();
                } else
                {
                    loadFragment(new ContactUSFragment());
                    Toast.makeText(MainActivity.this, "Contact Us", Toast.LENGTH_LONG).show();
                }
                drawerLayout.closeDrawer(GravityCompat.START);


                return true;
            }

            private void loadFragment(Fragment fragment) {

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                ft.add(R.id.container, fragment);
                ft.commit();
            }
        });


    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
