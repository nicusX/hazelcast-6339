package it.nicus.hazelcast6339;

import static org.junit.Assert.*;
import com.hazelcast.core.HazelcastInstance;

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
@DirtiesContext
public class RunTwoTestWithoutShuttingDownHazelcast {
    static final Logger LOG = LoggerFactory.getLogger("TEST");

    @Autowired
    HazelcastInstance instance;

    @Test
    public void test1() {
        LOG.info("Running test1");

        assertNull(instance.getMap("aMap").get("foo"));
        instance.getMap("aMap").put("foo", "bar");
        assertEquals("bar", instance.getMap("aMap").get("foo"));
    }

    @Test
    public void test2() {
        LOG.info("Running test2");

        assertNull(instance.getMap("aMap").get("foo"));
        instance.getMap("aMap").put("foo", "baz");
        assertEquals("baz", instance.getMap("aMap").get("foo"));
    }

}
