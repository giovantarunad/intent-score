package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MatchActivity extends AppCompatActivity {

    private TextView hometext;
    private TextView awaytext;
    private TextView homeScore;
    private TextView awayScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        //TODO
        hometext=findViewById(R.id.txt_home);
        awaytext=findViewById(R.id.txt_away);
        homeScore = findViewById(R.id.score_home);
        awayScore = findViewById(R.id.score_away);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String home = extras.getString(MainActivity.HOME_KEY);
            String away = extras.getString(MainActivity.AWAY_KEY);
        }
        //1.Menampilkan detail match sesuai data dari main activity
        //2.Tombol add score menambahkan satu angka dari angka 0, setiap kali di tekan
        //3.Tombol Cek Result menghitung pemenang dari kedua tim dan mengirim nama pemenang ke ResultActivity, jika seri di kirim text "Draw"
    }

    public void handleresult(View view) {
        Intent intent =  new Intent(this, ResultActivity.class);
        startActivity(intent);
    }
}