package org.boris59.jnosqlissue.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.boris59.jnosqlissue.entity.Setting;
import org.boris59.jnosqlissue.entity.dao.SettingDAO;

@Stateless
public class SettingService
{
    private static final Logger log = LoggerFactory.getLogger(SettingService.class);

    @Inject
    private SettingDAO settingDao;

    public void migratePropertiesToSettings()
    {
        log.info("Starting migration");
        long start = System.currentTimeMillis();
        List<Setting> settings = new ArrayList<Setting>();
        settings.add(
                Setting.from("Source", "Key", "Value", true, false, "systemId", "ModuleName", new Date(), new Date()));
        settingDao.create(settings);
        log.info("Migration done in duration={} ms", (System.currentTimeMillis() - start));
    }

    public String getSetting(String key)
    {
        return "Setting for " + key;
    }
}
