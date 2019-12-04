package org.boris59.jnosqlissue.entity.nosql;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.jnosql.artemis.ConfigurationUnit;
import org.jnosql.diana.api.document.DocumentCollectionManager;
import org.jnosql.diana.api.document.DocumentCollectionManagerFactory;

@ApplicationScoped
public class DocumentCollectionManagerProducer {

    @Inject
    @ConfigurationUnit(name = "document")
    private DocumentCollectionManagerFactory<DocumentCollectionManager> entityManager;

    @Produces
    public DocumentCollectionManager getManager() {
        return entityManager.get("setting");
    }

}
