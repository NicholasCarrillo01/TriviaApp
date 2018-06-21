package com.example.nichilascarrillo.triviaapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Question implements Parcelable{


    private String question;
    private String correctAnswer;
    private String firstWrongAnswer;
    private String secondWrongAnswer;
    private String thirdWrongAnswer;


    public Question(String question, String correctAnswer, String firstWrongAnswer, String secondWrongAnswer, String thirdWrongAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.firstWrongAnswer = firstWrongAnswer;
        this.secondWrongAnswer = secondWrongAnswer;
        this.thirdWrongAnswer = thirdWrongAnswer;
    }


    protected Question(Parcel in) {
        question = in.readString();
        correctAnswer = in.readString();
        firstWrongAnswer = in.readString();
        secondWrongAnswer = in.readString();
        thirdWrongAnswer = in.readString();
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(question);
        parcel.writeString(correctAnswer);
        parcel.writeString(firstWrongAnswer);
        parcel.writeString(secondWrongAnswer);
        parcel.writeString(thirdWrongAnswer);
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getFirstWrongAnswer() {
        return firstWrongAnswer;
    }

    public String getSecondWrongAnswer() {
        return secondWrongAnswer;
    }

    public String getThirdWrongAnswer() {
        return thirdWrongAnswer;
    }
}


