package epic.demo.epicAssignment1.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Created_By_: Kavinda Gimhan
 * @Date_: 11/24/2022
 * @Time_: 8:10 PM
 * @Project_Name : Assignments
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ResponseUtil {
    private int code;
    private String message;
    private Object data;
}
