package com.palvair.batch;

import com.palvair.Status;
import com.palvair.View;
import com.palvair.mongo.config.ViewRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.List;

/**
 * Created by widdy on 28/11/2015.
 */
@Log4j
public class CustomReader implements ItemReader<View>, InitializingBean {

    @Autowired
    private ViewRepository viewRepository;

    private Iterator<View> iterator;

    public View read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        final List<View> estimateList = viewRepository.findByStatus(Status.PENDING);
        System.out.println("size = "+estimateList.size());
        if(estimateList.size() > 0) {
            return estimateList.get(0);
        }
        System.out.println("no pending view");
        return null;
    }

    public void afterPropertiesSet() throws Exception {

        init();
    }

    public void init() {
        System.out.println("init");
    }
}
