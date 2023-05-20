package cena.mcs.gamesuit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentBattle extends Fragment {
    private View ui;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.ui = inflater.inflate(R.layout.fr_battle, null,false);
        return ui;
//        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void suit(int tanganPlayer, int tanganLawan) {
        ImageView ivLawan = this.ui.findViewById(R.id.ivBattleLawan);
        ImageView ivPlayer = this.ui.findViewById(R.id.ivBattlePlayer);
        ivLawan.setImageResource(FragmentBattle.iconTangan(tanganLawan));
        ivPlayer.setImageResource(FragmentBattle.iconTangan(tanganPlayer));
    }

    public static int iconTangan(int tangan) {
        switch (tangan) {
            case 0 : return R.drawable.rock;
            case 1 : return R.drawable.paper;
            default : return R.drawable.scissor;
        }
    }
}
