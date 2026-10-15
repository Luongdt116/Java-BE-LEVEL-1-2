package com.example.demo.service.impl;

import com.example.demo.dto.CustomerRequest;
import com.example.demo.dto.CustomerResponse;

import java.util.List;

public interface CustomerServiceImpl {
    CustomerResponse create(CustomerRequest request);
    CustomerResponse update(Integer id, CustomerRequest request);
    void delete(Integer id);
    List<CustomerResponse> getAll();
    CustomerResponse getById(Integer id);
    List<CustomerResponse> searchByName(String keyword);
}
