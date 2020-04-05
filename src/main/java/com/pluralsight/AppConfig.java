package com.pluralsight;

import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;
import com.pluralsight.repository.SpeakerRepository;
import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = "speakerService")
    public SpeakerService getSpeakerService() {
        // constructor injection
        SpeakerServiceImpl speakerServiceImpl = new SpeakerServiceImpl(getSpeakerRepository());
        // Setter injection
        //speakerServiceImpl.setSpeakerRepository(getSpeakerRepository());
        return speakerServiceImpl;
    }

    public SpeakerRepository getSpeakerRepository() {
        return new HibernateSpeakerRepositoryImpl();
    }
}
