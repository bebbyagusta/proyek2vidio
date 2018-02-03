package com.example.asus.proyeklagi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

public class Main3Activity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private static final int RECOVERY_REQUEST = 1;
    private static final String TAG = "Main3Activity";
    private YouTubePlayerView youTubeView;
    private ProgressDialog pDialog; // Progress Dialog
    public static final int progress_bar_type = 0;
    Button btndw, btnshare;
    String uriString;
    ImageView my_image;

    private static String file_url = "https://api.androidhive.info/progressdialog/hive.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubeView.initialize(config.YOUTUBE_API_KEY, this);

        btndw = (Button) findViewById(R.id.btndw);
        btnshare = (Button) findViewById(R.id.btnshare);

        btndw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Main3Activity.DownloadFileFromURL().execute(file_url);
            }
        });

        btnshare.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                uriString = "https://www.youtube.com/watch?v=fr1UwOIizMk";
                sharingIntent.putExtra(Intent.EXTRA_TEXT, uriString);
                sharingIntent.setPackage("com.facebook.katana");
                startActivity(sharingIntent);
            }
        });
    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        if (!wasRestored) {
            //player.cueVideo("fhWaJi1Hsfo"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
        }
    }

    @Override
    public void onInitializationFailure(Provider provider, YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(R.string.player_error), errorReason.toString());
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(config.YOUTUBE_API_KEY, this);
        }
    }

    protected Provider getYouTubePlayerProvider() {
        return youTubeView;
    }


    public class DownloadFileFromURL {
        public void execute(String file_url) {
        }
    }
}


