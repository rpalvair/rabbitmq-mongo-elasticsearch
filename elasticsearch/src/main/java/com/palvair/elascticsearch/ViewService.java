package com.palvair.elascticsearch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.palvair.View;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.joda.time.LocalDate;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;

import java.net.UnknownHostException;

/**
 * Created by widdy on 28/11/2015.
 */
@Data
@Log4j
public class ViewService {

    private final String INDEX = "view";

    private  Client client;

    public ViewService()  {

        Settings settings = ImmutableSettings.settingsBuilder()
                .put("cluster.name", "elasticsearch_widdy").build();
        client =    new TransportClient(settings).addTransportAddress(new InetSocketTransportAddress("localhost", 9300));


    }

    public IndexResponse insert(final View view) throws JsonProcessingException, UnknownHostException {

        final ObjectMapper mapper = new ObjectMapper();
        final String json = mapper.writeValueAsString(view);
        log.info("json = " + json);
        final LocalDate date = new LocalDate();
        log.debug("type = " + date.toString());
        final IndexResponse indexResponse = client.prepareIndex(INDEX, date.toString()).setSource(json).execute().actionGet();
        client.close();
        return indexResponse;
    }

    public SearchResponse getAll(final String index, final String type) {
        return client.prepareSearch(index)
                /*.setTypes(type)*/
                .setQuery(QueryBuilders.matchAllQuery())
                .setSize(100)
                .execute()
                .actionGet();
    }
}
