package GTL_API.Repositories;

import GTL_API.Models.Entities.StudentEntity;
import GTL_API.Models.ReturnModels.StudentReturn;

import java.util.Optional;

public interface IStudentCustom {
    StudentReturn findByStudentId(int studentId);
    StudentReturn findByGpaBetween(int bottomRange, int upperRange);
}
