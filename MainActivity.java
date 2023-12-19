package com.example.balltrack_app;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_VIDEO_PICK = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button searchButton = findViewById(R.id.searchButton);
        Button loadButton = findViewById(R.id.loadButton);
        Button trackButton = findViewById(R.id.trackButton);

        searchButton.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com"));
            startActivity(browserIntent);
            trackButton.setVisibility(View.VISIBLE);
        });

        loadButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, REQUEST_VIDEO_PICK);
            trackButton.setVisibility(View.VISIBLE);
        });

        // Implement the track button functionality as needed
        trackButton.setOnClickListener(v -> {
            // Tracking functionality goes here
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_VIDEO_PICK && resultCode == RESULT_OK) {
            Uri selectedVideoUri = data.getData();
            // Do something with the selected video
        }
    }
}
