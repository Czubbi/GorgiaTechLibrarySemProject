package GTL_API.Services;

import GTL_API.Models.CreationModels.PersonCreation;
import GTL_API.Models.Entities.PersonEntity;
import GTL_API.Models.ReturnModels.PersonReturn;
import GTL_API.Models.UpdateModels.PersonUpdate;
import GTL_API.Repositories.IPersonCustom;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IPersonService {
    private IPersonCustom iPersonCustomRepository;

    private ModelMapper modelMapper;

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) { this.modelMapper = modelMapper; }

    @Autowired
    public void setiPersonCustomRepository(IPersonCustom iPersonCustomRepository){
        this.iPersonCustomRepository = iPersonCustomRepository;
    }

    @Override
    public PersonReturn findPersonBySsn(String ssn) {
        return iPersonCustomRepository.findPersonBySsn(ssn);
    }

    @Override
    public PersonReturn findPersonByFirstNameAndLastName(String firstName, String lastName) {
        return iPersonCustomRepository.findPersonByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public PersonReturn findPersonByCardNumberId(Integer cardNumberId) {
        return iPersonCustomRepository.findPersonByCardNumberId(cardNumberId);
    }

    @Override
    public PersonReturn updatePerson(PersonUpdate person) {
        return iPersonCustomRepository.updatePerson(modelMapper.map(person, PersonEntity.class));
    }

    @Override
    public PersonReturn createPerson(PersonCreation person) {
        return iPersonCustomRepository.createPerson(modelMapper.map(person, PersonEntity.class));
    }
}
