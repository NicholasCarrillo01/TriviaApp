package com.example.nichilascarrillo.triviaapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.nichilascarrillo.triviaapp.MainActivity.QUESTIONS_LIST;

public class QuizFragment extends Fragment {


    @BindView(R.id.question_textview)
    protected TextView quizQuestion;


    @BindView(R.id.correct_answer_button)
    protected Button correctAnswerButton;

    @BindView(R.id.first_wrong_answer_button)
    protected Button wrongAnswerButtonOne;

    @BindView(R.id.second_wrong_answer_button)
    protected Button wrongAnswerButtonTwo;

    @BindView(R.id.third_wrong_answer_button)
    protected Button wrongAnswerButtonThree;

    @BindView(R.id.next_question_button)
    protected Button nextQuestionButtonone;

    private List<Question> questionList;
    private Question question;
    private int questionListPosition = 0;
    private int correctAnswers = 0;
    private QuizCallback quizCallback;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_quiz, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public static QuizFragment newInstance() {

        Bundle args = new Bundle();

        QuizFragment fragment = new QuizFragment();
        fragment.setArguments(args);
        return fragment;


    }

    @Override
    public void onStart() {
        super.onStart();

        questionList = getArguments().getParcelableArrayList(QUESTIONS_LIST);


        populateQuizContent();
    }

    private void populateQuizContent() {
        question = questionList.get(questionListPosition);
        quizQuestion.setText(question.getQuestion());

        List<Button> buttonList = new ArrayList<>();
        buttonList.add(correctAnswerButton);
        buttonList.add(wrongAnswerButtonOne);
        buttonList.add(wrongAnswerButtonTwo);
        buttonList.add(wrongAnswerButtonThree);


        List<String> possibleAnswerList = new ArrayList<>();
        possibleAnswerList.add(question.getCorrectAnswer());
        possibleAnswerList.add(question.getFirstWrongAnswer());
        possibleAnswerList.add(question.getSecondWrongAnswer());
        possibleAnswerList.add(question.getThirdWrongAnswer());

        for (Button button : buttonList) {

//            creates random number list that will allow us to pick an answer from our arraylist
            int random = (int) Math.ceil(Math.random() * (possibleAnswerList.size() - 1));


            button.setText(possibleAnswerList.get(random));

            possibleAnswerList.remove(random);

        }

    }

    private void checkAnswer(String answer) {
//        increments questionlistposition so we can go to the next question
        questionListPosition++;
//    set the textview to show the user the correct
        if (question.getCorrectAnswer().equals(answer)) {
            quizQuestion.setText(R.string.correct);
//       increments the correct answers the user has gotten
            correctAnswers++;
        } else {
            quizQuestion.setText(getString(R.string.wrong_answer_text, question.getCorrectAnswer()));
        }
    }


    @OnClick(R.id.correct_answer_button)
    protected void buttonzeroClicked() {

        checkAnswer(correctAnswerButton.getText().toString());

    }

    @OnClick(R.id.first_wrong_answer_button)
    protected void buttonOneClicked() {

        checkAnswer(wrongAnswerButtonOne.getText().toString());
    }

    @OnClick(R.id.second_wrong_answer_button)
    protected void buttonTwoClicked() {

        checkAnswer(wrongAnswerButtonTwo.getText().toString());
    }

    @OnClick(R.id.third_wrong_answer_button)
    protected void thirdWrongAnswerButton() {

        checkAnswer(wrongAnswerButtonThree.getText().toString());
    }

    @OnClick(R.id.next_question_button)
    protected void nextQuestionButton() {

        if (questionListPosition <= questionList.size() - 1) {
            populateQuizContent();

        } else {
//           handling no more questions, taking user back to mainactivity
          quizCallback.quizFinished(correctAnswers);


        }
    }

    private void  disableAnswerButton() {
        correctAnswerButton.setEnabled(false);
        wrongAnswerButtonOne.setEnabled(false);
        wrongAnswerButtonTwo.setEnabled(false);
        wrongAnswerButtonThree.setEnabled(false);
    }

    private void enableAnswerButton() {
        correctAnswerButton.setEnabled(true);
        wrongAnswerButtonOne.setEnabled(true);
        wrongAnswerButtonTwo.setEnabled(true);
        wrongAnswerButtonThree.setEnabled(true);
    }

    public void attachParent (QuizCallback quizCallback) {
        this.quizCallback = quizCallback;
    }

    public interface QuizCallback {
        void quizFinished(int correctAnswers);
    }


}
