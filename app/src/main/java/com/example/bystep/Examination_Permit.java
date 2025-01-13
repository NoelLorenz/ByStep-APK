package com.example.bystep;

import android.animation.LayoutTransition;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.TestLooperManager;
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

public class Examination_Permit extends BaseActivity {
    ImageView circle1, circle2, circle3, arrow1, arrow2, arrow3;
    Button buttonN, buttonN2, buttonN3, buttonB2, buttonB3;
    CardView cardView, cardView2, cardView3;
    CardView card, card2, card3, card4;
    LinearLayout layout, layout2, layout3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_examination_permit);
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
        TextView assess = findViewById(R.id.assessorExams);
        String click1 = "Assessor’s Office";
        String id1 = "Location1";
        TextView buildingB = findViewById(R.id.buildingBExam);
        String click2 = "Building B";
        String id2 = "Location3";
        TextView blueForm = findViewById(R.id.blueFormExam);
        String click3 = "Blue Form (Student's Copy of Enrollment)";
        String id3 = "Document3";
        TextView buildingD = findViewById(R.id.buildingDExam);
        String click4 = "Building D";
        String id4 = "Location5";
        TextView treasurer = findViewById(R.id.treasurerExam);
        String click5 = "Building D";
        String id5 = "Location14";
        Drawable iconDrawable = AppCompatResources.getDrawable(this, R.drawable.link);
        makeTextClickableWithIcon(this, assess, click1, id1,null, null, iconDrawable);
        makeTextClickableWithIcon(this, buildingB, click2, id2,null, null, iconDrawable);
        makeTextClickableWithIcon(this, blueForm, click3, id3,null, null, iconDrawable);
        makeTextClickableWithIcon(this, buildingD, click4, id4,null, null, iconDrawable);
        makeTextClickableWithIcon(this, treasurer, click5, id5,null, null, iconDrawable);
    }
    public void imgUpdate(){
        ImageView imageView = findViewById(R.id.processBgExam);
        ImageView image = findViewById(R.id.examHeaderBg);
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
        CardView[] cardViews = { cardView2, cardView3};
        for (CardView cardView: cardViews) {
            gold(cardView);
        }
    }
    private void initializeViews(){
        arrow1 = findViewById(R.id.arrow1exam);
        arrow2 = findViewById(R.id.arrow2exam);
        arrow3 = findViewById(R.id.arrow3exam);
        circle1 = findViewById(R.id.circle1exam);
        circle2 = findViewById(R.id.circle2exam);
        circle3 = findViewById(R.id.circle3exam);
        buttonN = findViewById(R.id.next1exam);
        buttonN2 = findViewById(R.id.next2exam);
        buttonN3 = findViewById(R.id.next3exam);
        buttonB2 = findViewById(R.id.back2exam);
        buttonB3 = findViewById(R.id.back3exam);
        layout = findViewById(R.id.linear1exam);
        layout2 = findViewById(R.id.linear2exam);
        layout3 = findViewById(R.id.linear3exam);
        cardView = findViewById(R.id.step1exam);
        cardView2 = findViewById(R.id.step2exam);
        cardView3 = findViewById(R.id.step3exam);
        card = findViewById(R.id.firstexam);
        card2 = findViewById(R.id.secondexam);
        card3 = findViewById(R.id.thirdexam);
        LayoutTransition transition = new LayoutTransition();
        transition.enableTransitionType(LayoutTransition.CHANGING);
        layout.setLayoutTransition(transition);
        layout2.setLayoutTransition(transition);
        layout3.setLayoutTransition(transition);
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
    }
    public void mainMenu (View view) {
        Intent go = new Intent(this, MainActivity.class);
        startActivity(go);
    }
}