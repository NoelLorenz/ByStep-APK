package com.example.bystep;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Splash_Activity extends BaseActivity {
    private static final int SPLASH_DISPLAY_LENGTH = 2000; // 2 seconds delay

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable EdgeToEdge mode for immersive experience
        EdgeToEdge.enable(this);

        // Set the layout for the splash screen
        setContentView(R.layout.activity_splash);

        // Apply window insets to adjust for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Delay before launching the MainActivity
        new Handler().postDelayed(() -> {
            Intent mainIntent = new Intent(Splash_Activity.this, MainActivity.class);
            startActivity(mainIntent);
            finish(); // Close SplashActivity to prevent returning to it
        }, SPLASH_DISPLAY_LENGTH);
    }
}
