package com.pluralsight.repository;

import com.pluralsight.model.Speaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository("speakerRepository")
public class HibernateSpeakerRepositoryImpl implements SpeakerRepository {

    private static final Logger logger = Logger.getLogger(HibernateSpeakerRepositoryImpl.class.getName());

    @Autowired
    private Calendar calendar;

    @Value("#{T(java.lang.Math).random() * 100}")
    private double seed;

    @Override
    public List<Speaker> findAll() {
        logger.log(Level.INFO, "calendar is: {0}", calendar.getTime());
        return Arrays.asList(new Speaker("Bryan", "Hansen", seed));
    }
}
