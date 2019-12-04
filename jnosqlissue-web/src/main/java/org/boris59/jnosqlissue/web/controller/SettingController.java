package org.boris59.jnosqlissue.web.controller;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.boris59.jnosqlissue.service.SettingService;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("settings")
public class SettingController
{
    private static final Logger log = LoggerFactory.getLogger(SettingController.class);

    @Inject
    private SettingService settingSvc;

    @GET
    @Path("{key}")
    @Produces(APPLICATION_JSON)
    public String getSetting(@PathParam("key") String key)
    {
        log.info("Get settings for " + key);

        return settingSvc.getSetting(key);
    }
}
