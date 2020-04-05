package com.pluralsight.service;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service("speakerService")
public class SpeakerServiceImpl implements SpeakerService {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    private SpeakerRepository speakerRepository;

    @Autowired
    private Calendar calendar;

    public SpeakerServiceImpl() {
        logger.log(Level.INFO, "SpeakerServiceImpl no args constructor");
    }

    // @Autowired at constructor to constructor autowiring
    @Autowired
    public SpeakerServiceImpl(SpeakerRepository speakerRepository) {
        logger.log(Level.INFO, "SpeakerServiceImpl repository constructor");
        this.speakerRepository = speakerRepository;
    }

    @PostConstruct
    private void intialize() {
        logger.log(Level.INFO, "initialize executed after constructors.");
    }

    @Override
    public List<Speaker> findAll() {
        logger.log(Level.INFO, "calendar in {0} is: {1}", new Object[]{ this.getClass().getName(), calendar.getTime() });
        return speakerRepository.findAll();
    }

    // @Autowired annotation to setter autowired
    //@Autowired
    public void setSpeakerRepository(SpeakerRepository speakerRepository) {
        logger.log(Level.INFO, "SpeakerServiceImpl setter");
        this.speakerRepository = speakerRepository;
    }
}
