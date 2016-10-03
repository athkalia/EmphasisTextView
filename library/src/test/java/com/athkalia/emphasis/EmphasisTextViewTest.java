package com.athkalia.emphasis;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannedString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class EmphasisTextViewTest {

    // Test specific fields.
    private final Context context = ShadowApplication.getInstance().getApplicationContext();

    // Text View specific fields.
    private EmphasisTextView emphasisTextView;

    @Before
    public void setUp() {

        emphasisTextView = new EmphasisTextView(context);
    }

    @Test(expected = IllegalStateException.class)
    public void givenTheHighlightColorIsNotSet_WhenHighlightIsExecuted_ThenAnExceptionIsThrown() {

        emphasisTextView.setText("saladSALAD");
        emphasisTextView.setTextToHighlight("sa");
        emphasisTextView.highlight();
    }

    @Test(expected = IllegalStateException.class)
    public void givenTheHighlightTextIsNotSet_WhenHighlightIsExecuted_ThenAnExceptionIsThrown() {

        emphasisTextView.setText("saladSALAD");
        emphasisTextView.setTextHighlightColor("#ff3393b4");
        emphasisTextView.highlight();
    }

    @Test
    public void highlightWithResourceColorIdTest() {

        emphasisTextView.setText("saladSALAD");
        emphasisTextView.setTextToHighlight("sa");
        emphasisTextView.setTextHighlightColor(android.R.color.black);
        emphasisTextView.highlight();

        final BackgroundColorSpan[] highlightSpans = ((SpannedString) emphasisTextView.getText()).getSpans(0, emphasisTextView.getText().length(),
                BackgroundColorSpan.class);
        assertThat("There should only be one highlighted area", highlightSpans.length, equalTo(1));
        assertThat("Text is highlighted with wrong color.", highlightSpans[0].getBackgroundColor(),
                equalTo(context.getResources().getColor(android.R.color.black)));
    }

    @Test
    public void singleMatchCaseSensitiveTest() {

        emphasisTextView.setText("saladSALAD");
        emphasisTextView.setTextToHighlight("sa");
        emphasisTextView.setTextHighlightColor("#ff3393b4");
        emphasisTextView.highlight();

        final BackgroundColorSpan[] highlightSpans = ((SpannedString) emphasisTextView.getText()).getSpans(0, emphasisTextView.getText().length(),
                BackgroundColorSpan.class);
        assertThat("There should only be one highlighted area", highlightSpans.length, equalTo(1));
        assertThat("Text is highlighted with wrong color.", highlightSpans[0].getBackgroundColor(), equalTo(Color.parseColor("#ff3393b4")));
    }

    @Test
    public void multipleMatchesCaseSensitiveTest() {

        emphasisTextView.setText("saladsalad");
        emphasisTextView.setTextToHighlight("sa");
        emphasisTextView.setTextHighlightColor("#ff3393b4");
        emphasisTextView.setCaseInsensitive(true);
        emphasisTextView.highlight();

        final BackgroundColorSpan[] highlightSpans = ((SpannedString) emphasisTextView.getText()).getSpans(0, emphasisTextView.getText().length(),
                BackgroundColorSpan.class);
        assertThat("There should only be two highlighted areas", highlightSpans.length, equalTo(2));
        assertThat("Text is highlighted with wrong color.", highlightSpans[0].getBackgroundColor(), equalTo(Color.parseColor("#ff3393b4")));
    }

    @Test
    public void multipleMatchesCaseInsensitiveTest() {

        emphasisTextView.setText("saladSaladSALAD");
        emphasisTextView.setTextToHighlight("SA");
        emphasisTextView.setTextHighlightColor("#ff3393b4");
        emphasisTextView.setCaseInsensitive(true);
        emphasisTextView.highlight();

        final BackgroundColorSpan[] highlightSpans = ((SpannedString) emphasisTextView.getText()).getSpans(0, emphasisTextView.getText().length(),
                BackgroundColorSpan.class);
        assertThat("There should only be three highlighted areas", highlightSpans.length, equalTo(3));
        assertThat("Text is highlighted with wrong color.", highlightSpans[0].getBackgroundColor(), equalTo(Color.parseColor("#ff3393b4")));
    }

    @Test
    public void highLightPlusSignTest() {

        emphasisTextView.setText("+301111111111");
        emphasisTextView.setTextToHighlight("+");
        emphasisTextView.setTextHighlightColor("#ff3393b4");
        emphasisTextView.highlight();

        final BackgroundColorSpan[] highlightSpans = ((SpannedString) emphasisTextView.getText()).getSpans(0, emphasisTextView.getText().length(),
                BackgroundColorSpan.class);
        assertThat("There should be only one highlighted area.", highlightSpans.length, equalTo(1));
        for (final BackgroundColorSpan backgroundColorSpan : highlightSpans) {
            assertThat("Text is highlighted with wrong color.", backgroundColorSpan.getBackgroundColor(), equalTo(Color.parseColor("#ff3393b4")));
        }
    }

    @Test
    public void multipleMatchesCaseInsensitiveTextColorTest() {

        emphasisTextView.setText("pizzazzZ");
        emphasisTextView.setTextToHighlight("z");
        emphasisTextView.setTextHighlightColor(android.R.color.holo_green_light);
        emphasisTextView.setCaseInsensitive(false);
        emphasisTextView.setHighlightMode(HighlightMode.TEXT);
        emphasisTextView.highlight();

        final ForegroundColorSpan[] highlightSpans = ((SpannedString) emphasisTextView.getText()).getSpans(0, emphasisTextView.getText().length(),
                ForegroundColorSpan.class);
        assertThat("There should only be four highlighted areas", highlightSpans.length, equalTo(4));
        assertThat("Text is colored with wrong color.", highlightSpans[0].getForegroundColor(), equalTo(Color.parseColor("#ff99cc00")));
    }

}
