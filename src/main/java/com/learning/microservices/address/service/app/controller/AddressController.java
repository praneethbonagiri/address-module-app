package com.learning.microservices.address.service.app.controller;

import com.learning.microservices.address.service.app.mapper.AddressMapper;
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
    public ResponseEntity<List<AddressMapper>> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping("/address/{empId}")
    public ResponseEntity<AddressMapper> getAddressByEmpId(@PathVariable("empId") Integer id) {
        return addressService.getAddressById(id);
    }

    @PostMapping("/insertAddress")
    public ResponseEntity<String> insertOrUpdateAddress(@RequestBody AddressMapper addressMapper) {
        return addressService.addOrUpdateAddress(addressMapper);
    }

    @DeleteMapping("/deleteAddress/{empId}")
    public ResponseEntity<String> deleteAddress(@PathVariable("empId") Integer id) {
        return addressService.deleteAddress(id);
    }

}
