package com.example.bookingapptim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.bookingapptim.databinding.ActivityHomeScreenBinding;
import com.example.bookingapptim.fragments.FragmentTransition;
import com.example.bookingapptim.fragments.MainScreen;
import com.example.bookingapptim.fragments.ReservationsScreen;
import com.google.android.material.navigation.NavigationView;
import androidx.fragment.app.Fragment;

public class HomeScreen extends AppCompatActivity {

    private ActivityHomeScreenBinding binding;
    private Toolbar toolbar;

    private ActionBar actionBar;

    private NavController navController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        toolbar = binding.toolbar;
        // Postavljamo toolbar kao glavnu traku za ovu aktivnost
        setSupportActionBar(toolbar);
        // Dobavljamo referencu na glavnu traku za ovu aktivnost
        actionBar = getSupportActionBar();
        if(actionBar != null){
            // postavlja prikazivanje "strelice prema nazad" (back arrow)
            // kao indikatora navigacije na lijevoj strani Toolbar-a.
            actionBar.setDisplayHomeAsUpEnabled(false);
            // postavlja ikonu koja se prikazuje umjesto strelice prema nazad.
            // U ovom slučaju, postavljena je ikona hamburger iz drawable resursa (ic_hamburger).
            actionBar.setHomeAsUpIndicator(R.drawable.ic_hamburger);
            //vo omogućuje da se klikom na gumb 'home' na Toolbar-u
            // aktivira povratak na prethodni zaslon.
            actionBar.setHomeButtonEnabled(true);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // menu.clear();
        // koristimo ako je nasa arhitekrura takva da imamo jednu aktivnost
        // i vise fragmentaa gde svaki od njih ima svoj menu unutar toolbar-a

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int id = item.getItemId();
//        if (id == R.id.nav_reservations) {
//            Toast.makeText(HomeScreen.this, "Reservations", Toast.LENGTH_SHORT).show();
//            //FragmentTransition.to(ReservationsScreen.newInstance(),HomeScreen.this, false, HomeScreen.class.hashCode());
//        } else if (id == R.id.nav_account) {
//            Toast.makeText(HomeScreen.this, "Account", Toast.LENGTH_SHORT).show();
//        }else if (id == R.id.nav_notifications) {
//            Toast.makeText(HomeScreen.this, "Notifications", Toast.LENGTH_SHORT).show();
//        }
        // U ovoj metodi, prvo se pomoću Navigation komponente pronalazi NavController.
        // NavController je odgovoran za upravljanje navigacijom unutar aplikacije
        // koristeći Androidov servis za navigaciju.
        navController = Navigation.findNavController(this, R.id.fragment_nav_content_main);
        // Nakon toga, koristi se NavigationUI.onNavDestinationSelected(item, navController)
        // kako bi se omogućila integracija između MenuItem-a i odredišta unutar aplikacije
        // definisanih unutar navigacionog grafa (NavGraph).
        // Ova funkcija proverava da li je odabrana stavka izbornika povezana s nekim
        // odredištem unutar navigacionog grafa i pokreće tu navigaciju ako postoji
        // odgovarajuće podudaranje.
        return NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item);
    }
}