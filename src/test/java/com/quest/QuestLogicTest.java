package com.quest;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mockStatic;

public class QuestLogicTest {

    @Test
    public void getAnswerOption() {
        try (MockedStatic<QuestLogic> mockedStatic = mockStatic(QuestLogic.class)) {
            List<String> list = new ArrayList<>();
            list.add(AnswerQuestionBank.question2Answer1);
            list.add(AnswerQuestionBank.question2Answer2);
            mockedStatic.when(() -> QuestLogic.getAnswerOption()).thenReturn(list);

            QuestLogic.getByAnswer(AnswerQuestionBank.question1Answer1);

            assertEquals(list, QuestLogic.getAnswerOption());
        }
    }

    @Test
    public void getCurrentQuestion() {
        try (MockedStatic<QuestLogic> mockedStatic = mockStatic(QuestLogic.class)) {
            String question = AnswerQuestionBank.question2;
            mockedStatic.when(() -> QuestLogic.getCurrentQuestion()).thenReturn(question);

            QuestLogic.getByAnswer(AnswerQuestionBank.question1Answer1);

            assertEquals(question, QuestLogic.getCurrentQuestion());
        }
    }

    @Test
    public void getGamesCount() {
        try (MockedStatic<QuestLogic> mockedStatic = mockStatic(QuestLogic.class)) {
            mockedStatic.when(() -> QuestLogic.getGamesCount()).thenReturn(1);

            QuestLogic.getByAnswer(AnswerQuestionBank.question3Answer1);

            assertEquals(1, QuestLogic.getGamesCount());
        }
    }

    @Test
    public void getWinCount() {
        try (MockedStatic<QuestLogic> mockedStatic = mockStatic(QuestLogic.class)) {
            mockedStatic.when(() -> QuestLogic.getWinCount()).thenReturn(1);

            QuestLogic.getByAnswer(AnswerQuestionBank.question3Answer1);

            assertEquals(1, QuestLogic.getWinCount());
        }
    }

    @Test
    public void getLoseCount() {
        try (MockedStatic<QuestLogic> mockedStatic = mockStatic(QuestLogic.class)) {
            mockedStatic.when(() -> QuestLogic.getLoseCount()).thenReturn(1);

            QuestLogic.getByAnswer(AnswerQuestionBank.question1Answer2);

            assertEquals(1, QuestLogic.getLoseCount());
        }
    }
}
