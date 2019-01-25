package com.studies.quizzapp;

import android.graphics.Color;
import android.widget.Button;
import android.widget.TextView;

import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

@NonReusable
@Layout(R.layout.card_layout)
public class QuestionCard {

    @View(R.id.btn_option_1)
    public Button mOption1Button;

    @View(R.id.btn_option_2)
    public Button mOption2Button;

    @View(R.id.btn_option_3)
    public Button mOption3Button;

    @View(R.id.btn_option_4)
    public Button mOption4Button;

    private Question question;

    @View(R.id.tv_question_txt)
    public TextView questionTextView;

    public QuestionCard(Question question) {
        this.question = question;
    }

    @Click(R.id.btn_option_1)
    public void onOption1Click() {
        showCorrectOptions();
    }

    @Click(R.id.btn_option_2)
    public void onOption2Click() {
        showCorrectOptions();
    }

    @Click(R.id.btn_option_3)
    public void onOption3Click() {
        showCorrectOptions();
    }

    @Click(R.id.btn_option_4)
    public void onOption4Click() {
        showCorrectOptions();
    }

    @Resolve
    public void onResolved() {
        questionTextView.setText(question.getQuestion());
        if (question.mShowCorrectOptions) {
            showCorrectOptions();
        }

        mOption1Button.setText(question.getChoice1());
        mOption2Button.setText(question.getChoice2());
        mOption3Button.setText(question.getChoice3());
        mOption4Button.setText(question.getChoice4());
    }

    private void showCorrectOptions() {
        question.mShowCorrectOptions = true;
        for (int i = 1; i <= 4; i++) {
            int answer = Integer.parseInt(question.getAnswer());
            Button button = null;
            switch (i) {
                case 1:
                    button = mOption1Button;
                    break;
                case 2:
                    button = mOption2Button;
                    break;
                case 3:
                    button = mOption3Button;
                    break;
                case 4:
                    button = mOption4Button;
                    break;
            }
            if (button != null) {
                if (i == answer) {
                    button.setBackgroundColor(Color.GREEN);
                } else {
                    button.setBackgroundColor(Color.RED);
                }
            }
        }
    }
}
