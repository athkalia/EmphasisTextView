package com.topantidevelopers.emphasis;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmphasisTextView extends TextView {

    private String highlightColor;
    private String textToHighlight;
    private boolean caseInsensitive;

    public static final String DEFAULT_HIGHTLIGHT_COLOR = "#FF00FFFF";

    public EmphasisTextView(final Context context) {
        super(context);
    }

    public EmphasisTextView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    public EmphasisTextView(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setHighlightColor(String highlightColor) {
        this.highlightColor = highlightColor;
    }

    public void setTextToHighlight(final String textToHighlight) {
        this.textToHighlight = textToHighlight;
    }

    public void setCaseInsensitive(boolean caseInsensitive) {
        this.caseInsensitive = caseInsensitive;
    }

    @SuppressWarnings("PMD.AvoidInstantiatingObjectsInLoops")
    public void highlight() {
        if (textToHighlight == null) {
            textToHighlight = getText().toString();
        }
        if (highlightColor == null) {
            highlightColor = DEFAULT_HIGHTLIGHT_COLOR;
        }

        final String text = getText().toString();
        if (!textToHighlight.isEmpty()) {
            final Spannable spannableString = new SpannableString(text);
            final Pattern pattern;
            if (caseInsensitive) {
                pattern = Pattern.compile(Pattern.quote(textToHighlight), Pattern.CASE_INSENSITIVE);
            } else {
                pattern = Pattern.compile(Pattern.quote(textToHighlight));
            }
            final Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                final BackgroundColorSpan colorSpan = new BackgroundColorSpan(Color.parseColor(highlightColor));
                spannableString.setSpan(colorSpan, matcher.start(), matcher.end(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
            setText(spannableString);
        }
    }

}
