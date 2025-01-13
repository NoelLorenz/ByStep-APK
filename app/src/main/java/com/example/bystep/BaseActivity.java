package com.example.bystep;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.graphics.fonts.Font;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

public class BaseActivity extends AppCompatActivity {
    private boolean currentThemeState = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentThemeState = isDarkModeEnabled();
        applyThemeIfChanged();
    }


    public static void makeTextClickableWithIcon(Context context, TextView textView, String clickableText1, final String targetViewId1, String clickableText2, final String targetViewId2, Drawable iconDrawable) {
        String fullText = textView.getText().toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(fullText);
        if (clickableText1 != null && targetViewId1 != null) {
            applyClickableSpanWithIcon(context, spannableStringBuilder, fullText, clickableText1, targetViewId1, iconDrawable);
        }
        if (clickableText2 != null && targetViewId2 != null) {
            applyClickableSpanWithIcon(context, spannableStringBuilder, spannableStringBuilder.toString(), clickableText2, targetViewId2, iconDrawable);
        }
        textView.setText(spannableStringBuilder);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
    private static void applyClickableSpanWithIcon(Context context, SpannableStringBuilder spannableStringBuilder, String fullText, String clickableText, String targetViewId, Drawable iconDrawable) {
        if (clickableText == null || targetViewId == null) return;
        int start = fullText.indexOf(clickableText);
        int end = start + clickableText.length();
        if (start >= 0 && end <= spannableStringBuilder.length()) {
            ClickableSpan clickableSpan = new ClickableSpan() {
                @Override
                public void onClick(View widget) {
                    Intent intent = new Intent(context, Glossary.class);
                    intent.putExtra("target_view_id", targetViewId);
                    context.startActivity(intent);
                }
                @Override
                public void updateDrawState(android.text.TextPaint ds) {
                    super.updateDrawState(ds);
                    ds.setUnderlineText(false);
                    ds.setColor(ContextCompat.getColor(context, R.color.hyperlinkColor));
                }
            };
            spannableStringBuilder.setSpan(clickableSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannableStringBuilder.insert(end, " ");
            Drawable resizedIcon = resizeDrawableToDp(context, iconDrawable, 10);
            if (resizedIcon != null) {
                resizedIcon.setBounds(0, 0, resizedIcon.getIntrinsicWidth(), resizedIcon.getIntrinsicHeight());
                ImageSpan imageSpan = new ImageSpan(resizedIcon, ImageSpan.ALIGN_BASELINE);
                spannableStringBuilder.setSpan(imageSpan, end + 1, end + 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                spannableStringBuilder.insert(end + 2, " ");
            }
        } else {
        }
    }
    private static Drawable resizeDrawableToDp(Context context, Drawable drawable, int dpSize) {
        if (drawable == null) return null;
        float density = context.getResources().getDisplayMetrics().density;
        int pixelSize = Math.round(dpSize * density);
        Bitmap bitmap;
        if (drawable instanceof BitmapDrawable) {
            bitmap = Bitmap.createScaledBitmap(((BitmapDrawable) drawable).getBitmap(), pixelSize, pixelSize, true);
        } else if (drawable instanceof VectorDrawable) {
            bitmap = getBitmapFromVectorDrawable((VectorDrawable) drawable, pixelSize, pixelSize);
        } else {
            return drawable;
        }
        return new BitmapDrawable(context.getResources(), bitmap);
    }
    private static Bitmap getBitmapFromVectorDrawable(VectorDrawable vectorDrawable, int width, int height) {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        vectorDrawable.draw(canvas);
        return bitmap;
    }
    public void gold (CardView cardView){
        if (isDarkModeEnabled()){
            cardView.setEnabled(false);
            cardView.setAlpha(0.09f);
        } else {
            cardView.setEnabled(false);
            cardView.setAlpha(0.1f);
        }
    }
    public void alpha(CardView cardView){
        if (isDarkModeEnabled()){
            cardView.setAlpha(0.09f);
        } else {
            cardView.setAlpha(0.1f);
        }
    }
    public void updateProcessBG(ImageView imageView, int imgResID, int oldImg){
        if (isDarkModeEnabled()) {
            imageView.setImageDrawable(null);
            imageView.setImageResource(imgResID);
        } else {
            imageView.setImageDrawable(null);
            imageView.setImageResource(oldImg);
        }
    }
    public void updateImgHeader(ImageView imageView, int bgResID, int oldbg){
        if (isDarkModeEnabled()) {
            imageView.setImageDrawable(null);
            imageView.setImageResource(bgResID);
        } else{
            imageView.setImageDrawable(null);
            imageView.setImageResource(oldbg);
        }
    }
    private static final String TAG = "BaseActivity";
    private long lastToggleTime = 0;
    private static final long DEBOUNCE_DELAY = 100;
    public boolean isDarkModeEnabled() {
        SharedPreferences sharedPreferences = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        boolean isDarkMode = sharedPreferences.getBoolean("isDarkMode", false);
        return isDarkMode;
    }
    public void applyTheme() {
        SharedPreferences sharedPreferences = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        boolean isDarkMode = sharedPreferences.getBoolean("isDarkMode", false);

        if ((isDarkMode && AppCompatDelegate.getDefaultNightMode() != AppCompatDelegate.MODE_NIGHT_YES) ||
                (!isDarkMode && AppCompatDelegate.getDefaultNightMode() != AppCompatDelegate.MODE_NIGHT_NO)) {
            AppCompatDelegate.setDefaultNightMode(isDarkMode ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);
            recreate();
        }
    }
    private void applyThemeIfChanged() {
        boolean isDarkMode = isDarkModeEnabled();

        if (isDarkMode != currentThemeState) {
            currentThemeState = isDarkMode;
            applyTheme();
        }
    }
    public void toggleTheme(boolean isDarkMode) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastToggleTime < DEBOUNCE_DELAY) {
            return;
        }
        lastToggleTime = currentTime;
        saveThemePreference(isDarkMode);
        applyThemeIfChanged();
    }
    private void saveThemePreference(boolean isDarkMode) {
        SharedPreferences sharedPreferences = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isDarkMode", isDarkMode);
        editor.apply();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    public class ImageDialogUtil {
        private float minScale = 1.0f;
        public void showImageDialog(Context context, ImageView img, String title) {
            Dialog dialog = new Dialog(context);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.image);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            ImageView imageView = dialog.findViewById(R.id.dialogImageView);
            TextView dialogTitle = dialog.findViewById(R.id.dialogTitle);
            dialogTitle.setText(title);
            imageView.setImageDrawable(img.getDrawable());
            enableZoomAndPan(imageView, context);
            WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
            params.width = WindowManager.LayoutParams.MATCH_PARENT;
            params.height = WindowManager.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setAttributes(params);
            dialog.show();
        }
        private void enableZoomAndPan(ImageView imageView, Context context) {
            final Matrix matrix = new Matrix();
            final float[] matrixValues = new float[9];
            imageView.post(() -> setInitialFit(matrix, imageView));
            final ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(context, new ScaleListener(matrix, imageView));
            final GestureDetector gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                    // Handle panning
                    matrix.postTranslate(-distanceX, -distanceY);
                    limitPanAndZoom(matrix, imageView, matrixValues);
                    imageView.setImageMatrix(matrix);
                    return true;
                }
            });
            imageView.setOnTouchListener((v, event) -> {
                scaleGestureDetector.onTouchEvent(event);
                gestureDetector.onTouchEvent(event);
                return true;
            });
        }

        private void setInitialFit(Matrix matrix, ImageView imageView) {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null) return;
            int imageWidth = drawable.getIntrinsicWidth();
            int imageHeight = drawable.getIntrinsicHeight();
            int viewWidth = imageView.getWidth();
            int viewHeight = imageView.getHeight();

            float scaleX = (float) viewWidth / imageWidth;
            float scaleY = (float) viewHeight / imageHeight;
            minScale = Math.min(scaleX, scaleY);

            float dx = (viewWidth - imageWidth * minScale) / 2;
            float dy = (viewHeight - imageHeight * minScale) / 2;

            matrix.setScale(minScale, minScale);
            matrix.postTranslate(dx, dy);
            imageView.setImageMatrix(matrix);
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
        }
        private void limitPanAndZoom(Matrix matrix, ImageView imageView, float[] matrixValues) {
            matrix.getValues(matrixValues);
            float currentScale = matrixValues[Matrix.MSCALE_X];
            float transX = matrixValues[Matrix.MTRANS_X];
            float transY = matrixValues[Matrix.MTRANS_Y];
            Drawable drawable = imageView.getDrawable();
            if (drawable == null) return;

            int imageWidth = drawable.getIntrinsicWidth();
            int imageHeight = drawable.getIntrinsicHeight();
            int viewWidth = imageView.getWidth();
            int viewHeight = imageView.getHeight();

            float maxScale = 5.0f;
            if (currentScale < minScale) {
                currentScale = minScale;
            } else if (currentScale > maxScale) {
                currentScale = maxScale;
            }
            float maxTransX = Math.max(0, (imageWidth * currentScale - viewWidth) / 2);
            float maxTransY = Math.max(0, (imageHeight * currentScale - viewHeight) / 2);
            transX = Math.min(Math.max(transX, -maxTransX), maxTransX);
            transY = Math.min(Math.max(transY, -maxTransY), maxTransY);
            matrixValues[Matrix.MTRANS_X] = transX;
            matrixValues[Matrix.MTRANS_Y] = transY;
            matrix.setValues(matrixValues);
        }

        private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
            private final Matrix matrix;
            private final ImageView imageView;
            private final float[] matrixValues = new float[9];
            public ScaleListener(Matrix matrix, ImageView imageView) {
                this.matrix = matrix;
                this.imageView = imageView;
            }
            @Override
            public boolean onScale(ScaleGestureDetector detector) {
                matrix.getValues(matrixValues);
                float scaleFactor = detector.getScaleFactor();
                float currentScale = matrixValues[Matrix.MSCALE_X];
                float newScale = currentScale * scaleFactor;
                if (newScale >= minScale && newScale <= 5.0f) {
                    matrix.postScale(scaleFactor, scaleFactor, detector.getFocusX(), detector.getFocusY());
                    imageView.setImageMatrix(matrix);
                }
                return true;
            }
        }
    }
}