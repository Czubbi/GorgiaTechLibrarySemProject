package GTL_API.Services.PersonService;

import GTL_API.Models.CreationModels.PersonCreation;
import GTL_API.Models.Entities.PersonEntity;
import GTL_API.Models.ReturnModels.PersonReturn;
import GTL_API.Models.UpdateModels.PersonUpdate;
import GTL_API.Repositories.PersonRepository.IPersonRepositoryCustom;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IPersonService {
    private IPersonRepositoryCustom personRepositoryCustom;

    private ModelMapper modelMapper;

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) { this.modelMapper = modelMapper; }

    @Autowired
    public void setIPersonCustomRepository(IPersonRepositoryCustom personRepositoryCustom){
        this.personRepositoryCustom = personRepositoryCustom;
    }

    @Override
    public PersonReturn findPersonBySsn(String ssn) {
        return personRepositoryCustom.findPersonBySsn(ssn);
    }

    @Override
    public PersonReturn findPersonByFirstNameAndLastName(String firstName, String lastName) {
        return personRepositoryCustom.findPersonByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public PersonReturn findPersonByCardNumberId(Integer cardNumberId) {
        return personRepositoryCustom.findPersonByCardSP(cardNumberId);
    }

    @Override
    public PersonReturn updatePerson(PersonUpdate person) {
        return personRepositoryCustom.updatePerson(modelMapper.map(person, PersonEntity.class));
    }

    @Override
    public PersonReturn createPerson(PersonCreation person) {
        return personRepositoryCustom.createPerson(modelMapper.map(person, PersonEntity.class));
    }
}
