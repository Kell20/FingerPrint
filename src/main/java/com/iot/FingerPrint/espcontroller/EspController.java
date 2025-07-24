package com.iot.FingerPrint.espcontroller;

import com.iot.FingerPrint.espdevice.EspDevice;
import com.iot.FingerPrint.espdevice.PaymentGateTest;
import com.iot.FingerPrint.exception.InvalidApiKeyException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/esp-device")
public class EspController {
    @PostMapping("/match")
    public ResponseEntity<String> matchFingerPrint(HttpServletRequest request){
        EspDevice device=(EspDevice)request.getAttribute("device");
        if(device==null){
            throw new InvalidApiKeyException("device key is invalid");
        }

        if(!"match".equals(device.getRole())){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("a device is not authorized");
        }
        //calling business logic for matching fingerprint ID
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("fingerprint matched");
    }

    @PostMapping("/enrol")
    public ResponseEntity<String> enrolFingerPrint(HttpServletRequest request){
        EspDevice device=(EspDevice)request.getAttribute("device");
        if(device==null){
            throw new InvalidApiKeyException("device key is invalid");
        }

        if(!"enrol".equals(device.getRole())){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("a device is not authorized");
        }
        //calling business logic for enrolling to a system
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("enrolment success");
    }

    @PostMapping("/payment")
    public String pay(@RequestBody PaymentGateTest payDetails){
        return "";
    }
}
