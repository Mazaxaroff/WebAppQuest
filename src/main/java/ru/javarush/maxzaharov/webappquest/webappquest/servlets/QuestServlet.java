package ru.javarush.maxzaharov.webappquest.webappquest.servlets;


import ru.javarush.maxzaharov.webappquest.webappquest.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@WebServlet(name = "questServlet", value = "/quest")
public class QuestServlet extends HttpServlet {
    Question currentQuestion;
    boolean finish;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        currentQuestion = new Quest().getStartQuestion();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Player player = (Player) req.getSession().getAttribute("player");
        req.setAttribute("currentQuestion", currentQuestion.getText());
        req.setAttribute("ip", player.getIp());
        req.setAttribute("nameOfPlayer", player.getName());

        if (currentQuestion.isWin() || currentQuestion.isLoose()) {
            finish = true;
            player.incrementGames();
        } else {
            List<String> answers = new ArrayList<>();
            for (Answer answer : currentQuestion.getAnswers()) {
                answers.add(answer.getText());
            }
            req.setAttribute("answers", answers);
        }

        req.setAttribute("finish", finish);
        req.setAttribute("countOfGames", player.getGames());
        getServletContext().getRequestDispatcher("/quest.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!currentQuestion.isLoose() && !currentQuestion.isWin() && !isNull(req.getParameter("nextQuestion"))) {
            currentQuestion = currentQuestion
                    .getAnswers()
                    .get(Integer.parseInt(req.getParameter("nextQuestion")))
                    .getNextQuestion();
        } else {
            currentQuestion = new Quest().getStartQuestion();
            finish=false;
        }

        resp.sendRedirect("quest");

    }
}
