package org.pattersonclippers.quizappsummer2023;

public class Question {
    private String qPrompt;
    private boolean correctAnswer;

    public Question(String qPrompt, boolean correctAnswer) {
        this.qPrompt = qPrompt;
        this.correctAnswer = correctAnswer;
    }

    public String getqPrompt() {
        return qPrompt;
    }

    public void setqPrompt(String qPrompt) {
        this.qPrompt = qPrompt;
    }

    public boolean getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "qPrompt='" + qPrompt + '\'' +
                ", correctAnswer=" + correctAnswer +
                '}';
    }
}
