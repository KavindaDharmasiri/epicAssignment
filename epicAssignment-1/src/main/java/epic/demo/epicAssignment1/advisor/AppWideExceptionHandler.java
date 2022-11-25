package epic.demo.epicAssignment1.advisor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Created_By_: Kavinda Gimhan
 * @Date_: 11/24/2022
 * @Time_: 8:10 PM
 * @Project_Name : Assignments
 **/

@CrossOrigin
@RestControllerAdvice
public class AppWideExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({Exception.class})
    public epic.demo.epicAssignment1.util.ResponseUtil exceptionHandler(Exception e) {
        return new epic.demo.epicAssignment1.util.ResponseUtil(500, e.getMessage(), null);
    }

}

