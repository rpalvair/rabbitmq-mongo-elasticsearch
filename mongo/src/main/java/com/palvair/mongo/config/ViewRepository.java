package com.palvair.mongo.config;

import com.palvair.Status;
import com.palvair.View;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


/**
 * Created by widdy on 29/11/2015.
 */
public interface ViewRepository extends MongoRepository<View,String>{

    List<View> findByStatus(Status status);
}
