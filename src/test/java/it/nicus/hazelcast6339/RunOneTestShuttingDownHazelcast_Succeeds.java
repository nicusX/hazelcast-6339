package it.nicus.hazelcast6339;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@DirtiesContext
public class RunOneTestShuttingDownHazelcast_Succeeds {

    @After
    public void tearDownHazelcast() {
        Hazelcast.shutdownAll();
    }

    @Autowired
    HazelcastInstance instance;

    @Test
    public void test1() {
        instance.getMap("aMap").put("foo", "bar");
    }

}
