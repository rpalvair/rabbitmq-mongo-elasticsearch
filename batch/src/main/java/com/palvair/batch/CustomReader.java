package com.palvair.batch;

import com.palvair.View;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

/**
 * Created by widdy on 28/11/2015.
 */
public class CustomReader implements ItemReader<View> {
    public View read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return null;
    }
}
