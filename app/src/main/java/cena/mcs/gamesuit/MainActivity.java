package cena.mcs.gamesuit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements IHost {

    private View ctLawan;
    private View ctBattle;
    private View ctPlayer;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.ctLawan = this.findViewById(R.id.frameLawan);
        this.ctBattle = this.findViewById(R.id.frameBattle);
        this.ctPlayer = this.findViewById(R.id.framePlayer);

        this.fm = getSupportFragmentManager();
        this.fm.beginTransaction()
                .add(R.id.frameLawan, new FragmentLawan(), "FLawan")
                .add(R.id.frameBattle, new FragmentBattle(), "FBattle")
                .add(R.id.framePlayer, new FragmentPlayer(), "FPlayer")
                .commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        FragmentPlayer fp = (FragmentPlayer) this.fm.findFragmentByTag("FPlayer");
        fp.setHost(this);
    }

    @Override
    public void suit(int tangan) {
        FragmentLawan frLawan = (FragmentLawan) getSupportFragmentManager()
                .findFragmentByTag("FLawan");
        FragmentBattle frBattle = (FragmentBattle) getSupportFragmentManager()
                .findFragmentByTag("FBattle");
        int tanganLawan = frLawan.getTangan();
        int tanganPlayer = tangan;
        frBattle.suit(tanganPlayer, tanganLawan);

        if (tanganPlayer == tanganLawan) {
            Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show();
        } else {
            if (tanganPlayer - tanganLawan == 1 || tanganPlayer - tanganLawan == -2) {
                Toast.makeText(this, "Menang", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Kalah", Toast.LENGTH_SHORT).show();
            }
        }
    }
}