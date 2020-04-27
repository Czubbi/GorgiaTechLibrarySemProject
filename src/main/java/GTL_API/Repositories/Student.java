package GTL_API.Repositories;

import GTL_API.Exceptions.NotFoundException;
import GTL_API.Handlers.PatcherHandler;
import GTL_API.Models.Entities.StudentEntity;
import GTL_API.Models.ReturnModels.StudentReturn;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class Student implements IStudentCustom {

    private IStudent studentRepository;
    private ModelMapper modelMapper;
    private PatcherHandler patcherHandler;

    @Autowired
    public void setStudentRepository(IStudent studentRepository) {
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
        StudentEntity found = findIfExistsAndReturn(studentId);
        return found;
    }

    @Override
    public Optional<StudentEntity> findByGpaBetween(int bottomRange, int upperRange) {
        return studentRepository.findByGpaBetween(bottomRange, upperRange);
    }

    private StudentEntity findIfExistsAndReturn(int studentId) {
        Optional<StudentEntity> found = studentRepository.findByStudentId(studentId);
        if (found.isPresent()) {
            return found.get();
        }
        else {
            throw new NotFoundException("There is no student with:" +studentId + "id");
        }
    }



}
