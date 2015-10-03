package com.topantidevelopers.emphasis;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannedString;
import android.text.style.BackgroundColorSpan;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowApplication;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(RobolectricTestRunner.class)
public class EmphasisTextViewTest {

    // Test specific fields.
    private final Context context = ShadowApplication.getInstance().getApplicationContext();

    // Text View specific fields.
    private EmphasisTextView emphasisTextView;

    @Before
    public void setUp() {
        emphasisTextView = new EmphasisTextView(context);
    }

    @Test
    public void singleMatchCaseSensitiveTest() {
        emphasisTextView.setText("saladSALAD");
        emphasisTextView.setTextToHighlight("sa");
        emphasisTextView.setHighlightColor("#ff3393b4");
        emphasisTextView.highlight();

        final BackgroundColorSpan[] highlightSpans = ((SpannedString) emphasisTextView.getText()).getSpans(0, emphasisTextView.getText().length(),
                BackgroundColorSpan.class);
        assertThat("There should only be one highlighted area", highlightSpans.length, equalTo(1));
        assertThat("Text is highlighted with wrong color.", highlightSpans[0].getBackgroundColor(),
                equalTo(Color.parseColor("#ff3393b4")));
    }

    @Test
    public void defaultColorHighlightTest() {
        emphasisTextView.setText("saladSALAD");
        emphasisTextView.setTextToHighlight("sa");
        emphasisTextView.highlight();

        final BackgroundColorSpan[] highlightSpans = ((SpannedString) emphasisTextView.getText()).getSpans(0, emphasisTextView.getText().length(),
                BackgroundColorSpan.class);
        assertThat("There should only be one highlighted area", highlightSpans.length, equalTo(1));
        assertThat("Text is highlighted with wrong color.", highlightSpans[0].getBackgroundColor(),
                equalTo(Color.parseColor(EmphasisTextView.DEFAULT_HIGHTLIGHT_COLOR)));
    }

    @Test
    public void defaultTextHighlightTest() {
        emphasisTextView.setText("saladSALAD");
        emphasisTextView.highlight();

        final BackgroundColorSpan[] highlightSpans = ((SpannedString) emphasisTextView.getText()).getSpans(0, emphasisTextView.getText().length(),
                BackgroundColorSpan.class);
        assertThat("There should only be one highlighted area", highlightSpans.length, equalTo(1));
    }

    @Test
    public void multipleMatchesCaseSensitiveTest() {
        emphasisTextView.setText("saladsalad");
        emphasisTextView.setTextToHighlight("sa");
        emphasisTextView.setHighlightColor("#ff3393b4");
        emphasisTextView.setCaseInsensitive(true);
        emphasisTextView.highlight();

        final BackgroundColorSpan[] highlightSpans = ((SpannedString) emphasisTextView.getText()).getSpans(0, emphasisTextView.getText().length(),
                BackgroundColorSpan.class);
        assertThat("There should only be one highlighted area", highlightSpans.length, equalTo(2));
        assertThat("Text is highlighted with wrong color.", highlightSpans[0].getBackgroundColor(),
                equalTo(Color.parseColor("#ff3393b4")));
    }

    @Test
    public void multipleMatchesCaseInsensitiveTest() {
        emphasisTextView.setText("saladSaladSALAD");
        emphasisTextView.setTextToHighlight("SA");
        emphasisTextView.setHighlightColor("#ff3393b4");
        emphasisTextView.setCaseInsensitive(true);
        emphasisTextView.highlight();

        final BackgroundColorSpan[] highlightSpans = ((SpannedString) emphasisTextView.getText()).getSpans(0, emphasisTextView.getText().length(),
                BackgroundColorSpan.class);
        assertThat("There should only be one highlighted area", highlightSpans.length, equalTo(3));
        assertThat("Text is highlighted with wrong color.", highlightSpans[0].getBackgroundColor(),
                equalTo(Color.parseColor("#ff3393b4")));
    }

    @Test
    public void highLightPlusSignTest() {
        emphasisTextView.setText("+301111111111");
        emphasisTextView.setTextToHighlight("+");
        emphasisTextView.setHighlightColor("#ff3393b4");
        emphasisTextView.highlight();

        final BackgroundColorSpan[] highlightSpans = ((SpannedString) emphasisTextView.getText()).getSpans(0, emphasisTextView.getText().length(),
                BackgroundColorSpan.class);
        assertThat("There should be 4 highlighted areas.", highlightSpans.length, equalTo(1));
        for (final BackgroundColorSpan backgroundColorSpan : highlightSpans) {
            assertThat("Text is highlighted with wrong color.", backgroundColorSpan.getBackgroundColor(),
                    equalTo(Color.parseColor("#ff3393b4")));
        }
    }

}
