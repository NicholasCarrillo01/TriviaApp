package com.example.nichilascarrillo.triviaapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QuestionCreatorFragment extends Fragment {


    @BindView(R.id.question_edittext)
    protected EditText question;
    @BindView(R.id.correct_answer_edittext)
    protected EditText correctanswer;
    @BindView(R.id.first_wrong_answer_edittext)
    protected EditText firstwronganswerInput;
    @BindView(R.id.second_wrong_answer_editext)
    protected EditText secondwronganswerinput;
    @BindView(R.id.third_wrong_answer_edittext)
    protected EditText thirdWrongAnswerinput;
    ;
    private Callback callback;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question_creator, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public static QuestionCreatorFragment newInstance() {

        Bundle args = new Bundle();

        QuestionCreatorFragment fragment = new QuestionCreatorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @OnClick(R.id.save_question_button)
    protected void addQuestion() {

        if (question.getText().toString().isEmpty() || correctanswer.getText().toString().isEmpty() ||
                firstwronganswerInput.getText().toString().isEmpty() || secondwronganswerinput.getText().toString().isEmpty() ||
                thirdWrongAnswerinput.getText().toString().isEmpty()
                ) {

            Toast.makeText(getActivity(), "All fields are required!", Toast.LENGTH_SHORT).show();
        } else {


            //  gets user input from the edittext and saves them as a variable
            String questionTitle = question.getText().toString();
            String correctAnswer = correctanswer.getText().toString();
            String firstWrongAnswer = firstwronganswerInput.getText().toString();
            String secondWrongAnswer = secondwronganswerinput.getText().toString();
            String thirdWongAnswer = thirdWrongAnswerinput.getText().toString();


            Question question = new Question(questionTitle, correctAnswer, firstWrongAnswer, secondWrongAnswer, thirdWongAnswer);
//  sends question object we just created to the callback method to be saved
            callback.questionSaved(question);
        }
    }


    public void attachParent(Callback callback) {
        this.callback = callback;
    }


    public interface Callback {


        void questionSaved(Question question);

    }

}

