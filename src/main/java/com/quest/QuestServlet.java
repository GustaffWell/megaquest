package com.quest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="QuestServlet", value = "/quest")
public class QuestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession currentSession = req.getSession();
        currentSession.setAttribute("gamesCount", QuestLogic.getGamesCount());
        currentSession.setAttribute("winCount", QuestLogic.getWinCount());
        currentSession.setAttribute("loseCount", QuestLogic.getLoseCount());

        String answer = req.getParameter("answer");
        if (answer == null) {
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
            return;
        }
        QuestLogic.getByAnswer(answer);

        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
