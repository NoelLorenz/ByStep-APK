package com.example.bystep;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Highlights;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Glossary extends BaseActivity {
    private ScrollView scrollView;
    ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11, imageView12, imageView13, imageView14, imageView15,
            imageView1l, imageView2l, imageView3l, imageView4l, imageView5l, imageView6l, imageView7l, imageView8l, imageView9l, imageView10l, imageView11l, imageView12l, imageView13l, imageView14l;
    private TextView docTitle1, docTitle2, docTitle3, docTitle4, docTitle5, docTitle6, docTitle7, docTitle8, docTitle9, docTitle10, docTitle11, docTitle12, docTitle13, docTitle14, docTitle15;
    private TextView docDescription1, docDescription2, docDescription3, docDescription4, docDescription5, docDescription6, docDescription7, docDescription8, docDescription9, docDescription10, docDescription11, docDescription12, docDescription13, docDescription14, docDescription15;
    private TextView locTitle1, locTitle2, locTitle3, locTitle4, locTitle5, locTitle6, locTitle7, locTitle8, locTitle9, locTitle10, locTitle11, locTitle12, locTitle13, locTitle14;
    private TextView locDescription1, locDescription2, locDescription3, locDescription4, locDescription5, locDescription6, locDescription7, locDescription8, locDescription9, locDescription10, locDescription11, locDescription12, locDescription13, locDescription14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glossary);
             ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        imgUpdate();
        initialize();
        zoom();
       // scale();
        scrollView = findViewById(R.id.scrollView);
        String targetViewId = getIntent().getStringExtra("target_view_id");
        if (targetViewId != null) {
            int resId = getResources().getIdentifier(targetViewId, "id", getPackageName());
            if (resId != 0) {
                scrollToView(resId);
            }
        }
    }
    public void imgUpdate(){
        ImageView imageView = findViewById(R.id.bgGlossary);
        ImageView image = findViewById(R.id.glossaryHeaderBg);
        updateProcessBG(imageView, R.drawable.bgblack, R.drawable.bgblue);
        updateImgHeader(image, R.drawable.processheaddark, R.drawable.processhead);
    }
  /*  private void adjust(CardView card){
        // Convert 200dp to pixels
        int maxWidthInPx = (int) (750 * card.getContext().getResources().getDisplayMetrics().density);

        // Get the current layout parameters
        ViewGroup.LayoutParams params = card.getLayoutParams();

        // Set the maximum width
        params.width = Math.min(params.width, maxWidthInPx);

        // Apply the updated layout parameters
        card.setLayoutParams(params);
    }
    public void scale(){
        adjust(cardView);
    }*/
    private void initialize() {
        docTitle1 = findViewById(R.id.docT1);
        docTitle2 = findViewById(R.id.docT2);
        docTitle3 = findViewById(R.id.docT3);
        docTitle4 = findViewById(R.id.docT4);
        docTitle5 = findViewById(R.id.docT5);
        docTitle6 = findViewById(R.id.docT6);
        docTitle7 = findViewById(R.id.docT7);
        docTitle8 = findViewById(R.id.docT8);
        docTitle9 = findViewById(R.id.docT9);
        docTitle10 = findViewById(R.id.docT10);
        docTitle11 = findViewById(R.id.docT11);
        docTitle12 = findViewById(R.id.docT12);
        docTitle13 = findViewById(R.id.docT13);
        docTitle14 = findViewById(R.id.docT14);
        docTitle15 = findViewById(R.id.docT15);
        docDescription1 = findViewById(R.id.docD1);
        docDescription2 = findViewById(R.id.docD2);
        docDescription3 = findViewById(R.id.docD3);
        docDescription4 = findViewById(R.id.docD4);
        docDescription5 = findViewById(R.id.docD5);
        docDescription6 = findViewById(R.id.docD6);
        docDescription7 = findViewById(R.id.docD7);
        docDescription8 = findViewById(R.id.docD8);
        docDescription9 = findViewById(R.id.docD9);
        docDescription10 = findViewById(R.id.docD10);
        docDescription11 = findViewById(R.id.docD11);
        docDescription12 = findViewById(R.id.docD12);
        docDescription13 = findViewById(R.id.docD13);
        docDescription14 = findViewById(R.id.docD14);
        docDescription15 = findViewById(R.id.docD15);
        locTitle1 = findViewById(R.id.locT1);
        locTitle2 = findViewById(R.id.locT2);
        locTitle3 = findViewById(R.id.locT3);
        locTitle4 = findViewById(R.id.locT4);
        locTitle5 = findViewById(R.id.locT5);
        locTitle6 = findViewById(R.id.locT6);
        locTitle7 = findViewById(R.id.locT7);
        locTitle8 = findViewById(R.id.locT8);
        locTitle9 = findViewById(R.id.locT9);
        locTitle10 = findViewById(R.id.locT10);
        locTitle11 = findViewById(R.id.locT11);
        locTitle12 = findViewById(R.id.locT12);
        locTitle13 = findViewById(R.id.locT13);
        locTitle14 = findViewById(R.id.locT14);
        locDescription1 = findViewById(R.id.locD1);
        locDescription2 = findViewById(R.id.locD2);
        locDescription3 = findViewById(R.id.locD3);
        locDescription4 = findViewById(R.id.locD4);
        locDescription5 = findViewById(R.id.locD5);
        locDescription6 = findViewById(R.id.locD6);
        locDescription7 = findViewById(R.id.locD7);
        locDescription8 = findViewById(R.id.locD8);
        locDescription9 = findViewById(R.id.locD9);
        locDescription10 = findViewById(R.id.locD10);
        locDescription11 = findViewById(R.id.locD11);
        locDescription12 = findViewById(R.id.locD12);
        locDescription13 = findViewById(R.id.locD13);
        locDescription14 = findViewById(R.id.locD14);
        imageView3 = findViewById(R.id.image3);
        imageView4 = findViewById(R.id.image4);
        imageView5 = findViewById(R.id.image5);
        imageView6 = findViewById(R.id.image6);
        imageView11 = findViewById(R.id.image11);
        imageView12 = findViewById(R.id.image12);
        imageView14 = findViewById(R.id.image14);
        imageView1l = findViewById(R.id.image1l);
        imageView2l = findViewById(R.id.image2l);
        imageView3l = findViewById(R.id.image3l);
        imageView4l = findViewById(R.id.image4l);
        imageView5l = findViewById(R.id.image5l);
        imageView6l = findViewById(R.id.image6l);
        imageView7l = findViewById(R.id.image7l);
        imageView8l = findViewById(R.id.image8l);
        imageView9l = findViewById(R.id.image9l);
        imageView10l = findViewById(R.id.image10l);
        imageView11l = findViewById(R.id.image11l);
        imageView12l = findViewById(R.id.image12l);
        imageView13l = findViewById(R.id.image13l);
        imageView14l = findViewById(R.id.image14l);
    }
    private void scrollToView(int viewId) {
        View targetView = findViewById(viewId);
        if (targetView != null) {
            scrollView.post(() -> {
                scrollView.smoothScrollTo(0, targetView.getTop());
                scrollView.postDelayed(() -> {
                    int scrollY = targetView.getTop() - (scrollView.getHeight() / 2) + (targetView.getHeight() / 2);
                    scrollView.smoothScrollTo(0, scrollY);
                    if (targetView instanceof CardView) {
                        CardView cardView = (CardView) targetView;
                        int originalColor = cardView.getCardBackgroundColor().getDefaultColor();
                        int highlightColor;
                        if (isDarkModeEnabled()) {
                            highlightColor = ContextCompat.getColor(this, R.color.highlight_color_dark_mode);
                        } else {
                            highlightColor = ContextCompat.getColor(this, R.color.blue);
                        }
                        ObjectAnimator fadeIn = ObjectAnimator.ofArgb(cardView, "cardBackgroundColor", originalColor, highlightColor);
                        fadeIn.setDuration(500);
                        ObjectAnimator fadeOut = ObjectAnimator.ofArgb(cardView, "cardBackgroundColor", highlightColor, originalColor);
                        fadeOut.setDuration(500);
                        fadeIn.start();
                        new Handler(Looper.getMainLooper()).postDelayed(() -> fadeOut.start(), 1000); // Wait 1 second, then start fade-out
                    }
                    if (targetView.getId() == R.id.Document1) {
                        textfade(docTitle1);
                        textfade(docDescription1);
                    } else if (targetView.getId() == R.id.Document2){
                        textfade(docTitle2);
                        textfade(docDescription2);
                    } else if (targetView.getId() == R.id.Document3){
                        textfade(docTitle3);
                        textfade(docDescription3);
                    } else if (targetView.getId() == R.id.Document4){
                        textfade(docTitle4);
                        textfade(docDescription4);
                    }else if (targetView.getId() == R.id.Document5){
                        textfade(docTitle5);
                        textfade(docDescription5);
                    }else if (targetView.getId() == R.id.Document6){
                        textfade(docTitle6);
                        textfade(docDescription6);
                    }else if (targetView.getId() == R.id.Document7){
                        textfade(docTitle7);
                        textfade(docDescription7);
                    }else if (targetView.getId() == R.id.Document8){
                        textfade(docTitle8);
                        textfade(docDescription8);
                    }else if (targetView.getId() == R.id.Document9){
                        textfade(docTitle9);
                        textfade(docDescription9);
                    }else if (targetView.getId() == R.id.Document10){
                        textfade(docTitle10);
                        textfade(docDescription10);
                    }else if (targetView.getId() == R.id.Document11){
                        textfade(docTitle11);
                        textfade(docDescription11);
                    }else if (targetView.getId() == R.id.Document12){
                        textfade(docTitle12);
                        textfade(docDescription12);
                    }else if (targetView.getId() == R.id.Document13){
                        textfade(docTitle13);
                        textfade(docDescription13);
                    }else if (targetView.getId() == R.id.Document14){
                        textfade(docTitle14);
                        textfade(docDescription14);
                    }else if (targetView.getId() == R.id.Document15){
                        textfade(docTitle15);
                        textfade(docDescription15);
                    }else if (targetView.getId() == R.id.Location1) {
                        textfade(locTitle1);
                        textfade(locDescription1);
                    } else if (targetView.getId() == R.id.Location2){
                        textfade(locTitle2);
                        textfade(locDescription2);
                    } else if (targetView.getId() == R.id.Location3){
                        textfade(locTitle3);
                        textfade(locDescription3);
                    } else if (targetView.getId() == R.id.Location4){
                        textfade(locTitle4);
                        textfade(locDescription4);
                    }else if (targetView.getId() == R.id.Location5){
                        textfade(locTitle5);
                        textfade(locDescription5);
                    }else if (targetView.getId() == R.id.Location6){
                        textfade(locTitle6);
                        textfade(locDescription6);
                    }else if (targetView.getId() == R.id.Location7){
                        textfade(locTitle7);
                        textfade(locDescription7);
                    }else if (targetView.getId() == R.id.Location8){
                        textfade(locTitle8);
                        textfade(locDescription8);
                    }else if (targetView.getId() == R.id.Location9){
                        textfade(locTitle9);
                        textfade(locDescription9);
                    }else if (targetView.getId() == R.id.Location10){
                        textfade(locTitle10);
                        textfade(locDescription10);
                    }else if (targetView.getId() == R.id.Location11){
                        textfade(locTitle11);
                        textfade(locDescription11);
                    }else if (targetView.getId() == R.id.Location12){
                        textfade(locTitle12);
                        textfade(locDescription12);
                    }else if (targetView.getId() == R.id.Location13){
                        textfade(locTitle13);
                        textfade(locDescription13);
                    }else if (targetView.getId() == R.id.Location14){
                        textfade(locTitle14);
                        textfade(locDescription14);
                    }
                }, 100);
            });
        }
    }
    private void clickpic(ImageView image, String title) {
        image.setOnClickListener(new View.OnClickListener() {
            ImageDialogUtil imageDialogUtil = new ImageDialogUtil();
            @Override
            public void onClick(View v) {
                imageDialogUtil.showImageDialog(Glossary.this, image, title);
            }
        });
    }
    private void zoom(){
        clickpic(imageView3, "Blue Form (Student's Copy");
        clickpic(imageView4, "Clearance");
        clickpic(imageView5, "Enrollment Form");
        clickpic(imageView6, "Examination Permit");
        clickpic(imageView11, "LibraryCard");
        clickpic(imageView12, "School ID");
        clickpic(imageView14, "Student Information Sheet");
        clickpic(imageView1l, "Assessor's Office");
        clickpic(imageView2l, "Builing A");
        clickpic(imageView3l, "Builing B");
        clickpic(imageView4l, "Builing C");
        clickpic(imageView5l, "Builing D");
        clickpic(imageView6l, "EVP Office");
        clickpic(imageView7l, "Guidance Office");
        clickpic(imageView8l, "HAC's Office");
        clickpic(imageView9l, "Internet Laboratory");
        clickpic(imageView10l, "Library");
        clickpic(imageView11l, "Registrar's Office");
        clickpic(imageView12l, "SaaS Office");
        clickpic(imageView13l, "SSC Office");
        clickpic(imageView14l, "Treasurer's Office");
    }
    private void textfade(TextView textView){
        int OGcolor = textView.getTextColors().getDefaultColor();
        int highlightColor = ContextCompat.getColor(this, R.color.processWhite);
        ObjectAnimator fadeIn = ObjectAnimator.ofArgb(textView, "textColor", OGcolor, highlightColor);
        fadeIn.setDuration(500);
        ObjectAnimator fadeOut = ObjectAnimator.ofArgb(textView, "textColor",highlightColor, OGcolor);
        fadeOut.setDuration(500);
        fadeIn.start();
        new Handler(Looper.getMainLooper()).postDelayed(() -> fadeOut.start(), 1000);
    }
    public void mainMenu (View view) {
        Intent go = new Intent(this, MainActivity.class);
        startActivity(go);
    }
}
