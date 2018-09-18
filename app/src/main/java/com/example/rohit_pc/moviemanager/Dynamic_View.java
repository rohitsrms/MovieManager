package com.example.rohit_pc.moviemanager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Dynamic_View extends AppCompatActivity {
int countTextview=0;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic__view);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        changeBackgroundcolor(linearLayout);
        addNewTextView(linearLayout);
    }

    private void addNewTextView(LinearLayout linearLayout) {
        TextView textView=new TextView(this);
        textView.setText(""+countTextview++);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        linearLayout.addView(textView);
    }

    private void changeBackgroundcolor(LinearLayout linearLayout) {
        Random rnd=new Random();
        int color= Color.argb(255,rnd.nextInt(256),rnd.nextInt(256),rnd.nextInt(256));
        linearLayout.setBackgroundColor(color);

    }
}
