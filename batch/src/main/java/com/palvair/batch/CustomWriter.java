package com.palvair.batch;

import com.palvair.View;
import com.palvair.mongo.config.ViewRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by widdy on 28/11/2015.
 */
public class CustomWriter implements ItemWriter<View> {
    @Autowired
    private ViewRepository viewRepository;

    public void write(List<? extends View> list) throws Exception {
        viewRepository.save(list);
    }
}
