package epic.demo.epicAssignment1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Created_By_: Kavinda Gimhan
 * @Date_: 11/24/2022
 * @Time_: 7:57 PM
 * @Project_Name : Assignments
 **/

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CustomerDto {
    private String id;
    private String name;
    private int age;
    private String address;
}
