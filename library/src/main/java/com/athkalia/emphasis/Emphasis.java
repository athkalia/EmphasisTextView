package com.athkalia.emphasis;

import android.widget.TextView;

public interface Emphasis {

    /**
     * Set the color that you want to highlight your text with. This accepts a Hex String starting
     * with '#' and then 2 values for transparency, 2 for Red color, 2 for Green color and 2 for Blue.
     *
     * Example: '#FF00FF00' for Green, or '#FF000000' for black.
     */
    void setTextHighlightColor(String highlightColorHex);

    /**
     * Set the color that you want to highlight your text with. This accepts a color resource id.
     *
     * Example: 'android.R.color.black'
     */
    void setTextHighlightColor(int colorResource);

    /**
     * Whether to highlight background of text or change the color of the text itself.
     * Default highlight mode is to highlight the background instead of changing the color of the text.
     */
    void setHighlightMode(HighlightMode highlightMode);

    /**
     * Set the text that should be searched for and highlighted in the TextView.
     */
    void setTextToHighlight(String textToHighlight);

    /**
     * Enable or disable case sensitivity while looking for Strings to highlight.
     */
    void setCaseInsensitive(boolean caseInsensitive);

    /**
     * Run the highlighting operation. Searches through the text that is set in the TextView via
     * {@link TextView#setText(CharSequence)} for occurrences of the text the text that needs to be
     * highlighted (that is declared via  {@link #setTextToHighlight(String)} and then highlights it
     * with the color defined in {@link #setTextHighlightColor(int)} or {@link #setTextHighlightColor(String)}.
     */
    void highlight();

}
