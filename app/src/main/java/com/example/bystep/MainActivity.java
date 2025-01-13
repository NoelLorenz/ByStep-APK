package com.example.bystep;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    Switch themeSwitch;
    ImageView bigLogo, logo, bg;
    LinearLayout new_toolbar;
    ImageButton web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        setupWindowInsets();
        setupDrawer();
        applyTheme();
        theme();
        imagesInitialize();
        updateImageForTheme();
        webButton();

        View headerView = navigationView.getHeaderView(0);
        EditText searchBar = headerView.findViewById(R.id.search_bar);
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterMenuItems(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    public void webButton (){
        web = findViewById(R.id.web);

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               confirmOnlineBystep();
            }
        });
    }

    public void onlineBystep() {
        String url = "https://mariano-shem.github.io/ByStep/";
        Intent redirect = new Intent(Intent.ACTION_VIEW);
        redirect.setData(Uri.parse(url));
        startActivity(redirect);
    }

    private void confirmOnlineBystep() {
        final Dialog dialog = new Dialog(this);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.getWindow().setDimAmount(0.5f);
        dialog.setContentView(R.layout.confirm_online_bystep);
        dialog.setCancelable(true);
        dialog.getWindow().setDimAmount(0.5f);
        Button btnCancel = dialog.findViewById(R.id.btnCancel);
        Button btnLeave = dialog.findViewById(R.id.btnLeave);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btnLeave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                onlineBystep();
            }
        });
        dialog.show();
    }
    private void filterMenuItems(String query) {
        NavigationView navigationView = findViewById(R.id.nav_view);
        Menu menu = navigationView.getMenu();

        for (int i = 0; i < menu.size(); i++) {
            MenuItem menuItem = menu.getItem(i);
            boolean isVisible = filterMenuItem(menuItem, query);
            menuItem.setVisible(isVisible);
        }
    }
    private boolean filterMenuItem(MenuItem menuItem, String query) {
        if (menuItem.hasSubMenu()) {
            boolean hasVisibleItems = false;
            SubMenu subMenu = menuItem.getSubMenu();

            for (int i = 0; i < subMenu.size(); i++) {
                MenuItem subMenuItem = subMenu.getItem(i);
                boolean isVisible = subMenuItem.getTitle().toString().toLowerCase().contains(query.toLowerCase());
                subMenuItem.setVisible(isVisible);
                if (isVisible) {
                    hasVisibleItems = true;
                }
            }

            menuItem.setVisible(hasVisibleItems);
            return hasVisibleItems;
        } else {
            return menuItem.getTitle().toString().toLowerCase().contains(query.toLowerCase());
        }
    }
    public void imagesInitialize(){
        logo = findViewById(R.id.logo);
        bg = findViewById(R.id.bgimage);
        bigLogo = findViewById(R.id.bigLogo);
    }
    public void updateImageForTheme(){
        boolean isDark = isDarkModeEnabled();
        if (isDark) {
            bg.setImageResource(R.drawable.bgblack);
            bigLogo.setImageResource(R.drawable.maintitle_gold);
        } else {
            bg.setImageDrawable(null);
            bg.setImageResource(R.drawable.bgblue);
            bigLogo.setImageDrawable(null);
            bigLogo.setImageResource(R.drawable.maintitle_blue);
        }
    }



    private void theme() {
        if (themeSwitch != null) {
            themeSwitch.setChecked(isDarkModeEnabled());

            themeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
                toggleTheme(isChecked);
                themeSwitch.clearFocus();
            });
        }
    }
    public void initialize() {
        drawerLayout = findViewById(R.id.drawer_layout_main);
        navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        themeSwitch = headerView.findViewById(R.id.themeSwitch);
        new_toolbar = findViewById(R.id.customToolbar);   }
    private void setupWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawer_layout_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void setupDrawer() {
        ImageButton navToggleButton = findViewById(R.id.navToggleButton);
        navToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    navToggleButton.setImageResource(R.drawable.menu_blue);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                    navToggleButton.setImageResource(R.drawable.menu_blue);
                }
            }
        });
        navigationView.setNavigationItemSelectedListener(this);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Intent intent = new Intent(MainActivity.this, Glossary.class);
        Map<Integer, String> itemToTargetViewIdMap = new HashMap<>();

        itemToTargetViewIdMap.put(R.id.navDoc1, "Document1");
        itemToTargetViewIdMap.put(R.id.navDoc2, "Document2");
        itemToTargetViewIdMap.put(R.id.navDoc3, "Document3");
        itemToTargetViewIdMap.put(R.id.navDoc4, "Document4");
        itemToTargetViewIdMap.put(R.id.navDoc5, "Document5");
        itemToTargetViewIdMap.put(R.id.navDoc6, "Document6");
        itemToTargetViewIdMap.put(R.id.navDoc7, "Document7");
        itemToTargetViewIdMap.put(R.id.navDoc8, "Document8");
        itemToTargetViewIdMap.put(R.id.navDoc9, "Document9");
        itemToTargetViewIdMap.put(R.id.navDoc10, "Document10");
        itemToTargetViewIdMap.put(R.id.navDoc11, "Document11");
        itemToTargetViewIdMap.put(R.id.navDoc12, "Document12");
        itemToTargetViewIdMap.put(R.id.navDoc13, "Document13");
        itemToTargetViewIdMap.put(R.id.navDoc14, "Document14");
        itemToTargetViewIdMap.put(R.id.navDoc15, "Document15");

        itemToTargetViewIdMap.put(R.id.navLoc1, "Location1");
        itemToTargetViewIdMap.put(R.id.navLoc2, "Location2");
        itemToTargetViewIdMap.put(R.id.navLoc3, "Location3");
        itemToTargetViewIdMap.put(R.id.navLoc4, "Location4");
        itemToTargetViewIdMap.put(R.id.navLoc5, "Location5");
        itemToTargetViewIdMap.put(R.id.navLoc6, "Location6");
        itemToTargetViewIdMap.put(R.id.navLoc7, "Location7");
        itemToTargetViewIdMap.put(R.id.navLoc8, "Location8");
        itemToTargetViewIdMap.put(R.id.navLoc9, "Location9");
        itemToTargetViewIdMap.put(R.id.navLoc10, "Location10");
        itemToTargetViewIdMap.put(R.id.navLoc11, "Location11");
        itemToTargetViewIdMap.put(R.id.navLoc12, "Location12");
        itemToTargetViewIdMap.put(R.id.navLoc13, "Location13");
        itemToTargetViewIdMap.put(R.id.navLoc14, "Location14");

        int itemId = menuItem.getItemId();
        String targetViewId = itemToTargetViewIdMap.get(itemId);

        if (targetViewId != null) {
            intent.putExtra("target_view_id", targetViewId);
            startActivity(intent);
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }
    public void goEnrollment(View view) {
        Intent go = new Intent(this, Enrollment.class);
        startActivity(go);
    }
    public void goClearance(View view) {
        Intent go = new Intent(this, Clearance.class);
        startActivity(go);
    }
    public void goExaminationPermit(View view) {
        Intent go = new Intent(this, Examination_Permit.class);
        startActivity(go);
    }
    public void goExcuseLetter(View view) {
        Intent go = new Intent(this, Excuse_Letter.class);
        startActivity(go);
    }
    public void goRenew(View view) {
        Intent go = new Intent(this, Renewal_of_ID.class);
        startActivity(go);
    }
    public void goToR(View view) {
        Intent go = new Intent(this, Transcript_of_Record.class);
        startActivity(go);
    }
    public void UserManual(View view) {
        Intent go = new Intent(this, usermanual.class);
        startActivity(go);
    }
}
