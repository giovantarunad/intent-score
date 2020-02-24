package id.putraprima.skorbola;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public static final String HOME_KEY = "hometeam";
    public static final String AWAY_KEY = "awayteam";
    private ImageView logohome;
    private ImageView logoaway;
    private EditText homeTeam;
    private EditText awayTeam;
    private static final int HOME_REQUEST_CODE = 1;
    private static final int AWAY_REQUEST_CODE = 2;
    private static final String TAG = MainActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homeTeam = findViewById(R.id.home_team);
        awayTeam = findViewById(R.id.away_team);
        logohome = findViewById(R.id.home_logo);
        logoaway = findViewById(R.id.away_logo);
    }
    //3. Ganti Logo Home Team
    public void handlehometeam(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, HOME_REQUEST_CODE);
    }
    //4. Ganti Logo Away Team
    public void handleawayteam(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, AWAY_REQUEST_CODE);
    }
    //5. Next Button Pindah Ke MatchActivity
    public void handlematch(View view) {
            Intent intent = new Intent(this, MatchActivity.class);
            String home = homeTeam.getText().toString();
            String away = awayTeam.getText().toString();
            intent.putExtra(HOME_KEY, home);
            intent.putExtra(AWAY_KEY, away);
            startActivity(intent);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == HOME_REQUEST_CODE) {
            if (data != null) {
                try {
                    Uri homeUri = data.getData();
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), homeUri);
                    logohome.setImageBitmap(bitmap);
                } catch (IOException e) {
                    Toast.makeText(this, "Can't load image", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, e.getMessage());
                }
            }
        }
        else if (requestCode == AWAY_REQUEST_CODE) {
            if (data != null) {
                try {
                    Uri awayUri = data.getData();
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), awayUri);
                    logoaway.setImageBitmap(bitmap);
                } catch (IOException e) {
                    Toast.makeText(this, "Can't load image", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, e.getMessage());
                }
            }
        }
    }
}