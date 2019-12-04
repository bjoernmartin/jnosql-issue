/**
 *
 */
package org.boris59.jnosqlissue.entity.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.jnosql.artemis.Database;
import org.jnosql.artemis.document.DocumentTemplate;
import org.jnosql.diana.api.document.DocumentQuery;

import org.boris59.jnosqlissue.entity.Setting;
import org.boris59.jnosqlissue.entity.nosql.SettingRepository;

import static org.jnosql.artemis.DatabaseType.DOCUMENT;
import static org.jnosql.diana.api.document.query.DocumentQueryBuilder.select;

/**
 * @author bjoern.martin
 */
@Stateless
public class SettingDAO
{
    @Inject
    DocumentTemplate template;

    @Inject
    @Database(DOCUMENT)
    SettingRepository repo;

    public void create(Setting setting)
    {
        template.insert(setting);
    }

    public void create(Iterable<Setting> settings)
    {
        template.insert(settings);
    }

    public List<String> findAllKeys()
    {
        DocumentQuery query = select("key")
                .from(Setting.class.getName())
                .orderBy("key").asc()
                .build();
        return template.select(query);
    }

    public List<Setting> findBySourceAndKeys(String source, Set<String> keySet)
    {
        if (keySet.isEmpty())
        {
            return new ArrayList<>();
        }
        return repo.findBySourceAndKey(source, keySet);
    }
}
