package com.pluralsight;

import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;
import com.pluralsight.util.CalendarFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Calendar;

@Configuration
@ComponentScan({"com.pluralsight"})
public class AppConfig {

    /*
    @Bean(name = "speakerService")
    @Scope(value = BeanDefinition.SCOPE_SINGLETON)
    public SpeakerService getSpeakerService() {
        // constructor injection
        //SpeakerServiceImpl speakerServiceImpl = new SpeakerServiceImpl(getSpeakerRepository());
        // Setter injection
        //speakerServiceImpl.setSpeakerRepository(getSpeakerRepository());
        // Autowired
        SpeakerServiceImpl speakerServiceImpl = new SpeakerServiceImpl();
        return speakerServiceImpl;
    }

    @Bean(name = "speakerRepository")
    public SpeakerRepository getSpeakerRepository() {
        return new HibernateSpeakerRepositoryImpl();
    }
    */

    @Bean(name = "speakerServicePrototype")
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    public SpeakerService getPrototypeSpeakerService() {
        return new SpeakerServiceImpl();
    }

    @Bean(name = "calendarFactory")
    public CalendarFactory getCalendarFactory() {
        CalendarFactory calendarFactory = new CalendarFactory();
        calendarFactory.addDays(2);
        return calendarFactory;
    }

    @Bean(name = "calendar")
    public Calendar getCalendar() throws Exception {
        return getCalendarFactory().getObject();
    }
}
