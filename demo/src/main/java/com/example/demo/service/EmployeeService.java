package com.example.demo.service;

import com.example.demo.dto.EmployeeRequest;
import com.example.demo.dto.EmployeeResponse;
import com.example.demo.entity.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.impl.EmployeeServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class EmployeeService implements EmployeeServiceImpl {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public List<EmployeeResponse> getAll() {
        return employeeRepository.findAll().stream().map(this::toResponse).toList();
    }

    @Override
    @Transactional
    public EmployeeResponse getById(Integer id) {
        Employee employee = employeeRepository
                .findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found with id = " + id));
        return toResponse(employee);
    }

    @Override
    public EmployeeResponse create(EmployeeRequest request) {
        Employee employee = new Employee();

        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setBirthDate(request.getBirthDate());
        employee.setSupervisor(resolveSupervisor(request.getSupervisorId()));
        Employee saved = employeeRepository.save(employee);

        return toResponse(saved);
    }

    @Override
    public EmployeeResponse update(Integer id, EmployeeRequest request) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException(
                        "Employee not found with id = " + id
                ));

        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setBirthDate(request.getBirthDate());
        employee.setSupervisor(resolveSupervisor(request.getSupervisorId()));
        Employee updated = employeeRepository.save(employee);

        return toResponse(updated);
    }

    @Override
    public void delete(Integer id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException(
                        "Employee not found with id = " + id
                ));
        employeeRepository.delete(employee);
    }

    private EmployeeResponse toResponse(Employee e){
        EmployeeResponse res = new EmployeeResponse();
        res.setEmployeeId(e.getEmployeeId());
        res.setFirstName(e.getFirstName());
        res.setLastName(e.getLastName());
        res.setBirthDate(e.getBirthDate());
        res.setSupervisorId(e.getSupervisor() == null ? null : e.getSupervisor().getEmployeeId());

        return res;
    }

    private Employee resolveSupervisor(Integer supervisorId) {
        if (supervisorId == null) {
            return null;
        }

        return employeeRepository.findById(supervisorId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Supervisor not found with id = " + supervisorId
                ));
    }
}
