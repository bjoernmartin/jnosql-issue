package org.boris59.jnosqlissue.service;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import org.boris59.jnosqlissue.ITHelper;

@RunWith(Arquillian.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SettingServiceIT
{
    @Inject
    SettingService settingSvc;

    @Deployment
    public static WebArchive createDeployment()
    {
        return ITHelper.getWar();
    }

    @Test
    public void testGetSetting()
    {
        Assert.assertNotNull("setting is not null", settingSvc.getSetting("key123"));
    }
}
