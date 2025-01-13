package com.example.bystep;

import android.animation.LayoutTransition;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Set;

public class Excuse_Letter extends BaseActivity {
    ImageView circle1, circle2, circle3, circle4, arrow1, arrow2, arrow3, arrow4;
    Button buttonN, buttonN2, buttonN3, buttonN4, buttonB2, buttonB3, buttonB4;
    CardView cardView, cardView2, cardView3, cardView4;
    CardView card, card2, card3, card4;
    LinearLayout layout, layout2, layout3, layout4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_excuse_letter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initializeViews();
        disable();
        setButtonListeners();
        imgUpdate();
        hyperlink();
    }
    public void hyperlink(){
        TextView excuseGuidance = findViewById(R.id.excuseSlipExcuse_Guidane);
        String click1 = "excuse slip";
        String id1 = "Document7";
        String click2 = "Guidance Office";
        String id2 = "Location7";
        TextView buildingA = findViewById(R.id.buildingAExcuse);
        String click3 = "Building A";
        String id3 = "Location2";
        TextView blueForm = findViewById(R.id.blueFormExcuse);
        String click4 = "Blue Form (Student's Copy of Enrollment)";
        String id4 = "Document3";
        Drawable iconDrawable = AppCompatResources.getDrawable(this, R.drawable.link);
        makeTextClickableWithIcon(this, excuseGuidance, click1, id1,click2, id2, iconDrawable);
        makeTextClickableWithIcon(this, buildingA, click3, id3,null, null, iconDrawable);
        makeTextClickableWithIcon(this, blueForm, click4, id4,null, null, iconDrawable);
    }
    public void imgUpdate(){
        ImageView imageView = findViewById(R.id.processBgExcuse);
        ImageView image = findViewById(R.id.excuseHeaderBg);
        updateProcessBG(imageView, R.drawable.bgblack, R.drawable.bgblue);
        updateImgHeader(image, R.drawable.processheaddark, R.drawable.processhead);
    }
    private void showConfirmationDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.getWindow().setDimAmount(0.5f);
        dialog.setContentView(R.layout.confirm_leaving);
        dialog.setCancelable(true);
        dialog.getWindow().setDimAmount(0.5f);
        Button btnCancel = dialog.findViewById(R.id.btnCancel);
        Button btnLeave = dialog.findViewById(R.id.btnLeave);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btnLeave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                finish();
            }
        });
        dialog.show();
    }
    private void disable() {
        CardView[] cardViews = { cardView2, cardView3, cardView4};
        for (CardView cardView: cardViews) {
            gold(cardView);
        }
    }
    private void initializeViews(){
        arrow1 = findViewById(R.id.arrow1excuse);
        arrow2 = findViewById(R.id.arrow2excuse);
        arrow3 = findViewById(R.id.arrow3excuse);
        arrow4 = findViewById(R.id.arrow4excuse);
        circle1 = findViewById(R.id.circle1excuse);
        circle2 = findViewById(R.id.circle2excuse);
        circle3 = findViewById(R.id.circle3excuse);
        circle4 = findViewById(R.id.circle4excuse);
        buttonN = findViewById(R.id.next1excuse);
        buttonN2 = findViewById(R.id.next2excuse);
        buttonN3 = findViewById(R.id.next3excuse);
        buttonN4 = findViewById(R.id.next4excuse);
        buttonB2 = findViewById(R.id.back2excuse);
        buttonB3 = findViewById(R.id.back3excuse);
        buttonB4 = findViewById(R.id.back4excuse);
        layout = findViewById(R.id.linear1excuse);
        layout2 = findViewById(R.id.linear2excuse);
        layout3 = findViewById(R.id.linear3excuse);
        layout4 = findViewById(R.id.linear4excuse);
        cardView = findViewById(R.id.step1excuse);
        cardView2 = findViewById(R.id.step2excuse);
        cardView3 = findViewById(R.id.step3excuse);
        cardView4 = findViewById(R.id.step4excuse);
        card = findViewById(R.id.firstexcuse);
        card2 = findViewById(R.id.secondexcuse);
        card3 = findViewById(R.id.thirdexcuse);
        card4 = findViewById(R.id.fourthexcuse);
        LayoutTransition transition = new LayoutTransition();
        transition.enableTransitionType(LayoutTransition.CHANGING);
        layout.setLayoutTransition(transition);
        layout2.setLayoutTransition(transition);
        layout3.setLayoutTransition(transition);
        layout4.setLayoutTransition(transition);
    }
    private void setButtonListeners(){
        buttonN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cardView2.isEnabled()) {
                    cardView2.setEnabled(true);
                    cardView2.setAlpha(1.0f);
                    cardView.setEnabled(false);
                    alpha(cardView);
                    card2.setVisibility(View.VISIBLE);
                    card.setVisibility(View.GONE);
                    circle1.setImageResource(R.drawable.checked);
                    arrow1.setImageResource(R.drawable.arrowdown);
                } else if (cardView2.isEnabled()){
                    card2.setVisibility(View.VISIBLE);
                    card.setVisibility(View.GONE);
                    circle1.setImageResource(R.drawable.checked);
                    arrow1.setImageResource(R.drawable.arrowdown);
                }
            }
        });
        buttonN2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cardView3.isEnabled()) {
                    cardView3.setEnabled(true);
                    cardView3.setAlpha(1.0f);
                    cardView2.setEnabled(false);
                    alpha(cardView2);
                    card3.setVisibility(View.VISIBLE);
                    card2.setVisibility(View.GONE);
                    circle2.setImageResource(R.drawable.checked);
                    arrow2.setImageResource(R.drawable.arrowdown);
                } else if (cardView3.isEnabled()) {
                    card3.setVisibility(View.VISIBLE);
                    card2.setVisibility(View.GONE);
                    circle2.setImageResource(R.drawable.checked);
                    arrow2.setImageResource(R.drawable.arrowdown);
                }
            }
        });
        buttonN3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cardView4.isEnabled()) {
                    cardView4.setEnabled(true);
                    cardView4.setAlpha(1.0f);
                    cardView3.setEnabled(false);
                    alpha(cardView3);
                    card4.setVisibility(View.VISIBLE);
                    card3.setVisibility(View.GONE);
                    circle3.setImageResource(R.drawable.checked);
                    arrow3.setImageResource(R.drawable.arrowdown);
                } else if (cardView4.isEnabled()) {
                    card4.setVisibility(View.VISIBLE);
                    card3.setVisibility(View.GONE);
                    circle3.setImageResource(R.drawable.checked);
                    arrow3.setImageResource(R.drawable.arrowdown);
                }
            }
        });
        buttonN4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmationDialog();
                }
        });
        buttonB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card.setVisibility(View.VISIBLE);
                card2.setVisibility(View.GONE);
                arrow1.setImageResource(R.drawable.arrowup);
                cardView.setEnabled(true);
                cardView.setAlpha(1.0f);
                cardView2.setEnabled(false);
                alpha(cardView2);
            }
        });
        buttonB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card2.setVisibility(View.VISIBLE);
                card3.setVisibility(View.GONE);
                arrow2.setImageResource(R.drawable.arrowup);
                cardView2.setEnabled(true);
                cardView2.setAlpha(1.0f);
                cardView3.setEnabled(false);
                alpha(cardView3);
            }
        });
        buttonB4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card3.setVisibility(View.VISIBLE);
                card4.setVisibility(View.GONE);
                arrow3.setImageResource(R.drawable.arrowup);
                cardView3.setEnabled(true);
                cardView3.setAlpha(1.0f);
                cardView4.setEnabled(false);
                alpha(cardView4);
            }
        });
    }
    public void mainMenu (View view) {
        Intent go = new Intent(this, MainActivity.class);
        startActivity(go);
    }
}