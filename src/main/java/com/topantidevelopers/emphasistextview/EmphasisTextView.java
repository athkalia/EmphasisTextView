package com.topantidevelopers.emphasistextview;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmphasisTextView extends TextView {

    private int highlightColor = android.R.color.holo_red_light;

    public EmphasisTextView(final Context context) {
        super(context);
    }

    public EmphasisTextView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    public EmphasisTextView(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setTextWithHighlight(final String text, final String textToHighlight) {
        if (!textToHighlight.isEmpty()) {
            final Spannable spannableString = new SpannableString(text);
            final Pattern pattern = Pattern.compile(Pattern.quote(textToHighlight), Pattern.CASE_INSENSITIVE);
            final Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                final BackgroundColorSpan colorSpan = new BackgroundColorSpan(highlightColor);
                spannableString.setSpan(colorSpan, matcher.start(), matcher.end(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
            setText(spannableString);
        } else {
            setText(text);
        }
    }

}
