package com.learning.microservices.address.service.app.service;

import com.learning.microservices.address.service.app.dao.AddressDao;
import com.learning.microservices.address.service.app.mapper.AddressMapper;
import com.learning.microservices.address.service.app.model.Address;
import org.modelmapper.ModelMapper;
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
    private ModelMapper modelMapper;

    public ResponseEntity<List<AddressMapper>> getAllAddresses() {
        List<AddressMapper> allAddressesList = new ArrayList<>();

        try {
            for (Address address : addressDao.findAll()) {
                AddressMapper addressMapper = modelMapper.map(address, AddressMapper.class);
                allAddressesList.add(addressMapper);
            }

            return new ResponseEntity<>(allAddressesList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<AddressMapper> getAddressById(Integer id) {

        try {
            Optional<Address> address = addressDao.findById(id);

            if (address.isPresent()) {
                AddressMapper addressMapper = modelMapper.map(address, AddressMapper.class);
                return new ResponseEntity<>(addressMapper, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<String> addOrUpdateAddress(AddressMapper addressMapper) {

        Address address = modelMapper.map(addressMapper, Address.class);
        try {
            addressDao.save(address);
            return new ResponseEntity<>("Address saved successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>("An error occured while saving address", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<String> deleteAddress(Integer id) {

        try {
            addressDao.deleteById(id);
            return new ResponseEntity<>("Address with id " + id + " deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>("An error occured while deleting address of emp id: " + id , HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
