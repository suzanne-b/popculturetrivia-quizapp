package com.example.quizzapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {




    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when a button is chosen
     */
     //Choose question one.
    public void submitScore (View view ){
        int correctAnswers =0;
        RadioGroup questionOne = findViewById(R.id.question_one_radio_group);
        RadioButton questionOneCorrectAnswer = findViewById(R.id.question_one_answer_radio_button);
        if (questionOneCorrectAnswer.isChecked()) {
            correctAnswers++;
        }

     //Choose question two.
        RadioGroup questionTwo =findViewById(R.id.question_two_radio_group);
        RadioButton questionTwoCorrectAnswer = findViewById(R.id.question_two_answer_radio_button);
        if (questionTwoCorrectAnswer.isChecked()){
            correctAnswers++;
        }

     //Choose question three.
        RadioGroup questionThree =findViewById(R.id.question_three_radio_group);
        RadioButton questionThreeCorrectAnswer = findViewById(R.id.question_three_answer_radio_button);
        if (questionOneCorrectAnswer.isChecked()){
            correctAnswers++;
        }

     //Choose question four.
        RadioGroup questionFour =findViewById(R.id.question_four_radio_group);
        RadioButton questionFourCorrectAnswer = findViewById(R.id.question_four_answer_radio_button);
        if (questionFourCorrectAnswer.isChecked()){
            correctAnswers++;
        }

        //Check question five with text input
        if (this.checkQuestionFive()) {
            correctAnswers++;
        }

        //Check question six with checkboxes
        if (this.checkQuestionSix()) {
            correctAnswers++;
        }

        //Show all results.
        showAllResults(correctAnswers);
    }

    private boolean checkQuestionSix() {
        CheckBox firstOption = findViewById(R.id.first_option_question_six_check_box);
        CheckBox secondOption = findViewById(R.id.second_option_question_six_check_box);
        CheckBox incorrectAnswer = findViewById(R.id.question_six_incorrect_check_box);
        if (firstOption.isChecked() && secondOption.isChecked() && !(incorrectAnswer.isChecked())){
            return true;
        }
        return false;
    }

    /**
     * This method is for the Toast message.
     * @param correctAnswers  user get when they  play the trivia.
     */
    private void showAllResults (int correctAnswers){
        int numberOfQuestions =6;
        String message;
        if (correctAnswers == 0){
            message = getString(R.string.toastMessageNone);
        }else if (correctAnswers == 1){
            message = getString(R.string.toastMessageForOne, correctAnswers,  numberOfQuestions);
        }else if (correctAnswers == numberOfQuestions){
            message = getString(R.string.toastMessageCorrect);
        } else {
            message = getString(R.string.toastMessageMoreThanOne, correctAnswers,  numberOfQuestions);
        }
     // Show the results in a  Toast message.
        Toast.makeText(this, message,  Toast.LENGTH_LONG).show();
    }

    /**
     *This method checks if the right input is put in.
     * @return Will come back true if the right inout is used.
     */
    private boolean checkQuestionFive () {
        EditText editTextQ5answer = findViewById(R.id.questionFiveAnswer);
        String stringQ5Answer = editTextQ5answer.getText().toString();
        boolean correctQ5 = "Peach".equals(stringQ5Answer);
        if (correctQ5) {
            return true;
        }
        return  false;
    }


}


