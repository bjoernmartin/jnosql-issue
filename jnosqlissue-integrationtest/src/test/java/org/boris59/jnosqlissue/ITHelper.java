package org.boris59.jnosqlissue;

import java.io.File;

import javax.enterprise.inject.Alternative;

import org.jboss.shrinkwrap.api.Node;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;

import static java.lang.System.getProperty;

public class ITHelper
{
    public static WebArchive getWar()
    {
        File depsDir = new File(getProperty("jnosqlissue.it.dependenciesLocation"));
        File webFile = new File(depsDir, getProperty("jnosqlissue.it.webName"));
        Assert.assertTrue("Dependencies dir " + depsDir + " exists", depsDir.isDirectory());
        Assert.assertTrue("Web file " + webFile + " exists", webFile.isFile());

        WebArchive war = ShrinkWrap.createFromZipFile(WebArchive.class, webFile)
                .addClass(ITHelper.class);
        String coreName = getProperty("jnosqlissue.it.coreName");
        Node coreNode = war.delete("WEB-INF/lib/" + getProperty("jnosqlissue.it.coreName"));
        Assert.assertNotNull("Core file was removed from Web", coreNode);

        File coreFile = new File(depsDir, coreName);
        Assert.assertTrue("Core file " + coreFile + " exists", coreFile.isFile());
        JavaArchive core = ShrinkWrap.createFromZipFile(JavaArchive.class, coreFile)
                .addAsManifestResource(new File("src/test/resources/beans.xml"));
        war.addAsLibrary(core);

        return war;
    }
}
