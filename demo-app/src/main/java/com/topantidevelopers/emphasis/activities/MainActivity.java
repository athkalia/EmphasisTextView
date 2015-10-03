package com.topantidevelopers.emphasis.activities;

import android.app.Activity;
import com.topantidevelopers.emphasis.EmphasisTextView;
import com.topantidevelopers.emphasis.sample.R;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.main_activity)
public class MainActivity extends Activity {

    @ViewById(R.id.main_activity_first_text_view)
    EmphasisTextView firstEmphasisTextView;

    @ViewById(R.id.main_activity_second_text_view)
    EmphasisTextView secondEmphasisTextview;

    @ViewById(R.id.main_activity_third_text_view)
    EmphasisTextView thirdEmphasisTextView;

    @ViewById(R.id.main_activity_fourth_text_view)
    EmphasisTextView fourthEmphasisTextView;

    @ViewById(R.id.main_activity_fifth_text_view)
    EmphasisTextView fifthEmphasisTextView;

    @ViewById(R.id.main_activity_sixth_text_view)
    EmphasisTextView sixthEmphasisTextView;

    @AfterViews
    void afterViews() {
        setUpFirstEmphasisTextView();
        setUpSecondEmphasisTextView();
        setUpThirdEmphasisTextView();
        setUpFourthEmphasisTextView();
        setUpFifthEmphasisTextView();
        setUpSixthEmphasisTextView();
    }

    private void setUpFirstEmphasisTextView() {
        firstEmphasisTextView.setText("saladSALAD");
        firstEmphasisTextView.setTextToHighlight("sa");
        firstEmphasisTextView.setHighlightColor("#ff3393b4");
        firstEmphasisTextView.highlight();
    }

    private void setUpSecondEmphasisTextView() {
        secondEmphasisTextview.setText("saladSALAD");
        secondEmphasisTextview.setTextToHighlight("sa");
        secondEmphasisTextview.highlight();
    }

    private void setUpThirdEmphasisTextView() {
        thirdEmphasisTextView.setText("saladSALAD");
        thirdEmphasisTextView.highlight();
    }

    private void setUpFourthEmphasisTextView() {
        fourthEmphasisTextView.setText("saladsalad");
        fourthEmphasisTextView.setTextToHighlight("sa");
        fourthEmphasisTextView.setHighlightColor("#ff3393b4");
        fourthEmphasisTextView.setCaseInsensitive(true);
        fourthEmphasisTextView.highlight();
    }

    private void setUpFifthEmphasisTextView() {
        fifthEmphasisTextView.setText("saladSaladSALAD");
        fifthEmphasisTextView.setTextToHighlight("SA");
        fifthEmphasisTextView.setHighlightColor("#ff3393b4");
        fifthEmphasisTextView.setCaseInsensitive(true);
        fifthEmphasisTextView.highlight();
    }

    private void setUpSixthEmphasisTextView() {
        sixthEmphasisTextView.setText("+301111111111");
        sixthEmphasisTextView.setTextToHighlight("+");
        sixthEmphasisTextView.setHighlightColor("#ff3393b4");
        sixthEmphasisTextView.highlight();
    }

}
