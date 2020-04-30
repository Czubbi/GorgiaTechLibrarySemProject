package GTL_API.Services;

import GTL_API.Repositories.ICoverTypeCustom;
import GTL_API.Repositories.IStudentCustom;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentService {

    private IStudentCustom iStudentRepository;
    private ModelMapper modelMapper;

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Autowired
    public void setIStudentRepository(IStudentCustom iStudentRepository) {
        this.iStudentRepository = iStudentRepository;

    @Override
    public void StudentReturn

}
