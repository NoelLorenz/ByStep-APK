package com.example.bystep;

import static java.security.AccessController.getContext;
import androidx.core.content.ContextCompat;

import android.animation.LayoutTransition;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Enrollment extends BaseActivity {

   ImageView circle1, circle, circle2, circle3, circle4, circle5, circle6, circle7, circle8, circle9, circle10,
        arrow1, arrow, arrow2, arrow3, arrow4, arrow5, arrow6, arrow7, arrow8, arrow9, arrow10,
        arrow1old, arrow3old, arrow4old, arrow6old, arrow7old,
        arrow1new, arrow6new, arrow7new,
        arrow1transferress;

    Button buttonN, buttonN1, buttonN2, buttonN3, buttonN4, buttonN5, buttonN6, buttonN7, buttonN8, buttonN9, buttonN10,
           buttonB1, buttonB2, buttonB3, buttonB4, buttonB5, buttonB6, buttonB7, buttonB8, buttonB9, buttonB10;
    CardView cardView, cardView1, cardView2, cardView3, cardView4, cardView5, cardView6, cardView7, cardView8, cardView9, cardView10,
            old1, old6, old7, old11, old44, old66, old77,
            new1, new6, new7, new11, new66, new77, transfer1, transfer11 ;
    CardView card, card1, card2, card3, card4, card5, card6, card7, card8, card9, card10;
    LinearLayout layout, layout1, layout2, layout3, layout4, layout5, layout6, layout7, layout8, layout9, layout10,
    oldlayout1, oldlayout4, oldlayout6, oldlayout7, newlayout1, newlayout6, newlayout7, transfereeslayout1;

    TextView oldText1, newText1, transferText1, oldText3, oldText4 , oldText6, newText6, oldText7, newText7;
    LinearLayout olderLayout1, newerLayout1, transferLayout1, olderLayout4, olderLayout6, newerLayout6, olderLayout7, newerLayout7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_enrollment);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initializeViews();
        disable();
        setButtonListeners();
        imgUpdate();
        hyperLink();
    }
    public void imgUpdate(){
        ImageView imageView = findViewById(R.id.processBgEnroll);
        ImageView image = findViewById(R.id.enrollHeaderBG);

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
    public void hyperLink() {
        TextView enrollmentform = findViewById(R.id.enrollmentFormE);
        String clickableText = "enrollment form";
        String cardId = "Document5";
        TextView clearanceform = findViewById(R.id.clearanceE_grades);
        String clickableText1 = "Clearance";
        String cardId1 = "Document4";
        String clickableText2 = "Final Grades";
        String cardId2 = "Document8";
        TextView reportcard = findViewById(R.id.highschoolcardE);
        String clickableText3 = "Senior High School Report Card (Form 138)";
        String cardId3 = "Document13";
        TextView gmchar = findViewById(R.id.goodmoralE);
        String clickableText4 = "Good Moral Character";
        String cardId4 = "Document9";
        TextView birth = findViewById(R.id.birthcertificateE);
        String clickableText5 = "Birth Certificate";
        String cardId5 = "Document2";
        TextView honorable = findViewById(R.id.honorableE);
        String clickableText6 = "Honorable Dismissal ";
        String cardId6 = "Document10";
        TextView gmchar2 = findViewById(R.id.goodmoral2E);
        String clickableText7 = "Good Moral Character";
        String cardId7 = "Document9";
        TextView birthCert = findViewById(R.id.birthcertificate2E);
        String clickableText8 = "Birth Certificate";
        String cardId8 = "Document2";
        TextView registrar = findViewById(R.id.registrarE);
        String clickableText9 = "Registrar";
        String cardId9 = "Location11";
        TextView buildingD = findViewById(R.id.buildingDE);
        String clickableText10 = "Building D";
        String cardId10 = "Location5";
        TextView idE = findViewById(R.id.idE);
        String clickableText11 = "School Identification Card(ID)";
        String cardId11 = "Document12";
        TextView buildingB = findViewById(R.id.buildingBE);
        String clickableText12 = "Building B";
        String cardId12 = "Location3";
        TextView blueForm = findViewById(R.id.blueFormE);
        String clickableText13 = "Blue Form(Student's Copy of Enrollment)";
        String cardId13= "Document12";
        TextView buildingA = findViewById(R.id.buildingAE);
        String clickableText14 = "Building A";
        String cardId14 = "Location2";
        TextView studentinfo = findViewById(R.id.studentInfoE);
        String clickableText15 = "Student Information Sheet";
        String cardId15 = "Document14";
        TextView buildingC = findViewById(R.id.buildingCE);
        String clickableText16 = "Building C";
        String cardId16 = "Location4";
        Drawable iconDrawable = AppCompatResources.getDrawable(this, R.drawable.link);
        makeTextClickableWithIcon(this, enrollmentform, clickableText, cardId, null, null, iconDrawable);
        makeTextClickableWithIcon(this, clearanceform, clickableText1, cardId1, clickableText2, cardId2, iconDrawable);
        makeTextClickableWithIcon(this, reportcard, clickableText3, cardId3,null, null, iconDrawable);
        makeTextClickableWithIcon(this, gmchar, clickableText4, cardId4,null, null, iconDrawable);
        makeTextClickableWithIcon(this, birth, clickableText5, cardId5,null, null, iconDrawable);
        makeTextClickableWithIcon(this, honorable, clickableText6, cardId6,null, null, iconDrawable);
        makeTextClickableWithIcon(this, gmchar2, clickableText7, cardId7,null, null, iconDrawable);
        makeTextClickableWithIcon(this, birthCert, clickableText8, cardId8,null, null, iconDrawable);
        makeTextClickableWithIcon(this, registrar, clickableText9, cardId9,null, null, iconDrawable);
        makeTextClickableWithIcon(this, buildingD, clickableText10, cardId10,null, null, iconDrawable);
        makeTextClickableWithIcon(this, idE, clickableText11, cardId11,null, null, iconDrawable);
        makeTextClickableWithIcon(this, buildingB, clickableText12, cardId12,null, null, iconDrawable);
        makeTextClickableWithIcon(this, blueForm, clickableText13, cardId13,null, null, iconDrawable);
        makeTextClickableWithIcon(this, buildingA, clickableText14, cardId14,null, null, iconDrawable);
        makeTextClickableWithIcon(this, studentinfo, clickableText15, cardId15,null, null, iconDrawable);
        makeTextClickableWithIcon(this, buildingC, clickableText16, cardId16,null, null, iconDrawable);
    }
    private void disable() {
        CardView[] cardViews = { cardView1, cardView2, cardView3, cardView4, cardView5, cardView6, cardView7, cardView8, cardView9};
      for (CardView cardView: cardViews) {
          gold(cardView);
      }
    }
    private void initializeViews(){
        arrow = findViewById(R.id.arrow_insert);
        arrow1 = findViewById(R.id.arrow1);
        arrow2 = findViewById(R.id.arrow2);
        arrow3 = findViewById(R.id.arrow3);
        arrow4 = findViewById(R.id.arrow4);
        arrow5 = findViewById(R.id.arrow5);
        arrow6 = findViewById(R.id.arrow6);
        arrow7 = findViewById(R.id.arrow7);
        arrow8 = findViewById(R.id.arrow8);
        arrow9 = findViewById(R.id.arrow9);
        circle = findViewById(R.id.circle_insert);
        circle1 = findViewById(R.id.circle1);
        circle2 = findViewById(R.id.circle2);
        circle3 = findViewById(R.id.circle3);
        circle4 = findViewById(R.id.circle4);
        circle5 = findViewById(R.id.circle5);
        circle6 = findViewById(R.id.circle6);
        circle7 = findViewById(R.id.circle7);
        circle8 = findViewById(R.id.circle8);
        circle9 = findViewById(R.id.circle9);
        arrow1old = findViewById(R.id.arrow1old);
        arrow6old = findViewById(R.id.arrow6old);
        arrow7old = findViewById(R.id.arrow7old);
        arrow1new = findViewById(R.id.arrow1new);
        arrow6new = findViewById(R.id.arrow6new);
        arrow7new = findViewById(R.id.arrow7new);
        arrow1transferress = findViewById(R.id.arrow1transferees);
        buttonN = findViewById(R.id.next1);
        buttonN1 = findViewById(R.id.next_insert);
        buttonN2 = findViewById(R.id.next2);
        buttonN3 = findViewById(R.id.next3);
        buttonN4 = findViewById(R.id.next4);
        buttonN5 = findViewById(R.id.next5);
        buttonN6 = findViewById(R.id.next6);
        buttonN7 = findViewById(R.id.next7);
        buttonN8 = findViewById(R.id.next8);
        buttonN9 = findViewById(R.id.next9);
        buttonB1 = findViewById(R.id.back_insert);
        buttonB2 = findViewById(R.id.back2);
        buttonB3 = findViewById(R.id.back3);
        buttonB4 = findViewById(R.id.back4);
        buttonB5 = findViewById(R.id.back5);
        buttonB6 = findViewById(R.id.back6);
        buttonB7 = findViewById(R.id.back7);
        buttonB8 = findViewById(R.id.back8);
        buttonB9 = findViewById(R.id.back9);
        layout = findViewById(R.id.linear1E);
        layout1 = findViewById(R.id.linear_insert);
        layout2 = findViewById(R.id.linear2E);
        layout3 = findViewById(R.id.linear3E);
        layout4 = findViewById(R.id.linear4E);
        layout5 = findViewById(R.id.linear5E);
        layout6 = findViewById(R.id.linear6E);
        layout7 = findViewById(R.id.linear7E);
        layout8 = findViewById(R.id.linear8E);
        layout9 = findViewById(R.id.linear9E);
        oldlayout1 = findViewById(R.id.oldLayout1);
        oldlayout6 = findViewById(R.id.oldLayout6);
        oldlayout7 = findViewById(R.id.oldLayout7);
        newlayout1 = findViewById(R.id.newLayout1);
        newlayout6 = findViewById(R.id.newLayout6);
        newlayout7 = findViewById(R.id.newLayout7);
        transfereeslayout1 = findViewById(R.id.transfereesLayout1);
        old1 = findViewById(R.id.oldStudents1);
        old6 = findViewById(R.id.oldStudents6);
        old7 = findViewById(R.id.oldStudents7);
        old11 = findViewById(R.id.old1);
        old66 = findViewById(R.id.old6);
        old77 = findViewById(R.id.old7);
        new1 = findViewById(R.id.newStudents1);
        new6 = findViewById(R.id.newStudents6);
        new7 = findViewById(R.id.newStudents7);
        new11 = findViewById(R.id.new1);
        new66 = findViewById(R.id.new6);
        new77 = findViewById(R.id.new7);
        transfer1 = findViewById(R.id.transferees1);
        transfer11 = findViewById(R.id.transfer1);
        cardView = findViewById(R.id.step1);
        cardView1 = findViewById(R.id.step_insert);
        cardView2 = findViewById(R.id.step2);
        cardView3 = findViewById(R.id.step3);
        cardView4 = findViewById(R.id.step4);
        cardView5 = findViewById(R.id.step5);
        cardView6 = findViewById(R.id.step6);
        cardView7 = findViewById(R.id.step7);
        cardView8 = findViewById(R.id.step8);
        cardView9 = findViewById(R.id.step9);
        card = findViewById(R.id.first);
        card1 = findViewById(R.id.insertE);
        card2 = findViewById(R.id.second);
        card3 = findViewById(R.id.third);
        card4 = findViewById(R.id.fourth);
        card5 = findViewById(R.id.fifth);
        card6 = findViewById(R.id.sixth);
        card7 = findViewById(R.id.seventh);
        card8 = findViewById(R.id.eighth);
        card9 = findViewById(R.id.ninth);
        LayoutTransition transition = new LayoutTransition();
        transition.enableTransitionType(LayoutTransition.CHANGING);
        layout.setLayoutTransition(transition);
        layout1.setLayoutTransition(transition);
        layout2.setLayoutTransition(transition);
        layout3.setLayoutTransition(transition);
        layout4.setLayoutTransition(transition);
        layout5.setLayoutTransition(transition);
        layout6.setLayoutTransition(transition);
        layout7.setLayoutTransition(transition);
        layout8.setLayoutTransition(transition);
        layout9.setLayoutTransition(transition);
        oldlayout1.setLayoutTransition(transition);
        oldlayout6.setLayoutTransition(transition);
        oldlayout7.setLayoutTransition(transition);
        newlayout1.setLayoutTransition(transition);
        newlayout6.setLayoutTransition(transition);
        newlayout7.setLayoutTransition(transition);
        transfereeslayout1.setLayoutTransition(transition);
         oldText1 = findViewById(R.id.old_1);
         newText1 = findViewById(R.id.new_1);
         transferText1 = findViewById(R.id.transfer_1);
         olderLayout1 = findViewById(R.id.old_layout1);
         newerLayout1 = findViewById(R.id.new_layout1);
         transferLayout1 = findViewById(R.id.transfer_Layout1);
         oldText3 = findViewById(R.id.old_3);
        oldText4 = findViewById(R.id.old_4);
        oldText6 = findViewById(R.id.old_6);
        newText6 = findViewById(R.id.new_6);
        olderLayout6 = findViewById(R.id.old_layout6);
        newerLayout6 = findViewById(R.id.new_layout6);
        oldText7 = findViewById(R.id.old_7);
        newText7 = findViewById(R.id.new_7);
        olderLayout7 = findViewById(R.id.old_layout7);
        newerLayout7 = findViewById(R.id.new_layout7);
    }
    private void setButtonListeners(){
        buttonN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cardView1.isEnabled()) {
                    cardView1.setEnabled(true);
                    cardView1.setAlpha(1.0f);
                    cardView.setEnabled(false);
                    cardView.setAlpha(0.5f);
                    alpha(cardView);
                    card1.setVisibility(View.VISIBLE);
                    card.setVisibility(View.GONE);
                    old11.setVisibility(View.GONE);
                    new11.setVisibility(View.GONE);
                    transfer11.setVisibility(View.GONE);
                    inside(olderLayout1, oldText1);
                    inside(newerLayout1, newText1);
                    inside(transferLayout1, transferText1);
                    circle1.setImageResource(R.drawable.checked);
                    arrow1.setImageResource(R.drawable.arrowdown);
                    arrow1old.setImageResource(R.drawable.arrowdown_in);
                    arrow1new.setImageResource(R.drawable.arrowdown_in);
                    arrow1transferress.setImageResource(R.drawable.arrowdown_in);
                } else if (cardView1.isEnabled()){
                    card1.setVisibility(View.VISIBLE);
                    card.setVisibility(View.GONE);
                    circle1.setImageResource(R.drawable.checked);
                    arrow1.setImageResource(R.drawable.arrowdown);
                }
            }
        });
        buttonN1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cardView2.isEnabled()) {
                    cardView2.setEnabled(true);
                    cardView2.setAlpha(1.0f);
                    cardView1.setEnabled(false);
                    alpha(cardView1);
                    card2.setVisibility(View.VISIBLE);
                    card1.setVisibility(View.GONE);
                    circle.setImageResource(R.drawable.checked);
                    arrow.setImageResource(R.drawable.arrowdown);
                } else if (cardView2.isEnabled()){
                    card2.setVisibility(View.VISIBLE);
                    card1.setVisibility(View.GONE);
                    circle.setImageResource(R.drawable.checked);
                    arrow.setImageResource(R.drawable.arrowdown);
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
                    arrow3.setImageResource(R.drawable.arrowdown_in);
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
                    old66.setVisibility(View.GONE);
                    new66.setVisibility(View.GONE);
                    inside(olderLayout6, oldText6);
                    inside(newerLayout6, newText6);
                    circle6.setImageResource(R.drawable.checked);
                    arrow6.setImageResource(R.drawable.arrowdown);
                    arrow6old.setImageResource(R.drawable.arrowdown_in);
                    arrow6new.setImageResource(R.drawable.arrowdown_in);
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
                    old77.setVisibility(View.GONE);
                    new77.setVisibility(View.GONE);
                    inside(olderLayout7, oldText7);
                    inside(newerLayout7, newText7);
                    circle7.setImageResource(R.drawable.checked);
                    arrow7.setImageResource(R.drawable.arrowdown);
                    arrow7old.setImageResource(R.drawable.arrowdown_in);
                    arrow7new.setImageResource(R.drawable.arrowdown_in);
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
                if (!cardView9.isEnabled()) {
                    cardView9.setEnabled(true);
                    cardView9.setAlpha(1.0f);
                    cardView8.setEnabled(false);
                    alpha(cardView8);
                    card9.setVisibility(View.VISIBLE);
                    card8.setVisibility(View.GONE);
                    circle8.setImageResource(R.drawable.checked);
                    arrow8.setImageResource(R.drawable.arrowdown);
                } else if (cardView9.isEnabled()) {
                    card9.setVisibility(View.VISIBLE);
                    card8.setVisibility(View.GONE);
                    circle8.setImageResource(R.drawable.checked);
                    arrow8.setImageResource(R.drawable.arrowdown);
                }
            }
        });
        buttonN9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmationDialog();
            }
        });

        buttonB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card.setVisibility(View.VISIBLE);
                card1.setVisibility(View.GONE);
                arrow1.setImageResource(R.drawable.arrowup);
                cardView.setEnabled(true);
                cardView.setAlpha(1.0f);
                cardView1.setEnabled(false);
                alpha(cardView1);
            }
        });
        buttonB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card1.setVisibility(View.VISIBLE);
                card2.setVisibility(View.GONE);
                arrow.setImageResource(R.drawable.arrowup);
                cardView1.setEnabled(true);
                cardView1.setAlpha(1.0f);
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
        buttonB9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card8.setVisibility(View.VISIBLE);
                card9.setVisibility(View.GONE);
                arrow8.setImageResource(R.drawable.arrowup);
                cardView8.setEnabled(true);
                cardView8.setAlpha(1.0f);
                cardView9.setEnabled(false);
                alpha(cardView9);
            }
        });
    }
    private void inside (LinearLayout layout, TextView textView){
        textView.setTextColor(ContextCompat.getColor(this, R.color.processDark));
        layout.setBackgroundColor(Color.TRANSPARENT);
    }
    public void inToggleVisibility(View view, ViewGroup layout, LinearLayout linearLayout, TextView textView, ImageView imageView, int newImageResId, int oldImageResID) {
        int newVisibility = (view.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
        TransitionManager.beginDelayedTransition(layout, new AutoTransition());
        if (newVisibility == View.VISIBLE && imageView != null) {
            imageView.setImageResource(newImageResId);
            textView.setTextColor(ContextCompat.getColor(this, R.color.processWhite));
            linearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.cardInside));
        } else if (newVisibility == View.GONE && imageView != null) {
            imageView.setImageResource(oldImageResID);
            textView.setTextColor(ContextCompat.getColor(this, R.color.processDark));
            linearLayout.setBackgroundColor(Color.TRANSPARENT);
        }
        view.setVisibility(newVisibility);
    }
    public void open1_1(View view) {
        inToggleVisibility(old11, oldlayout1, olderLayout1, oldText1, arrow1old, R.drawable.arrowup_in, R.drawable.arrowdown_in);
    }
    public void open4_1(View view) {
        inToggleVisibility(old44, oldlayout4, olderLayout4, oldText4, arrow4old, R.drawable.arrowup_in, R.drawable.arrowdown_in);
    }
    public void open6_1(View view) {
        inToggleVisibility(old66, oldlayout6, olderLayout6, oldText6, arrow6old, R.drawable.arrowup_in, R.drawable.arrowdown_in);
    }
    public void open7_1(View view) {
        inToggleVisibility(old77, oldlayout7, olderLayout7, oldText7, arrow7old, R.drawable.arrowup_in, R.drawable.arrowdown_in);
    }

    public void open1_2(View view) {
        inToggleVisibility(new11, newlayout1, newerLayout1, newText1, arrow1new, R.drawable.arrowup_in, R.drawable.arrowdown_in);
    }
    public void open6_2(View view) {
        inToggleVisibility(new66, newlayout6, newerLayout6, newText6, arrow6new, R.drawable.arrowup_in, R.drawable.arrowdown_in);
    }
    public void open7_2(View view) {
        inToggleVisibility(new77, newlayout7,newerLayout7, newText7, arrow7new, R.drawable.arrowup_in, R.drawable.arrowdown_in);
    }
    public void open1_3(View view) {
        inToggleVisibility(transfer11, transfereeslayout1, transferLayout1, transferText1, arrow1transferress, R.drawable.arrowup_in, R.drawable.arrowdown_in);
    }
    public void mainMenu (View view) {
        Intent go = new Intent(this, MainActivity.class);
        startActivity(go);
    }
}