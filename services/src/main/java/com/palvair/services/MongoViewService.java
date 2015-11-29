package com.palvair.services;

import com.palvair.View;
import com.palvair.mongo.config.ViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by widdy on 29/11/2015.
 */
@Component
public class MongoViewService {

    @Autowired
    private ViewRepository viewRepository;

    public void save(View view) {
        final View savedView  = viewRepository.save(view);
    }

    public List<View> findAll() {
        return viewRepository.findAll();
    }
}
