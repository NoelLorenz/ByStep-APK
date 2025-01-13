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

public class Transcript_of_Record extends BaseActivity {
    ImageView circle1, circle2, circle3, circle4, circle5, circle6, arrow1, arrow2, arrow3, arrow4, arrow5, arrow6;
    Button buttonN, buttonN2, buttonN3, buttonN4, buttonN5, buttonN6, buttonB2, buttonB3, buttonB4, buttonB5, buttonB6;
    CardView cardView, cardView2, cardView3, cardView4, cardView5, cardView6, cardView7;
    CardView card, card2, card3, card4, card5, card6, card7;
    LinearLayout layout, layout2, layout3, layout4, layout5, layout6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_transcript_of_record);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initializeViews();
        disable();
        hyperlink();
        setButtonListeners();
        imgUpdate();
    }
    public void hyperlink(){
        TextView torAsses = findViewById(R.id.torAndAssessor);
        String click1 = "Transcript of Records";
        String id1 = "Document15";
        String click2 = "Assessor’s Office";
        String id2 = "Location1";
        TextView buildingB = findViewById(R.id.torB);
        String click3 = "Building B";
        String id3 = "Location3";
        TextView buildingD = findViewById(R.id.torD);
        String click4 = "Building D";
        String id4 = "Location5";
        TextView hac = findViewById(R.id.torHAC);
        String click5 = "HAC’s Office";
        String id5 = "Location8";
        TextView evp = findViewById(R.id.torEVP);
        String click6 = "EVP’s Office";
        String id6 = "Location6";
        Drawable iconDrawable = AppCompatResources.getDrawable(this, R.drawable.link);
        makeTextClickableWithIcon(this, torAsses, click1, id1, click2, id2, iconDrawable);
        makeTextClickableWithIcon(this, buildingB, click3, id3,null, null, iconDrawable);
        makeTextClickableWithIcon(this, buildingD, click4, id4,null, null, iconDrawable);
        makeTextClickableWithIcon(this, hac, click5, id5,null, null, iconDrawable);
        makeTextClickableWithIcon(this, evp, click6, id6,null, null, iconDrawable);
    }
    public void imgUpdate(){
        ImageView imageView = findViewById(R.id.processBgTor);
        ImageView image = findViewById(R.id.torHeaderBg);
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
    private void disable(){
        cardView2.setEnabled(false);
        alpha(cardView2);
        cardView3.setEnabled(false);
        alpha(cardView3);
        cardView4.setEnabled(false);
        alpha(cardView4);
        cardView5.setEnabled(false);
        alpha(cardView5);
        cardView6.setEnabled(false);
        alpha(cardView6);
    }
    private void initializeViews(){
        arrow1 = findViewById(R.id.arrow1tor);
        arrow2 = findViewById(R.id.arrow2tor);
        arrow3 = findViewById(R.id.arrow3tor);
        arrow4 = findViewById(R.id.arrow4tor);
        arrow5 = findViewById(R.id.arrow5tor);
        arrow6 = findViewById(R.id.arrow6tor);
        circle1 = findViewById(R.id.circle1tor);
        circle2 = findViewById(R.id.circle2tor);
        circle3 = findViewById(R.id.circle3tor);
        circle4 = findViewById(R.id.circle4tor);
        circle5 = findViewById(R.id.circle5tor);
        circle6 = findViewById(R.id.circle6tor);
        buttonN = findViewById(R.id.next1tor);
        buttonN2 = findViewById(R.id.next2tor);
        buttonN3 = findViewById(R.id.next3tor);
        buttonN4 = findViewById(R.id.next4tor);
        buttonN5 = findViewById(R.id.next5tor);
        buttonN6 = findViewById(R.id.next6tor);
        buttonB2 = findViewById(R.id.back2tor);
        buttonB3 = findViewById(R.id.back3tor);
        buttonB4 = findViewById(R.id.back4tor);
        buttonB5 = findViewById(R.id.back5tor);
        buttonB6 = findViewById(R.id.back6tor);
        layout = findViewById(R.id.linear1tor);
        layout2 = findViewById(R.id.linear2tor);
        layout3 = findViewById(R.id.linear3tor);
        layout4 = findViewById(R.id.linear4tor);
        layout5 = findViewById(R.id.linear5tor);
        layout6 = findViewById(R.id.linear6tor);
        cardView = findViewById(R.id.step1tor);
        cardView2 = findViewById(R.id.step2tor);
        cardView3 = findViewById(R.id.step3tor);
        cardView4 = findViewById(R.id.step4tor);
        cardView5 = findViewById(R.id.step5tor);
        cardView6 = findViewById(R.id.step6tor);
        card = findViewById(R.id.firsttor);
        card2 = findViewById(R.id.secondtor);
        card3 = findViewById(R.id.thirdtor);
        card4 = findViewById(R.id.fourthtor);
        card5 = findViewById(R.id.fifthtor);
        card6 = findViewById(R.id.sixthtor);
        LayoutTransition transition = new LayoutTransition();
        transition.enableTransitionType(LayoutTransition.CHANGING);
        layout.setLayoutTransition(transition);
        layout2.setLayoutTransition(transition);
        layout3.setLayoutTransition(transition);
        layout4.setLayoutTransition(transition);
        layout5.setLayoutTransition(transition);
        layout6.setLayoutTransition(transition);
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
                if (!cardView5.isEnabled()) {
                    cardView5.setEnabled(true);
                    cardView5.setAlpha(1.0f);
                    cardView4.setEnabled(false);
                    alpha(cardView4);
                    card5.setVisibility(View.VISIBLE);
                    card4.setVisibility(View.GONE);
                    circle4.setImageResource(R.drawable.checked);
                    arrow4.setImageResource(R.drawable.arrowdown);
                } else if (cardView5.isEnabled()) {
                    card5.setVisibility(View.VISIBLE);
                    card4.setVisibility(View.GONE);
                    circle4.setImageResource(R.drawable.checked);
                    arrow4.setImageResource(R.drawable.arrowdown);
                }
            }
        });
        buttonN5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cardView6.isEnabled()) {
                    cardView6.setEnabled(true);
                    cardView6.setAlpha(1.0f);
                    cardView5.setEnabled(false);
                    alpha(cardView5);
                    card6.setVisibility(View.VISIBLE);
                    card5.setVisibility(View.GONE);
                    circle5.setImageResource(R.drawable.checked);
                    arrow5.setImageResource(R.drawable.arrowdown);
                } else if (cardView6.isEnabled()) {
                    card6.setVisibility(View.VISIBLE);
                    card5.setVisibility(View.GONE);
                    circle5.setImageResource(R.drawable.checked);
                    arrow5.setImageResource(R.drawable.arrowdown);
                }
            }
        });
        buttonN6.setOnClickListener(new View.OnClickListener() {
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
        buttonB5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card4.setVisibility(View.VISIBLE);
                card5.setVisibility(View.GONE);
                arrow4.setImageResource(R.drawable.arrowup);
                cardView4.setEnabled(true);
                cardView4.setAlpha(1.0f);
                cardView5.setEnabled(false);
                alpha(cardView5);
            }
        });
        buttonB6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card5.setVisibility(View.VISIBLE);
                card6.setVisibility(View.GONE);
                arrow5.setImageResource(R.drawable.arrowup);
                cardView5.setEnabled(true);
                cardView5.setAlpha(1.0f);
                cardView6.setEnabled(false);
                alpha(cardView6);
            }
        });
    }
    public void mainMenu (View view) {
        Intent go = new Intent(this, MainActivity.class);
        startActivity(go);
    }
}