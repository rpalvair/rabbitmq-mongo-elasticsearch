package com.palvair.batch;

import com.palvair.View;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by widdy on 28/11/2015.
 */
public class CustomProcessor implements ItemProcessor<View,View> {
    public View process(View view) throws Exception {
        return null;
    }
}
