package ru.javarush.maxzaharov.webappquest.webappquest.servlets;


import ru.javarush.maxzaharov.webappquest.webappquest.Answer;
import ru.javarush.maxzaharov.webappquest.webappquest.Players;
import ru.javarush.maxzaharov.webappquest.webappquest.Quest;
import ru.javarush.maxzaharov.webappquest.webappquest.Question;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Objects.isNull;

@WebServlet(name = "questServlet", value = "/quest")
public class QuestServlet extends HttpServlet {
    Question currentQuestion;
    boolean finish;

    @Override
    public void init() throws ServletException {
        super.init();
        currentQuestion = new Quest().getStartQuestion();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("currentQuestion", currentQuestion.getText());
        req.setAttribute("finish", finish);
        req.setAttribute("ip", req.getRemoteAddr());
//        req.setAttribute("allPlayers", Players.ALL.get(req.getAttribute("name")).getGames());
        if (currentQuestion.isWin() || currentQuestion.isLoose()) {
            finish = true;
        } else {
            List<String> answers = new ArrayList<>();
            for (Answer answer : currentQuestion.getAnswers()) {
                answers.add(answer.getText());
            }
            req.setAttribute("answers", answers);
        }

        getServletContext().getRequestDispatcher("/quest.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!currentQuestion.isLoose() && !currentQuestion.isWin() && !isNull(req.getParameter("nextQuestion"))) {
            currentQuestion = currentQuestion
                    .getAnswers()
                    .get(Integer.parseInt(req.getParameter("nextQuestion")))
                    .getNextQuestion();
        }

        resp.sendRedirect("quest");

    }
}
