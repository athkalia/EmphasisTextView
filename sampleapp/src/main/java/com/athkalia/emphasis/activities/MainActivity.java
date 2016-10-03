package com.athkalia.emphasis.activities;

import android.app.Activity;
import com.athkalia.emphasis.EmphasisTextView;
import com.athkalia.emphasis.HighlightMode;
import com.athkalia.emphasis.sample.R;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.main_activity)
public class MainActivity extends Activity {

    @ViewById(R.id.main_activity_first_text_view) EmphasisTextView firstEmphasisTextView;
    @ViewById(R.id.main_activity_second_text_view) EmphasisTextView secondEmphasisTextView;
    @ViewById(R.id.main_activity_third_text_view) EmphasisTextView thirdEmphasisTextView;
    @ViewById(R.id.main_activity_fourth_text_view) EmphasisTextView fourthEmphasisTextView;
    @ViewById(R.id.main_activity_fifth_text_view) EmphasisTextView fifthEmphasisTextView;
    @ViewById(R.id.main_activity_sixth_text_view) EmphasisTextView sixthEmphasisTextView;
    @ViewById(R.id.main_activity_seventh_text_view) EmphasisTextView seventhEmphasisTextView;

    @AfterViews
    void afterViews() {

        setUpFirstEmphasisTextView();
        setUpSecondEmphasisTextView();
        setUpThirdEmphasisTextView();
        setUpThirdEmphasisTextView();
        setUpFourthEmphasisTextView();
        setUpFifthEmphasisTextView();
        setUpSixthEmphasisTextView();
        setUpSeventhEmphasisTextView();
    }

    private void setUpFirstEmphasisTextView() {

        firstEmphasisTextView.setText("saladSALAD");
        firstEmphasisTextView.setTextToHighlight("sa");
        firstEmphasisTextView.setTextHighlightColor("#ff3393b4");
        firstEmphasisTextView.highlight();
    }

    private void setUpSecondEmphasisTextView() {

        secondEmphasisTextView.setText("saladSALAD");
        secondEmphasisTextView.setTextToHighlight("sa");
        secondEmphasisTextView.setTextHighlightColor(android.R.color.black);
        secondEmphasisTextView.highlight();
    }

    private void setUpThirdEmphasisTextView() {

        thirdEmphasisTextView.setText("saladsalad");
        thirdEmphasisTextView.setTextToHighlight("sa");
        thirdEmphasisTextView.setTextHighlightColor("#ffff0000");
        thirdEmphasisTextView.setCaseInsensitive(true);
        thirdEmphasisTextView.highlight();
    }

    private void setUpFourthEmphasisTextView() {

        fourthEmphasisTextView.setText("saladSaladSALAD");
        fourthEmphasisTextView.setTextToHighlight("SA");
        fourthEmphasisTextView.setTextHighlightColor("#ff00ff00");
        fourthEmphasisTextView.setCaseInsensitive(true);
        fourthEmphasisTextView.highlight();
    }

    private void setUpFifthEmphasisTextView() {

        fifthEmphasisTextView.setText("+301111111111");
        fifthEmphasisTextView.setTextToHighlight("+");
        fifthEmphasisTextView.setTextHighlightColor("#ff00ffff");
        fifthEmphasisTextView.highlight();
    }

    private void setUpSixthEmphasisTextView() {

        sixthEmphasisTextView.setText("pizzazzZ");
        sixthEmphasisTextView.setTextToHighlight("z");
        sixthEmphasisTextView.setTextHighlightColor(android.R.color.holo_green_light);
        sixthEmphasisTextView.setCaseInsensitive(false);
        sixthEmphasisTextView.setHighlightMode(HighlightMode.TEXT);
        sixthEmphasisTextView.highlight();
    }

    private void setUpSeventhEmphasisTextView() {

        seventhEmphasisTextView.setText("SaldZongLALALA");
        seventhEmphasisTextView.setTextToHighlight("A");
        seventhEmphasisTextView.setHighlightMode(HighlightMode.TEXT);
        seventhEmphasisTextView.setTextHighlightColor(android.R.color.holo_red_dark);
        seventhEmphasisTextView.highlight();
    }

}
