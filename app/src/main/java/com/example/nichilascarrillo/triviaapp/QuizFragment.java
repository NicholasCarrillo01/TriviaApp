package com.example.nichilascarrillo.triviaapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuizFragment extends Fragment {


    @BindView(R.id.correct_answer_button)
    protected void buttonOneClicked() {

    }

    @BindView(R.id.first_wrong_answer_button)
    protected void buttonTwoClicked() {

    }

    @BindView(R.id.second_wrong_answer_button)
    protected void buttonTwoClicked() {

    }

    @BindView(R.id.third_wrong_answer_button)
    protected void thirdWrongAnswerButton() {

    }

    @BindView(R.id.next_question_button)
    protected void nextQuestionButton() {

    }


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


}
