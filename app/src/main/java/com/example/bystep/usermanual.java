package com.example.bystep;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class usermanual extends BaseActivity {
    ScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_usermanual);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        imgUpdate();
        TextView process = findViewById(R.id.process);
        setBoldText(process, "Processes");
        scrollView = findViewById(R.id.scroll);
        initializeTable();

        TextView sidebarIcon = findViewById(R.id.sidebar);
        setBoldText(sidebarIcon, "Sidebar icon");
        TextView helpbutton = findViewById(R.id.help);
        setBoldText(helpbutton, "Help button");
        TextView homeButton = findViewById(R.id.homebutton);
        setBoldText(homeButton, "Home button");
        TextView currentStep = findViewById(R.id.current);
        setBoldText(currentStep, "Current step");
        TextView whattodo = findViewById(R.id.whattodo);
        setBoldText(whattodo, "What To Do");
        TextView wheretogo = findViewById(R.id.wheretogo);
        setBoldText(wheretogo, "Where To Go");
        TextView whatyoullneed = findViewById(R.id.whatyoullneed);
        setBoldText(whatyoullneed, "What You'll Need");
        TextView hyperlinkText = findViewById(R.id.hyperlinktext);
        setBoldText(hyperlinkText, "Hyperlink texts");
        TextView nextButton = findViewById(R.id.nextbutton);
        setBoldText(nextButton, "Next button");
        TextView nextStep = findViewById(R.id.nextstep);
        setBoldText(nextStep, "Next steps");
        TextView backButton = findViewById(R.id.backbutton);
        setBoldText(backButton, "Back button");
        TextView finishButton = findViewById(R.id.finishbutton);
        setBoldText(finishButton, "Finish button");
        TextView hamburger = findViewById(R.id.hamburger);
        setBoldText(hamburger, "Hamburger button");
        TextView theme = findViewById(R.id.themes);
        setBoldText(theme, "Light/Dark mode switch.");
        TextView searchbar = findViewById(R.id.search);
        setBoldText(searchbar, "Search bar:");
        TextView forms= findViewById(R.id.forms);
        setBoldText(forms, "Forms section");
        TextView location= findViewById(R.id.location);
        setBoldText(location, "Buildings and Offices section");
        TextView sidebarlist = findViewById(R.id.sidebarlist);
        setBoldText(sidebarlist, "sidebar list entry");
        TextView links = findViewById(R.id.link);
        setBoldText(links, "hyperlinks");
        TextView photo = findViewById(R.id.photo);
        setBoldText(photo, "Photo reference");
        TextView textarea = findViewById(R.id.textarea);
        setBoldText(textarea, "Text area");
        TextView label = findViewById(R.id.label);
        setBoldText(label, "Photo label");
    }
    public void setBoldText(TextView textView, String targetWord) {
        String originalText = textView.getText().toString();
        int startIndex = originalText.indexOf(targetWord);
        if (startIndex == -1) {
            Log.d("BoldText", "Word '" + targetWord + "' not found in the text.");
            return;
        }
        SpannableString spannableString = new SpannableString(originalText);
        int endIndex = startIndex + targetWord.length();
        spannableString.setSpan(
                new StyleSpan(android.graphics.Typeface.BOLD),
                startIndex,
                endIndex,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );
        textView.setText(spannableString);
        Log.d("BoldText", "Bold style applied to word '" + targetWord + "'.");
    }
    public void imgUpdate(){
        ImageView image = findViewById(R.id.manualheaderbg);
        updateImgHeader(image, R.drawable.processheaddark, R.drawable.processhead);
    }
    public void mainMenu (View view) {
        Intent go = new Intent(this, MainActivity.class);
        startActivity(go);
    }
    public void tableOfContents(TextView textView, LinearLayout section) {
        textView.setOnClickListener(view -> scrollView.post(() -> {
            int scrollY = section.getTop();
            scrollView.smoothScrollTo(0, Math.max(scrollY, 0)); // Ensure scrollY is not negative
        }));
    }
    public void initializeTable(){
        LinearLayout AccesstheWebsite = findViewById(R.id.access);
        LinearLayout DownloadtheApp = findViewById(R.id.download);
        LinearLayout HomePage = findViewById(R.id.home);
        LinearLayout ProcessPage = findViewById(R.id.processpage);
        LinearLayout SidebarMenu = findViewById(R.id.sidebarMenu);
        LinearLayout GlossaryPage = findViewById(R.id.glossary);
        TextView I = findViewById(R.id.I);
        TextView II = findViewById(R.id.II);
        TextView III = findViewById(R.id.III);
        TextView IV = findViewById(R.id.IV);
        TextView V = findViewById(R.id.V);
        TextView VI = findViewById(R.id.VI);
        tableOfContents(I, AccesstheWebsite);
        tableOfContents(II, DownloadtheApp);
        tableOfContents(III, HomePage);
        tableOfContents(IV, ProcessPage);
        tableOfContents(V, SidebarMenu);
        tableOfContents(VI, GlossaryPage);
    }
}