package com.example.bystep;

import android.animation.LayoutTransition;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Renewal_of_ID extends BaseActivity {
    ImageView circle1, circle2, arrow1, arrow2;
    Button buttonN, buttonN2, buttonB2, buttonReg;
    CardView cardView, cardView2;
    CardView card, card2;
    LinearLayout layout, layout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_renewal_of_id);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initializeViews();
        disable();
        setButtonListeners();
        imgUpdate();
        idChoice();
        hyperlink();
    }
    public void hyperlink(){
        TextView affidavitID = findViewById(R.id.affidavitID);
        String click1 = "Affidavit of Loss";
        String id1 = "Document1";
        TextView buildingB = findViewById(R.id.buildingBId);
        String click2 = "Building B";
        String id2 = "Location3";
        TextView blue = findViewById(R.id.blueFormId);
        String click3 = "Blue Form (Student's Copy of Enrollment)";
        String id3 = "Document3";
        Drawable iconDrawable = AppCompatResources.getDrawable(this, R.drawable.link);
        makeTextClickableWithIcon(this, affidavitID, click1, id1,null, null, iconDrawable);
        makeTextClickableWithIcon(this, buildingB, click2, id2,null, null, iconDrawable);
        makeTextClickableWithIcon(this, blue, click3, id3,null, null, iconDrawable);
    }
    public void imgUpdate(){
        ImageView imageView = findViewById(R.id.processBgId);
        ImageView image = findViewById(R.id.idHeaderBg);
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
                dialog.dismiss(); // Close the dialog
                finish(); // Close the current activity
            }
        });
        dialog.show();
    }
    private void disable(){
        gold(cardView2);
    }
    private void initializeViews(){
        arrow1 = findViewById(R.id.arrow1id);
        arrow2 = findViewById(R.id.arrow2id);
        circle1 = findViewById(R.id.circle1id);
        circle2 = findViewById(R.id.circle2id);
        buttonN = findViewById(R.id.next1id);
        buttonN2 = findViewById(R.id.next2id);
        buttonB2 = findViewById(R.id.back2id);
        buttonReg = findViewById(R.id.endregister);
        layout = findViewById(R.id.linear1id);
        layout2 = findViewById(R.id.linear2id);
        cardView = findViewById(R.id.step1renew);
        cardView2 = findViewById(R.id.step2renew);
        card = findViewById(R.id.firstid);
        card2 = findViewById(R.id.secondid);
        LayoutTransition transition = new LayoutTransition();
        transition.enableTransitionType(LayoutTransition.CHANGING);
        layout.setLayoutTransition(transition);
        layout2.setLayoutTransition(transition);
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
        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmationDialog();
            }
        });
    }
    private void idChoice (){
        Button Register = findViewById(R.id.idRegister);
        Button Renew = findViewById(R.id.idRenew);
        ConstraintLayout reg = findViewById(R.id.registerpage);
        ConstraintLayout ren = findViewById(R.id.renewpage);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reg.setVisibility(View.VISIBLE);
                Renew.setBackgroundColor(ContextCompat.getColor(Renewal_of_ID.this, R.color.cardInside));
                Renew.setTextColor(ContextCompat.getColor(Renewal_of_ID.this, R.color.processWhite));
                ren.setVisibility(View.GONE);
                Register.setBackgroundColor(Color.TRANSPARENT);
                Register.setTextColor(ContextCompat.getColor(Renewal_of_ID.this, R.color.processDark));
            }
        });
        Renew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ren.setVisibility(View.VISIBLE);
                Register.setBackgroundColor(ContextCompat.getColor(Renewal_of_ID.this, R.color.cardInside));
                Renew.setTextColor(ContextCompat.getColor(Renewal_of_ID.this, R.color.processDark));
                reg.setVisibility(View.GONE);
                Renew.setBackgroundColor(Color.TRANSPARENT);
                Register.setTextColor(ContextCompat.getColor(Renewal_of_ID.this, R.color.processWhite));
            }
        });
    }
    public void mainMenu (View view) {
        Intent go = new Intent(this, MainActivity.class);
        startActivity(go);
    }
}