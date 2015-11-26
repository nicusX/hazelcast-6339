# Test project for reproducing Hazelcast issue #6339

https://github.com/hazelcast/hazelcast/issues/6339


The integration test class (run with ```@RunWith(SpringJUnit4ClassRunner.class)```) containing a single test method runs fine.

The test class containing two tests methods fails throwing ```com.hazelcast.core.HazelcastInstanceNotActiveException``` 
on running the second test method.
