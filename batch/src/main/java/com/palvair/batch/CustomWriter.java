package com.palvair.batch;

import com.palvair.View;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * Created by widdy on 28/11/2015.
 */
public class CustomWriter implements ItemWriter<View> {
    public void write(List<? extends View> list) throws Exception {

    }
}
