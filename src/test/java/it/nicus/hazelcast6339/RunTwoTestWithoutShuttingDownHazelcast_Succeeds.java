package it.nicus.hazelcast6339;

import com.hazelcast.core.HazelcastInstance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// The same test without calling shutdown, works
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@DirtiesContext
public class RunTwoTestWithoutShuttingDownHazelcast_Succeeds {
    static final Logger LOG = LoggerFactory.getLogger("TEST");

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
