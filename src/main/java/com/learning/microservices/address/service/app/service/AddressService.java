package com.learning.microservices.address.service.app.service;

import com.learning.microservices.address.service.app.dao.AddressDao;
import com.learning.microservices.address.service.app.mapper.AddressRequest;
import com.learning.microservices.address.service.app.mapper.AddressResponse;
import com.learning.microservices.address.service.app.model.Address;
import com.learning.microservices.address.service.app.util.AddressMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private AddressMapperUtil addressMapperUtil;


    public ResponseEntity<List<AddressResponse>> getAllAddresses() {
        List<AddressResponse> allAddressesList = new ArrayList<>();

        try {
            for (Address address : addressDao.findAll()) {
                AddressResponse addressResponse = addressMapperUtil.mapToResponseMapper(address);
                allAddressesList.add(addressResponse);
            }

            return new ResponseEntity<>(allAddressesList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    public ResponseEntity<AddressResponse> getAddressById(Integer id) {

        try {
            Optional<Address> address = addressDao.findById(id);

            if (address.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            } else {
                AddressResponse addressResponse = addressMapperUtil.mapToResponseMapper(address.orElse(null));
                return new ResponseEntity<>(addressResponse, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    public ResponseEntity<String> addOrUpdateAddress(AddressRequest addressRequest) {

        Address address = addressMapperUtil.mapToRequestMapper(addressRequest);
        try {
            addressDao.save(address);
            return new ResponseEntity<>("Address saved successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>("An error occurred while saving address", HttpStatus.INTERNAL_SERVER_ERROR);
    }


    public ResponseEntity<String> deleteAddress(Integer id) {

        try {

            if (addressDao.existsById(id)) {
                addressDao.deleteById(id);
                return new ResponseEntity<>("Address with id " + id + " deleted successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Address with id " + id + " does not exists", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>("An error occurred while deleting address of emp id: " + id , HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
