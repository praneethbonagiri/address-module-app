package com.learning.microservices.address.service.app.controller;

import com.learning.microservices.address.service.app.mapper.AddressRequest;
import com.learning.microservices.address.service.app.mapper.AddressResponse;
import com.learning.microservices.address.service.app.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/addresses")
    public ResponseEntity<List<AddressResponse>> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping("/address/{empId}")
    public ResponseEntity<AddressResponse> getAddressById(@PathVariable("empId") Integer id) {
        return addressService.getAddressById(id);
    }

    @PostMapping("/insertAddress")
    public ResponseEntity<String> insertOrUpdateAddress(@RequestBody AddressRequest addressRequest) {
        return addressService.addOrUpdateAddress(addressRequest);
    }

    @DeleteMapping("/deleteAddress/{addId}")
    public ResponseEntity<String> deleteAddress(@PathVariable("addId") Integer id) {
        return addressService.deleteAddress(id);
    }

}
