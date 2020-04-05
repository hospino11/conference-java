package com.pluralsight;

import com.pluralsight.service.SpeakerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Application {

    private static Logger logger = Logger.getLogger(Application.class.getName());

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        SpeakerService speakerService = applicationContext.getBean("speakerService", SpeakerService.class);
        logger.log(Level.INFO, speakerService.findAll().get(0).getFirstName());
        logger.log(Level.INFO, "First getBean call: {0}", speakerService);
        SpeakerService speakerService2 = applicationContext.getBean("speakerService", SpeakerService.class);
        // It's the same instance
        logger.log(Level.INFO, "Second getBean call: {0}", speakerService2);

        SpeakerService speakerServicePrototype = applicationContext.getBean("speakerServicePrototype", SpeakerService.class);
        logger.log(Level.INFO, "First getBean call as Prototype: {0}", speakerServicePrototype);
        SpeakerService speakerServicePrototype2 = applicationContext.getBean("speakerServicePrototype", SpeakerService.class);
        // It's a different instance
        logger.log(Level.INFO, "Second getBean call as Prototype: {0}", speakerServicePrototype2);
    }
}
