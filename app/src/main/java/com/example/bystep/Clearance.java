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

import androidx.activity.EdgeToEdge;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Clearance extends BaseActivity {
    ImageView circle1, circle2, circle3, circle4, circle5, circle6, circle7, circle8, circle9, circle10,  circle11,  circle12,
            arrow1, arrow2, arrow3, arrow4, arrow5, arrow6, arrow7, arrow8, arrow9, arrow10, arrow11, arrow12;
    Button buttonN, buttonN2, buttonN3, buttonN4, buttonN5, buttonN6, buttonN7, buttonN8, buttonN9, buttonN10, buttonN11, buttonN12,
            buttonB2, buttonB3, buttonB4, buttonB5, buttonB6, buttonB7, buttonB8, buttonB9, buttonB10, buttonB11, buttonB12;
    CardView cardView, cardView2, cardView3, cardView4, cardView5, cardView6, cardView7, cardView8, cardView9, cardView10, cardView11, cardView12 ;
    CardView card, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12;
    LinearLayout layout, layout2, layout3, layout4, layout5, layout6, layout7, layout8, layout9, layout10, layout11, layout12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_clearance);
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
        TextView clearanceGrade = findViewById(R.id.clearanceC_finalGrades);
        String click1 = "Clearance";
        String id1 = "Document4";
        TextView ssc = findViewById(R.id.sscClear);
        String click6 = "SSC Office";
        String id6 = "Location13";
        TextView buildingB = findViewById(R.id.buildingBClear);
        String click7 = "Building B";
        String id7 = "Location3";
        TextView buildingA = findViewById(R.id.buildingAClear);
        String click8 = "Building A";
        String id8 = "Location2";
        TextView buildingC = findViewById(R.id.buildingCClear);
        String click9= "Building C";
        String id9 = "Location4";
        TextView libraryCard = findViewById(R.id.libraryCard);
        String click10 = "Library Card";
        String id10 = "Document11";
        TextView id = findViewById(R.id.idClear);
        String click11 = "School ID";
        String id11 = "Document12";
        Drawable iconDrawable = AppCompatResources.getDrawable(this, R.drawable.link);
        makeTextClickableWithIcon(this, clearanceGrade, click1, id1, null, null, iconDrawable);
        makeTextClickableWithIcon(this, ssc, click6, id6,null, null, iconDrawable);
        makeTextClickableWithIcon(this, buildingB, click7, id7,null, null, iconDrawable);
        makeTextClickableWithIcon(this, buildingA, click8, id8,null, null, iconDrawable);
        makeTextClickableWithIcon(this, buildingC, click9, id9,null, null, iconDrawable);
        makeTextClickableWithIcon(this, libraryCard, click10, id10,null, null, iconDrawable);
        makeTextClickableWithIcon(this, id, click11, id11,null, null, iconDrawable);
    }
    public void imgUpdate(){
        ImageView imageView = findViewById(R.id.processBgClearance);
        ImageView image = findViewById(R.id.clearanceHeaderBg);
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
        CardView[] cardViews = { cardView3, cardView4, cardView5, cardView6, cardView7, cardView8, cardView9, cardView10, cardView11, cardView12};
        for (CardView cardView: cardViews) {
            gold(cardView);
        }
    }
    private void initializeViews(){
        arrow1 = findViewById(R.id.arrow1clear);
        arrow2 = findViewById(R.id.arrow2clear);
        arrow3 = findViewById(R.id.arrow3clear);
        arrow4 = findViewById(R.id.arrow4clear);
        arrow5 = findViewById(R.id.arrow5clear);
        arrow6 = findViewById(R.id.arrow6clear);
        arrow7 = findViewById(R.id.arrow7clear);
        arrow8 = findViewById(R.id.arrow8clear);
        arrow9 = findViewById(R.id.arrow9clear);
        arrow10 = findViewById(R.id.arrow10clear);
        arrow11 = findViewById(R.id.arrow11clear);
        arrow12 = findViewById(R.id.arrow12clear);
        circle1 = findViewById(R.id.circle1clear);
        circle2 = findViewById(R.id.circle2clear);
        circle3 = findViewById(R.id.circle3clear);
        circle4 = findViewById(R.id.circle4clear);
        circle5 = findViewById(R.id.circle5clear);
        circle6 = findViewById(R.id.circle6clear);
        circle7 = findViewById(R.id.circle7clear);
        circle8 = findViewById(R.id.circle8clear);
        circle9 = findViewById(R.id.circle9clear);
        circle10 = findViewById(R.id.circle10clear);
        circle11 = findViewById(R.id.circle11clear);
        circle12 = findViewById(R.id.circle12clear);
        buttonN = findViewById(R.id.next1clear);
        buttonN2 = findViewById(R.id.next2clear);
        buttonN3 = findViewById(R.id.next3clear);
        buttonN4 = findViewById(R.id.next4clear);
        buttonN5 = findViewById(R.id.next5clear);
        buttonN6 = findViewById(R.id.next6clear);
        buttonN7 = findViewById(R.id.next7clear);
        buttonN8 = findViewById(R.id.next8clear);
        buttonN9 = findViewById(R.id.next9clear);
        buttonN10 = findViewById(R.id.next10clear);
        buttonN11 = findViewById(R.id.next11clear);
        buttonN12 = findViewById(R.id.next12clear);
        buttonB2 = findViewById(R.id.back2clear);
        buttonB3 = findViewById(R.id.back3clear);
        buttonB4 = findViewById(R.id.back4clear);
        buttonB5 = findViewById(R.id.back5clear);
        buttonB6 = findViewById(R.id.back6clear);
        buttonB7 = findViewById(R.id.back7clear);
        buttonB8 = findViewById(R.id.back8clear);
        buttonB9 = findViewById(R.id.back9clear);
        buttonB10 = findViewById(R.id.back10clear);
        buttonB11 = findViewById(R.id.back11clear);
        buttonB12 = findViewById(R.id.back12clear);
        layout = findViewById(R.id.linear1clear);
        layout2 = findViewById(R.id.linear2clear);
        layout3 = findViewById(R.id.linear3clear);
        layout4 = findViewById(R.id.linear4clear);
        layout5 = findViewById(R.id.linear5clear);
        layout6 = findViewById(R.id.linear6clear);
        layout7 = findViewById(R.id.linear7clear);
        layout8 = findViewById(R.id.linear8clear);
        layout9 = findViewById(R.id.linear9clear);
        layout10 = findViewById(R.id.linear10clear);
        layout11 = findViewById(R.id.linear11clear);
        layout12 = findViewById(R.id.linear12clear);
        cardView = findViewById(R.id.step1clear);
        cardView3 = findViewById(R.id.step3clear);
        cardView4 = findViewById(R.id.step4clear);
        cardView5 = findViewById(R.id.step5clear);
        cardView6 = findViewById(R.id.step6clear);
        cardView7 = findViewById(R.id.step7clear);
        cardView8 = findViewById(R.id.step8clear);
        cardView9 = findViewById(R.id.step9clear);
        cardView10 = findViewById(R.id.step10clear);
        cardView11 = findViewById(R.id.step11clear);
        cardView12 = findViewById(R.id.step12clear);
        card = findViewById(R.id.firstclear);
        card2 = findViewById(R.id.secondclear);
        card3 = findViewById(R.id.thirdclear);
        card4 = findViewById(R.id.fourthclear);
        card5 = findViewById(R.id.fifthclear);
        card6 = findViewById(R.id.sixthclear);
        card7 = findViewById(R.id.seventhclear);
        card8 = findViewById(R.id.eighthclear);
        card9 = findViewById(R.id.ninthclear);
        card10 = findViewById(R.id.tenthclear);
        card11 = findViewById(R.id.eleventhclear);
        card12 = findViewById(R.id.twelvethclear);
        LayoutTransition transition = new LayoutTransition();
        transition.enableTransitionType(LayoutTransition.CHANGING);
        layout.setLayoutTransition(transition);
        layout3.setLayoutTransition(transition);
        layout4.setLayoutTransition(transition);
        layout5.setLayoutTransition(transition);
        layout6.setLayoutTransition(transition);
        layout7.setLayoutTransition(transition);
        layout8.setLayoutTransition(transition);
        layout9.setLayoutTransition(transition);
        layout10.setLayoutTransition(transition);
        layout11.setLayoutTransition(transition);
        layout12.setLayoutTransition(transition);
    }
    private void setButtonListeners(){
        buttonN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cardView3.isEnabled()) {
                    cardView3.setEnabled(true);
                    cardView3.setAlpha(1.0f);
                    cardView.setEnabled(false);
                    alpha(cardView);
                    card3.setVisibility(View.VISIBLE);
                    card.setVisibility(View.GONE);
                    circle1.setImageResource(R.drawable.checked);
                    arrow1.setImageResource(R.drawable.arrowdown);
                } else if (cardView3.isEnabled()) {
                    card3.setVisibility(View.VISIBLE);
                    card.setVisibility(View.GONE);
                    circle1.setImageResource(R.drawable.checked);
                    arrow1.setImageResource(R.drawable.arrowdown);
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
                if (!cardView7.isEnabled()) {

                    cardView7.setEnabled(true);
                    cardView7.setAlpha(1.0f);
                    cardView6.setEnabled(false);
                    alpha(cardView6);
                    card7.setVisibility(View.VISIBLE);
                    card6.setVisibility(View.GONE);
                    circle6.setImageResource(R.drawable.checked);
                    arrow6.setImageResource(R.drawable.arrowdown);
                } else if (cardView7.isEnabled()) {
                    card7.setVisibility(View.VISIBLE);
                    card6.setVisibility(View.GONE);
                    circle6.setImageResource(R.drawable.checked);
                    arrow6.setImageResource(R.drawable.arrowdown);
                }
            }
        });
        buttonN7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cardView8.isEnabled()) {
                    cardView8.setEnabled(true);
                    cardView8.setAlpha(1.0f);
                    cardView7.setEnabled(false);
                    alpha(cardView7);
                    card8.setVisibility(View.VISIBLE);
                    card7.setVisibility(View.GONE);
                    circle7.setImageResource(R.drawable.checked);
                    arrow7.setImageResource(R.drawable.arrowdown);
                } else if (cardView8.isEnabled()) {
                    card8.setVisibility(View.VISIBLE);
                    card7.setVisibility(View.GONE);
                    circle7.setImageResource(R.drawable.checked);
                    arrow7.setImageResource(R.drawable.arrowdown);
                }
            }
        });
        buttonN8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cardView10.isEnabled()) {
                    cardView10.setEnabled(true);
                    cardView10.setAlpha(1.0f);
                    cardView8.setEnabled(false);
                    alpha(cardView8);
                    card10.setVisibility(View.VISIBLE);
                    card8.setVisibility(View.GONE);
                    circle8.setImageResource(R.drawable.checked);
                    arrow8.setImageResource(R.drawable.arrowdown);
                } else if (cardView10.isEnabled()) {
                    card10.setVisibility(View.VISIBLE);
                    card8.setVisibility(View.GONE);
                    circle8.setImageResource(R.drawable.checked);
                    arrow8.setImageResource(R.drawable.arrowdown);
                }
            }
        });
        buttonN10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cardView11.isEnabled()) {
                    cardView11.setEnabled(true);
                    cardView11.setAlpha(1.0f);
                    cardView10.setEnabled(false);
                    alpha(cardView10);
                    card11.setVisibility(View.VISIBLE);
                    card10.setVisibility(View.GONE);
                    circle10.setImageResource(R.drawable.checked);
                    arrow10.setImageResource(R.drawable.arrowdown);
                } else if (cardView11.isEnabled()) {
                    card11.setVisibility(View.VISIBLE);
                    card10.setVisibility(View.GONE);
                    circle10.setImageResource(R.drawable.checked);
                    arrow10.setImageResource(R.drawable.arrowdown);
                }
            }
        });
        buttonN11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cardView9.isEnabled()) {
                    cardView9.setEnabled(true);
                    cardView9.setAlpha(1.0f);
                    cardView11.setEnabled(false);
                    alpha(cardView11);
                    card9.setVisibility(View.VISIBLE);
                    card11.setVisibility(View.GONE);
                    circle11.setImageResource(R.drawable.checked);
                    arrow11.setImageResource(R.drawable.arrowdown);
                } else if (cardView9.isEnabled()) {
                    card9.setVisibility(View.VISIBLE);
                    card11.setVisibility(View.GONE);
                    circle11.setImageResource(R.drawable.checked);
                    arrow11.setImageResource(R.drawable.arrowdown);
                }
            }
        });
        buttonN9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cardView12.isEnabled()) {
                    cardView12.setEnabled(true);
                    cardView12.setAlpha(1.0f);
                    cardView9.setEnabled(false);
                    alpha(cardView9);

                    card12.setVisibility(View.VISIBLE);
                    card9.setVisibility(View.GONE);
                    circle9.setImageResource(R.drawable.checked);
                    arrow9.setImageResource(R.drawable.arrowdown);
                } else if (cardView12.isEnabled()) {
                    card12.setVisibility(View.VISIBLE);
                    card9.setVisibility(View.GONE);
                    circle9.setImageResource(R.drawable.checked);
                    arrow9.setImageResource(R.drawable.arrowdown);
                }
            }
        });
        buttonN12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             showConfirmationDialog();
            }
        });

        buttonB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card.setVisibility(View.VISIBLE);
                card3.setVisibility(View.GONE);
                arrow1.setImageResource(R.drawable.arrowup);
                cardView.setEnabled(true);
                cardView.setAlpha(1.0f);
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
        buttonB7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card6.setVisibility(View.VISIBLE);
                card7.setVisibility(View.GONE);
                arrow6.setImageResource(R.drawable.arrowup);
                cardView6.setEnabled(true);
                cardView6.setAlpha(1.0f);
                cardView7.setEnabled(false);
                alpha(cardView7);
            }
        });
        buttonB8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card7.setVisibility(View.VISIBLE);
                card8.setVisibility(View.GONE);
                arrow7.setImageResource(R.drawable.arrowup);
                cardView7.setEnabled(true);
                cardView7.setAlpha(1.0f);
                cardView8.setEnabled(false);
                alpha(cardView8);
            }
        });
        buttonB10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card8.setVisibility(View.VISIBLE);
                card10.setVisibility(View.GONE);
                arrow8.setImageResource(R.drawable.arrowup);
                cardView8.setEnabled(true);
                cardView8.setAlpha(1.0f);
                cardView10.setEnabled(false);
                alpha(cardView10);
            }
        });
        buttonB11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card10.setVisibility(View.VISIBLE);
                card11.setVisibility(View.GONE);
                arrow10.setImageResource(R.drawable.arrowup);
                cardView10.setEnabled(true);
                cardView10.setAlpha(1.0f);
                cardView11.setEnabled(false);
                alpha(cardView11);
            }
        });
        buttonB9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card11.setVisibility(View.VISIBLE);
                card9.setVisibility(View.GONE);
                arrow11.setImageResource(R.drawable.arrowup);
                cardView11.setEnabled(true);
                cardView11.setAlpha(1.0f);
                cardView9.setEnabled(false);
                alpha(cardView9);
            }
        });
        buttonB12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card9.setVisibility(View.VISIBLE);
                card12.setVisibility(View.GONE);
                arrow9.setImageResource(R.drawable.arrowup);
                cardView9.setEnabled(true);
                cardView9.setAlpha(1.0f);
                cardView12.setEnabled(false);
                alpha(cardView12);
            }
        });
    }
    public void mainMenu (View view) {
        Intent go = new Intent(this, MainActivity.class);
        startActivity(go);
    }
}

