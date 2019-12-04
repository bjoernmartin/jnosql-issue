package org.boris59.jnosqlissue.scheduler;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionManagement;
import javax.inject.Inject;

import org.slf4j.Logger;

import org.boris59.jnosqlissue.service.SettingService;

import static javax.ejb.TransactionManagementType.BEAN;

/**
 * Gets notified about application startup and shutdown and performs relevant tasks at those times.
 *
 * @author bjoern.martin
 */
@Singleton
@Startup
@TransactionManagement(BEAN)
public class SystemLifecycleListener
{
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(SystemLifecycleListener.class);

    @Inject
    private SettingService settingSvc;

    @PostConstruct
    public void initialize()
    {
        final long start = System.currentTimeMillis();

        log.info("Performing startup tasks");

        settingSvc.migratePropertiesToSettings();

        final long duration = System.currentTimeMillis() - start;

        log.info("Startup done, took " + duration + "ms");
    }

    @PreDestroy
    public void destroy()
    {
        log.info("Shutting down, bye!");
    }

}
