package GTL_API.Repositories.StudentRepository;

import GTL_API.Exceptions.NotFoundException;
import GTL_API.Exceptions.UnknownException;
import GTL_API.Handlers.Patcher.PatcherHandler;
import GTL_API.Models.Entities.StudentEntity;
import GTL_API.Models.ReturnModels.PersonReturn;
import GTL_API.Models.ReturnModels.StudentReturn;
import org.aspectj.apache.bcel.classfile.Unknown;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StudentRepository implements IStudentCustomRepository {

    private IStudentRepository studentRepository;
    private ModelMapper modelMapper;
    private PatcherHandler patcherHandler;

    @Autowired
    public void setStudentRepository(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Autowired
    public void setPatcherHandler(PatcherHandler patcherHandler) {
        this.patcherHandler = patcherHandler;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    @Override
    public StudentReturn findByStudentId(int studentId) {
        try {
            StudentEntity found = findByStudentIdIfExistsAndReturn(studentId);
            return modelMapper.map(found, StudentReturn.class);
        } catch (Exception e) {
            throw new UnknownException(String.format("There was an unknown exception while finding student with"
                    + "student_id: %s", studentId));
        }
    }

    @Override
    public StudentReturn findByGpaBetween(int bottomRange, int upperRange) {
        try {
            StudentEntity found = findByGpaBetweenIfExistsAndReturn(bottomRange, upperRange);
            return modelMapper.map(found, StudentReturn.class);
        } catch (Exception e) {
            throw new UnknownException(String.format("There was an unknown exception while finding student with"
                    + "Gpa between: %s and %s", bottomRange,upperRange));
        }
    }

    @Override
    public StudentReturn updateStudent(StudentEntity studentEntity) {
        return null;
    }

    @Override
    public StudentReturn createStudent(StudentEntity studentEntity) {
        return null;
    }

    private StudentEntity findByStudentIdIfExistsAndReturn(int studentId) {
        Optional<StudentEntity> found = studentRepository.findByStudentId(studentId);
        if (found.isPresent()) {
            return found.get();
        } else {
            throw new NotFoundException(String.format("There is no student with:" + "student_id: %s", studentId));
        }
    }

    private StudentEntity findByGpaBetweenIfExistsAndReturn(int bottomRange, int upperRange) {
        Optional<StudentEntity> found = studentRepository.findByGpaBetween(bottomRange, upperRange);
        if (found.isPresent()) {
            return found.get();
        } else {
            throw new NotFoundException(String.format("There is no student with:" + "Gpa between: %s and %s", bottomRange,upperRange));
        }
    }


}
