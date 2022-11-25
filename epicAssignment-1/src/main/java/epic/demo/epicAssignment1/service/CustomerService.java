package epic.demo.epicAssignment1.service;

import epic.demo.epicAssignment1.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDto customer);

    List<CustomerDto> getCustomers();

    CustomerDto getCustomerById(String id);

    void deleteCustomer(String id);

    void updateCustomer(CustomerDto customer);

}
