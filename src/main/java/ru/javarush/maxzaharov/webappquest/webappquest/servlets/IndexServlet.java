package ru.javarush.maxzaharov.webappquest.webappquest.servlets;

import ru.javarush.maxzaharov.webappquest.webappquest.Player;
import ru.javarush.maxzaharov.webappquest.webappquest.Players;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "indexServlet", value = "/index")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameOfPlayer = req.getParameter("name");
        if (!Players.ALL.containsKey(nameOfPlayer)){
            Players.ALL.put(nameOfPlayer, Player.builder()
                    .name(nameOfPlayer)
                    .ip(req.getRemoteAddr())
                    .games(0)
                    .build());

        }
//        HttpSession session = req.getSession();
//        session.setAttribute("name", nameOfPlayer);
        resp.sendRedirect("quest");
    }


}
