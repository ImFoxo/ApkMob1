package com.example.asd;

public class Question {
    private int questionId;
    private boolean trueAnswer;
    private boolean answered = false;

    public Question (int questionId, boolean trueAnswer) {
        this.questionId = questionId;
        this.trueAnswer = trueAnswer;
    }

    public int getQuestionId() {
        return questionId;
    }
    public boolean getTrueAnswer() {
        return  trueAnswer;
    }
    public boolean getAnswered() {
        return answered;
    }

    public void setAnswered() {
        answered = true;
    }

}
