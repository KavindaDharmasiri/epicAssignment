package epic.demo.epicAssignment1.controller;

import epic.demo.epicAssignment1.dto.CustomerDto;
import epic.demo.epicAssignment1.service.serviceImpl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Created_By_: Kavinda Gimhan
 * @Date_: 11/24/2022
 * @Time_: 8:06 PM
 * @Project_Name : Assignments
 **/

@RestController
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @PostMapping(path = "/saveCustomer", produces = MediaType.APPLICATION_JSON_VALUE)
    public epic.demo.epicAssignment1.util.ResponseUtil addCustomer(@RequestBody CustomerDto customer) {
        customerServiceImpl.saveCustomer(customer);
        return new epic.demo.epicAssignment1.util.ResponseUtil(200, "Saved", null);
    }

    @GetMapping(path = "/getAllCustomers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDto> getAllCustomer() {
        return customerServiceImpl.getCustomers();
    }

    @GetMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public epic.demo.epicAssignment1.util.ResponseUtil getCustomerById(@RequestParam String id) {
        return new epic.demo.epicAssignment1.util.ResponseUtil(200, "Get One", customerServiceImpl.getCustomerById(id));
    }

    @DeleteMapping(path = "/deleteCustomers", produces = MediaType.APPLICATION_JSON_VALUE)
    public epic.demo.epicAssignment1.util.ResponseUtil deleteCustomer(@RequestParam String id) {
        customerServiceImpl.deleteCustomer(id);
        return new epic.demo.epicAssignment1.util.ResponseUtil(200, "Deleted", null);
    }

    @PutMapping(path = "/editCustomer", produces = MediaType.APPLICATION_JSON_VALUE)
    public epic.demo.epicAssignment1.util.ResponseUtil updateCustomer(@RequestBody CustomerDto customer) {
        customerServiceImpl.updateCustomer(customer);
        return new epic.demo.epicAssignment1.util.ResponseUtil(200, "Updated", null);
    }
}
