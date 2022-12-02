package com.quest;

import java.util.ArrayList;
import java.util.List;

public class QuestLogic {
    private static String currentQuestion = AnswerQuestionBank.question1;
    private static List<String> answerOptions = new ArrayList<String>();
    static {
        answerOptions.add(AnswerQuestionBank.question1Answer1);
        answerOptions.add(AnswerQuestionBank.question1Answer2);
    }

    private static int gamesCount = 0;
    private static int winCount = 0;
    private static int loseCount = 0;

    public static void getByAnswer(String answer) {

        if (answer.equals(AnswerQuestionBank.question1Answer1)) {
            currentQuestion = AnswerQuestionBank.question2;

            answerOptions.clear();
            answerOptions.add(AnswerQuestionBank.question2Answer1);
            answerOptions.add(AnswerQuestionBank.question2Answer2);
            return;
        }

        if (answer.equals(AnswerQuestionBank.question1Answer2)) {
            loseCount++;
            gamesCount++;
            currentQuestion = AnswerQuestionBank.gg1;

            answerOptions.clear();
            answerOptions.add(AnswerQuestionBank.restart);
            return;
        }

        if (answer.equals(AnswerQuestionBank.question2Answer1)) {
            currentQuestion = AnswerQuestionBank.question3;

            answerOptions.clear();
            answerOptions.add(AnswerQuestionBank.question3Answer1);
            answerOptions.add(AnswerQuestionBank.question3Answer2);
            return;
        }

        if (answer.equals(AnswerQuestionBank.question2Answer2)) {
            loseCount++;
            gamesCount++;
            currentQuestion = AnswerQuestionBank.gg2;

            answerOptions.clear();
            answerOptions.add(AnswerQuestionBank.restart);
            return;
        }

        if (answer.equals(AnswerQuestionBank.question3Answer1)) {
            winCount++;
            gamesCount++;
            currentQuestion = AnswerQuestionBank.win;

            answerOptions.clear();
            answerOptions.add(AnswerQuestionBank.restart);
            return;
        }

        if (answer.equals(AnswerQuestionBank.question3Answer2)) {
            loseCount++;
            gamesCount++;
            currentQuestion = AnswerQuestionBank.gg3;

            answerOptions.clear();
            answerOptions.add(AnswerQuestionBank.restart);
        }

        if (answer.equals(AnswerQuestionBank.restart)) {
            currentQuestion = AnswerQuestionBank.question1;

            answerOptions.clear();
            answerOptions.add(AnswerQuestionBank.question1Answer1);
            answerOptions.add(AnswerQuestionBank.question1Answer2);
        }
    }

    public static String getCurrentQuestion() {
        return currentQuestion;
    }

    public static List<String> getAnswerOption() {
        return answerOptions;
    }

    public static int getGamesCount() {
        return gamesCount;
    }

    public static int getWinCount() {
        return winCount;
    }

    public static int getLoseCount() {
        return loseCount;
    }

}
