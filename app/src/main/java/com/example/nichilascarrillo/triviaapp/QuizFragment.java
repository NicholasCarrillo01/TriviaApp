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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QuizFragment extends Fragment {


    @BindView(R.id.correct_answer_button)
    protected Button correctAnswerButton;

    @BindView(R.id.first_wrong_answer_button)
    protected Button wrongAnswerButtonOne;

    @BindView(R.id.second_wrong_answer_button)
    protected Button WrongAnswerButtonTwo;

    @BindView(R.id.third_wrong_answer_button)
    protected Button WrongAnswerButtonThree;

    @BindView(R.id.next_question_button)
    protected Button nextQuestionButtonone;



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

    @OnClick(R.id.correct_answer_button)
    protected void buttonzeroClicked() {

    }

    @OnClick(R.id.first_wrong_answer_button)
    protected void buttonOneClicked() {

    }

    @OnClick(R.id.second_wrong_answer_button)
    protected void buttonTwoClicked() {

    }

    @OnClick(R.id.third_wrong_answer_button)
    protected void thirdWrongAnswerButton() {

    }

    @OnClick(R.id.next_question_button)
    protected void nextQuestionButton() {

    }


}
