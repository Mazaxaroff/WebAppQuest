package ru.javarush.maxzaharov.webappquest.webappquest.servlets;

import ru.javarush.maxzaharov.webappquest.webappquest.Player;
import ru.javarush.maxzaharov.webappquest.webappquest.Players;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "indexServlet", value = "/index")
public class IndexServlet extends HttpServlet {
    private Players players;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        players = (Players) servletContext.getAttribute("players");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String nameOfPlayer = req.getParameter("name");

        HttpSession session = req.getSession();
        if (session.getAttribute("player") !=null){
            resp.sendRedirect("quest");
            return;
        }

        Player player;
        if (players.isContains(nameOfPlayer)){
            player = players.getPlayer(nameOfPlayer);
        } else {
            player = Player.builder()
                    .name(nameOfPlayer)
                    .ip(req.getRemoteAddr())
                    .games(0)
                    .build();
            players.save(player);
        }

        session.setAttribute("player", player);
        resp.sendRedirect("quest");
    }


}
