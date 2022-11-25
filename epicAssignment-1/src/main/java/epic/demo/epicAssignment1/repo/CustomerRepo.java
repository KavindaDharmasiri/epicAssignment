package epic.demo.epicAssignment1.repo;

import epic.demo.epicAssignment1.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, String> {
}
