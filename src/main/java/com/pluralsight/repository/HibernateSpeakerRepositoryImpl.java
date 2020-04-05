package com.pluralsight.repository;

import com.pluralsight.model.Speaker;

import java.util.Arrays;
import java.util.List;

public class HibernateSpeakerRepositoryImpl implements SpeakerRepository {

    @Override
    public List<Speaker> findAll() {
        return Arrays.asList(new Speaker("Bryan", "Hansen"));
    }
}
