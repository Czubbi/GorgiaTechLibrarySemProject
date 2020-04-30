package GTL_API.Controllers;

import GTL_API.Models.CreationModels.StudentCreation;
import GTL_API.Models.ReturnModels.StudentReturn;
import GTL_API.Models.UpdateModels.StudentUpdate;
import GTL_API.Services.StudentService.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("gtl/student")
public class StudentController {
    private IStudentService iStudentService;

    @Autowired
    public void setIStudentService(IStudentService iStudentService){ this.iStudentService = iStudentService;
    }

    @RequestMapping(value = "/", method = RequestMethod.PATCH)
    public ResponseEntity<?> updateStudentByStudentId(@RequestBody @Valid StudentUpdate student){
        return new ResponseEntity<>(iStudentService.updateStudent(student), new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> createStudent(@RequestBody @Valid StudentCreation student){
        return new ResponseEntity<>(iStudentService.createStudent(student), new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value="/{studentId}", method = RequestMethod.GET)
    public ResponseEntity<?> findByStudentId(@PathVariable int studentId){
        return new ResponseEntity<>(iStudentService.findByStudentId(studentId), new HttpHeaders(), HttpStatus.FOUND);
    }

    @RequestMapping(value="/{bottomRange}/{upperRange}", method = RequestMethod.GET)
    public ResponseEntity<?> findByGpaBetween(@PathVariable int bottomRange, @PathVariable int upperRange){
        return new ResponseEntity<>(iStudentService.findByGpaBetween(bottomRange,upperRange), new HttpHeaders(), HttpStatus.FOUND);
    }

}
