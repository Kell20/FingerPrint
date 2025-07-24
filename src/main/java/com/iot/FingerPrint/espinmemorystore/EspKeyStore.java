package com.iot.FingerPrint.espinmemorystore;

import com.iot.FingerPrint.espdevice.EspDevice;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
//simulation of database for my devices
@Component
public class EspKeyStore {
    /*mapping a key to each device so it will enable to check if
    *a device is valid to access this program
    * */

    private final Map<String, EspDevice> keyStore=new HashMap<>();

    // create some table for needed device
    @PostConstruct
    private void authenticatedDevices(){
        keyStore.put("firstDev",new EspDevice("1","firstDev","enrol"));
        keyStore.put("secondDev",new EspDevice("2","secondDev","match"));
    }

    //get Device by key
    public EspDevice getByKey(String key){
        return keyStore.get(key);
    }
}
