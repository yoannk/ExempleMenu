package com.example.exemplemenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.exemplemenu.fragments.EtoileFragment;
import com.example.exemplemenu.fragments.ItemFragment;
import com.example.exemplemenu.fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

    Context context;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        Toolbar toolbar = findViewById(R.id.toolbar);

        // on remplace l'actionbar par notre toolbar
        setSupportActionBar(toolbar);

        // on supprime le titre de l'application
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // j'ajoute un logo(drawable) dans la toolbar
        toolbar.setLogo(R.drawable.ic_etoile);

        // je definis le titre de la toolbar
        toolbar.setTitle("Test");

        toolbar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MainFragment mainFragment = new MainFragment();
                replaceFragment(mainFragment, "mainFragment");
            }
        });

        // Gestion des fragments
        fragmentManager = getFragmentManager();

        MainFragment mainFragment = new MainFragment();
        replaceFragment(mainFragment, "mainFragment");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // On associe un menu à notre activity
        getMenuInflater().inflate(R.menu.mnu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.annuler_click:
                Toast.makeText(context, "Coucou", Toast.LENGTH_LONG).show();
                break;
            case R.id.etoile_click:
                EtoileFragment etoileFragment = new EtoileFragment();
                replaceFragment(etoileFragment, "EtoileFragment");
                break;
            case R.id.item_click:
                ItemFragment itemFragment = new ItemFragment();
                replaceFragment(itemFragment, "ItemFragment");
                break;
        }

        return true;
    }

    private void replaceFragment(android.app.Fragment fragment, String nomFragment) {
        // Gestion des fragments
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frmMain, fragment);
        fragmentTransaction.addToBackStack(nomFragment);
        fragmentTransaction.commit();
    }
}
