package com.learning.microservices.address.service.app.util;

import com.learning.microservices.address.service.app.mapper.AddressRequest;
import com.learning.microservices.address.service.app.mapper.AddressResponse;
import com.learning.microservices.address.service.app.model.Address;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

@Component
public class AddressMapperUtil {

    private static final ModelMapper modelMapper = new ModelMapper();
    private TypeMap<Address, AddressResponse> responseTypeMap;
    private TypeMap<AddressRequest, Address> requestTypeMap;

    public AddressResponse mapToResponseMapper(Address address) {

        if (responseTypeMap == null) {
            responseTypeMap = modelMapper.createTypeMap(Address.class, AddressResponse.class);

            responseTypeMap.addMappings(mapper -> {
                mapper.map(Address::getDoorNo, AddressResponse::setDoorNumber);
                mapper.map(Address::getStreet, AddressResponse::setStreetName);
                mapper.map(Address::getCity, AddressResponse::setCity);
                mapper.map(Address::getZip, AddressResponse::setZipCode);
            });
        }

        return modelMapper.map(address, AddressResponse.class);
    }


    public Address mapToRequestMapper(AddressRequest addressRequest) {

        if (requestTypeMap == null) {
            requestTypeMap  = modelMapper.createTypeMap(AddressRequest.class, Address.class);

            requestTypeMap.addMappings(mapper -> {
                mapper.map(AddressRequest::getDoorNumber, Address::setDoorNo);
                mapper.map(AddressRequest::getStreetName, Address::setStreet);
                mapper.map(AddressRequest::getCity, Address::setCity);
                mapper.map(AddressRequest::getZipCode, Address::setZip);
                mapper.map(AddressRequest::getEmpId, Address::setEmpId);
            });
        }

        return modelMapper.map(addressRequest, Address.class);
    }
}
