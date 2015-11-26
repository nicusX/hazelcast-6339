package it.nicus.hazelcast6339;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class NonSpringTest {
    static final Logger LOG = LoggerFactory.getLogger("TEST");

    private HazelcastInstance hzInstance;

    @Before
    public void initHazelcast() {
        hzInstance = Hazelcast.newHazelcastInstance();
    }

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
        hzInstance.getMap("aMap").put("foo", "bar");
    }

    @Test
    public void test2() {
        LOG.info("Running test2");
        hzInstance.getMap("aMap").put("bar", "baz");
    }

}
