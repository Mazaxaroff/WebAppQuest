package ru.javarush.maxzaharov.webappquest.servlets;

import ru.javarush.maxzaharov.webappquest.*;
import ru.javarush.maxzaharov.webappquest.service.QuestService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.util.Objects.isNull;

@WebServlet(name = "questServlet", value = "/quest")
public class QuestServlet extends HttpServlet {
    private Question currentQuestion;
    private boolean finish;
    private QuestService questService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        currentQuestion = new Quest().getStartQuestion();
        questService = new QuestService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Player player = (Player) req.getSession().getAttribute("player");

        req.setAttribute("currentQuestion", currentQuestion.getText());
        req.setAttribute("ip", player.getIp());
        req.setAttribute("nameOfPlayer", player.getName());
        req.setAttribute("answers", questService.answers(finish, player, currentQuestion));
        req.setAttribute("finish", finish);
        req.setAttribute("countOfGames", player.getGames());

        getServletContext().getRequestDispatcher("/WEB-INF/quest.jsp").forward(req, resp);
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
            finish = false;
        }
        resp.sendRedirect("quest");
    }
}
