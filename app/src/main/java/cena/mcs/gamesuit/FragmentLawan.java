package cena.mcs.gamesuit;

import static java.lang.Thread.sleep;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentLawan extends Fragment {
    private View ui;
    private ImageView ivLawan;
    private int tangan;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.ui = inflater.inflate(R.layout.fr_lawan, null, false);
        this.ivLawan = this.ui.findViewById(R.id.ivLawan);
        return ui;
    }

    @Override
    public void onResume() {
        super.onResume();
        Handler h = new Handler(Looper.getMainLooper());
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    int idx = (int) (Math.random() * 3);
                    h.post(new Runnable() {
                        @Override
                        public void run() {
                            switch (idx) {
                                case 0 :
                                    ivLawan.setImageResource(R.drawable.rock);
                                    break;
                                case 1 :
                                    ivLawan.setImageResource(R.drawable.paper);
                                    break;
                                default:
                                    ivLawan.setImageResource(R.drawable.scissor);
                            }
                        }
                    });
                    try {
                        tangan = idx;
                        sleep(50);
                    } catch (Exception e) {
                        break;
                    }
                }
            }
        });
        t.start();
    }


    public int getTangan() {
        return this.tangan;
    }
}
