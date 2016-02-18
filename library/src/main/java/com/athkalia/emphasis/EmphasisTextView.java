package com.athkalia.emphasis;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmphasisTextView extends TextView {

    private int highlightColor;

    private String textToHighlight;

    private boolean caseInsensitive;

    public EmphasisTextView(final Context context) {
        super(context);
    }

    public EmphasisTextView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    public EmphasisTextView(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * Set the color that you want to highlight your text with. This accepts a Hex String starting
     * with '#' and then 2 values for transparency, 2 for Red color, 2 for Green color and 2 for Blue.
     *
     * Example: '#FF00FF00' for Green, or '#FF000000' for black.
     */
    public void setTextHighlightColor(String highlightColorHex) {
        this.highlightColor = Color.parseColor(highlightColorHex);
    }

    /**
     * Set the color that you want to highlight your text with. This accepts a color resource id.
     *
     * Example: 'android.R.color.black'
     */
    public void setTextHighlightColor(int colorResource) {
        this.highlightColor = getResources().getColor(colorResource);
    }

    /**
     * Set the text that should be searched for and highlighted in the TextView.
     */
    public void setTextToHighlight(final String textToHighlight) {
        this.textToHighlight = textToHighlight;
    }

    /**
     * Enable or disable case sensitivity while looking for Strings to highlight.
     */
    public void setCaseInsensitive(boolean caseInsensitive) {
        this.caseInsensitive = caseInsensitive;
    }

    /**
     * Run the highlighting operation. Searches through the text that is set in the TextView via
     * {@link TextView#setText(CharSequence)} for occurrences of the text the text that needs to be
     * highlighted (that is declared via  {@link #setTextToHighlight(String)} and then highlights it
     * with the color defined in {@link #setTextHighlightColor(int)} or {@link #setTextHighlightColor(String)}.
     */
    public void highlight() {
        if (textToHighlight == null) {
            throw new IllegalStateException("You must specify a text to highlight before using executing the highlight operation.");
        }
        if (highlightColor == 0) {
            throw new IllegalStateException("You must specify a color to highlight the text with before using executing the highlight operation.");
        }

        if (!TextUtils.isEmpty(getText()) && !textToHighlight.isEmpty()) {
            final String text = getText().toString();
            final Spannable spannableString = new SpannableString(text);
            final Pattern pattern;
            if (caseInsensitive) {
                pattern = Pattern.compile(Pattern.quote(textToHighlight), Pattern.CASE_INSENSITIVE);
            } else {
                pattern = Pattern.compile(Pattern.quote(textToHighlight));
            }
            final Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                final BackgroundColorSpan colorSpan = new BackgroundColorSpan(highlightColor);
                spannableString.setSpan(colorSpan, matcher.start(), matcher.end(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
            setText(spannableString);
        }
    }

}
