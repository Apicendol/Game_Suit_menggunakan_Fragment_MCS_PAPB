package cena.mcs.gamesuit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentPlayer extends Fragment implements View.OnClickListener {
    private IHost host;
    private View ui;
    private View rock;
    private View paper;
    private View scissor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.ui = inflater.inflate(R.layout.fr_player, null, false);
        this.rock = this.ui.findViewById(R.id.ivRock);
        this.paper = this.ui.findViewById(R.id.ivPaper);
        this.scissor = this.ui.findViewById(R.id.ivScissor);

        rock.setOnClickListener(this);
        paper.setOnClickListener(this);
        scissor.setOnClickListener(this);
        return ui;
//        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivRock:
                this.host.suit(0);
                break;
            case R.id.ivPaper:
                this.host.suit(1);
                break;
            case R.id.ivScissor:
                this.host.suit(2);
                break;
        }
    }

    public void setHost(IHost host) {
        this.host = host;
    }
}
