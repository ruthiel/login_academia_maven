package org.academiadecodigo.service;

import org.hibernate.jmx.spi.JmxService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by codecadet on 28/11/16.
 */
public class ServiceRegistry {

    private Map<String, Service> map;
    private static ServiceRegistry instance = null;

    private ServiceRegistry() {
        map = new HashMap<>();
    }

    public static synchronized ServiceRegistry getInstance() {

        if (instance == null) {
            instance = new ServiceRegistry();
        }
        return instance;
    }

    public Service getService(String serviceName) {
        return map.get(serviceName);
    }

    public void addService(Service service) {
        map.put(service.getServiceName(), service);
    }

}
