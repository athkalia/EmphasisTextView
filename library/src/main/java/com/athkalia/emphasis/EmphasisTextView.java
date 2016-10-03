package com.athkalia.emphasis;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmphasisTextView extends TextView implements Emphasis {

    private int highlightColor;

    private String textToHighlight;

    private boolean caseInsensitive;

    private HighlightMode highlightMode = HighlightMode.BACKGROUND;

    public EmphasisTextView(Context context) {

        super(context);
    }

    public EmphasisTextView(Context context, AttributeSet attrs) {

        super(context, attrs);
    }

    public EmphasisTextView(Context context, AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setTextHighlightColor(String highlightColorHex) {

        this.highlightColor = Color.parseColor(highlightColorHex);
    }

    @Override
    public void setTextHighlightColor(int colorResource) {

        this.highlightColor = getResources().getColor(colorResource);
    }

    @Override
    public void setHighlightMode(HighlightMode highlightMode) {

        this.highlightMode = highlightMode;
    }

    @Override
    public void setTextToHighlight(String textToHighlight) {

        this.textToHighlight = textToHighlight;
    }

    @Override
    public void setCaseInsensitive(boolean caseInsensitive) {

        this.caseInsensitive = caseInsensitive;
    }

    @Override
    public void highlight() {

        if (textToHighlight == null) {
            throw new IllegalStateException("You must specify a text to highlight before using executing the highlight operation.");
        }
        if (highlightColor == 0) {
            throw new IllegalStateException("You must specify a color to highlight the text with before using executing the highlight operation.");
        }

        if (!TextUtils.isEmpty(getText()) && !textToHighlight.isEmpty()) {
            String text = getText().toString();
            Spannable spannableString = new SpannableString(text);
            Pattern pattern;
            if (caseInsensitive) {
                pattern = Pattern.compile(Pattern.quote(textToHighlight), Pattern.CASE_INSENSITIVE);
            } else {
                pattern = Pattern.compile(Pattern.quote(textToHighlight));
            }
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                CharacterStyle characterStyle;
                if (highlightMode == HighlightMode.BACKGROUND) {
                    characterStyle = new BackgroundColorSpan(highlightColor);
                } else {
                    characterStyle = new ForegroundColorSpan(highlightColor);
                }
                spannableString.setSpan(characterStyle, matcher.start(), matcher.end(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
            setText(spannableString);
        }
    }

}
