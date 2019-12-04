package org.boris59.jnosqlissue.entity.nosql;

import java.util.List;

import org.jnosql.artemis.Repository;

import org.boris59.jnosqlissue.entity.Setting;

public interface SettingRepository extends Repository<Setting, String>
{
    List<Setting> findBySourceAndKey(String source, Iterable<String> keys);
}
