package ru.javarush.maxzaharov.webappquest;


import ru.javarush.maxzaharov.webappquest.service.InitializationService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashMap;

@WebListener
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        context.setAttribute("players", new InitializationService(new Players(new HashMap<>())));
    }

}
