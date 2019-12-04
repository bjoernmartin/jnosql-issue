/**
 *
 */
package org.boris59.jnosqlissue.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import org.jnosql.artemis.Column;
import org.jnosql.artemis.Entity;
import org.jnosql.artemis.Id;

/**
 * @author bjoern.martin
 *
 */
@Entity
public class Setting implements Serializable
{
    private static final long serialVersionUID = -3024858889890884491L;

    @Id
    private String id;
    @Column
    private String source;
    @Column
    private String key;
    @Column
    private String value;
    @Column
    private boolean current;
    @Column
    private boolean deleted;
    @Column
    private String systemId;
    @Column
    private String moduleName;
    @Column
    private Date created;
    @Column
    private Date createdOnSystem;

    public static Setting from(String source, String key, String value, boolean current, boolean deleted,
            String systemId, String moduleName, Date created, Date createdOnSystem)
    {
        Setting setting = new Setting();
        setting.setId(UUID.randomUUID().toString());
        setting.setSource(source);
        setting.setKey(key);
        setting.setValue(value);
        setting.setCurrent(current);
        setting.setDeleted(deleted);
        setting.setSystemId(systemId);
        setting.setModuleName(moduleName);
        setting.setCreated(created);
        setting.setCreatedOnSystem(createdOnSystem);
        return setting;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getSource()
    {
        return source;
    }

    public void setSource(String source)
    {
        this.source = source;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public boolean isCurrent()
    {
        return current;
    }

    public void setCurrent(boolean current)
    {
        this.current = current;
    }

    public boolean isDeleted()
    {
        return deleted;
    }

    public void setDeleted(boolean deleted)
    {
        this.deleted = deleted;
    }

    public String getSystemId()
    {
        return systemId;
    }

    public void setSystemId(String systemId)
    {
        this.systemId = systemId;
    }

    public String getModuleName()
    {
        return moduleName;
    }

    public void setModuleName(String moduleName)
    {
        this.moduleName = moduleName;
    }

    public Date getCreated()
    {
        return created;
    }

    public void setCreated(Date created)
    {
        this.created = created;
    }

    public Date getCreatedOnSystem()
    {
        return createdOnSystem;
    }

    public void setCreatedOnSystem(Date createdOnSystem)
    {
        this.createdOnSystem = createdOnSystem;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof Setting))
        {
            return false;
        }
        Setting prop = (Setting) o;
        return Objects.equals(id, prop.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(id);
    }

    @Override
    public String toString()
    {
        return "Setting[" 
                + (id != null ? "id=" + id + ", " : "")
                + (source != null ? "source=" + source + ", " : "")
                + (key != null ? "key=" + key + ", " : "")
                + (value != null ? "value=" + value + ", " : "")
                + "current=" + current + ", deleted=" + deleted
                + (systemId != null ? ", systemId=" + systemId: "")
                + (moduleName != null ? ", moduleName=" + moduleName : "")
                + (created != null ? ", created=" + created : "")
                + (createdOnSystem != null ? ", createdOnSystem=" + createdOnSystem : "")
                + "]";
    }
}
