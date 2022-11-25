package epic.demo.epicAssignment1.service.serviceImpl;

import epic.demo.epicAssignment1.dto.CustomerDto;
import epic.demo.epicAssignment1.entity.Customer;
import epic.demo.epicAssignment1.repo.CustomerRepo;
import epic.demo.epicAssignment1.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Created_By_: Kavinda Gimhan
 * @Date_: 11/24/2022
 * @Time_: 8:03 PM
 * @Project_Name : Assignments
 **/

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveCustomer(CustomerDto customer) {
        if (!customerRepo.existsById(customer.getId())) {
            customerRepo.save(mapper.map(customer, Customer.class));
        } else {
            throw new RuntimeException("Customer Already Exist..!");
        }
    }

    @Override
    public List<CustomerDto> getCustomers() {
        return mapper.map(customerRepo.findAll(), new TypeToken<List<CustomerDto>>() {
        }.getType());
    }

    @Override
    public CustomerDto getCustomerById(String id) {
        if (customerRepo.existsById(id)) {
            return mapper.map(customerRepo.findById(id).get(), CustomerDto.class);
        } else {
            throw new RuntimeException("No Customer For " + id + " ..!");
        }
    }

    @Override
    public void deleteCustomer(String id) {
        if (customerRepo.existsById(id)) {
            customerRepo.deleteById(id);
        } else {
            throw new RuntimeException("Please check the Customer ID.. No Such Customer..!");
        }
    }

    @Override
    public void updateCustomer(CustomerDto customer) {
        if (customerRepo.existsById(customer.getId())) {
            customerRepo.save(mapper.map(customer, Customer.class));
        } else {
            throw new RuntimeException("No Such Customer To Update..! Please Check the ID..!");
        }
    }
}
