package it.nicus.hazelcast6339;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@DirtiesContext // Just make sure Spring is not caching the ApplicationContext
public class RunTwoTestsShuttingDownHazelcast {
    static final Logger LOG = LoggerFactory.getLogger("TEST");

    static int countShutdown = 0;

    @After
    public void tearDownHazelcast() {
        LOG.info("Calling Hazelcast shutdownAll #{}", ++countShutdown);
        Hazelcast.shutdownAll();
    }

    @Autowired
    HazelcastInstance instance;

    @Test
    public void test1() {
        LOG.info("Running test1");
        instance.getMap("aMap").put("foo", "bar");
    }

    @Test
    public void test2() {
        LOG.info("Running test2");
        instance.getMap("aMap").put("bar", "baz");
    }

}
