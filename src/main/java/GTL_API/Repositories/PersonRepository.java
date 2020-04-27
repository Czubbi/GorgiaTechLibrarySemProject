package GTL_API.Repositories;

import GTL_API.Exceptions.NotFoundException;
import GTL_API.Exceptions.UpdateException;
import GTL_API.Handlers.PatcherHandler;
import GTL_API.Models.Entities.PersonEntity;
import GTL_API.Models.ReturnModels.PersonReturn;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PersonRepository implements IPersonRepositoryCustom{
    private IPersonRepository iPerson;
    private ModelMapper modelMapper;
    private PatcherHandler patcherHandler;

    @Autowired
    public void setPatcherHandler(PatcherHandler patcherHandler) { this.patcherHandler = patcherHandler; }

    @Autowired
    public void setIPerson(IPersonRepository iPerson) { this.iPerson = iPerson; }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) { this.modelMapper = modelMapper; }

    @Override
    public PersonReturn findPersonBySsn(String ssn) {
        try{
            PersonEntity foundPerson = findBySsnIfExistsAndReturn(ssn);
            return modelMapper.map(foundPerson, PersonReturn.class);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public PersonReturn findPersonByFirstNameAndLastName(String firstName, String lastName) {
        try{
            PersonEntity foundPerson = findByFirstNameAndLastNameIfExistsAndReturn(firstName, lastName);
            return modelMapper.map(foundPerson, PersonReturn.class);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public PersonReturn findPersonByCardNumberId(Integer cardNumberId) {
        try{
            PersonEntity foundPerson = findByCardNumberIdIfExistsAndReturn(cardNumberId);
            return modelMapper.map(foundPerson, PersonReturn.class);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public PersonReturn updatePerson(PersonEntity personEntity) {
        try {
            PersonEntity found = findBySsnIfExistsAndReturn(personEntity.getSsn());
            patcherHandler.fillNotNullFields(found, personEntity);
            checkIfExistsBySsn(found);
            PersonEntity updated = iPerson.save(found);
            return modelMapper.map(updated, PersonReturn.class);
        }catch(NotFoundException notFoundException) {
            throw notFoundException;
        } catch (Exception e){
            throw new UpdateException("There was an unexpected error while updating the person");
        }
    }

    @Override
    public PersonReturn createPerson(PersonEntity personEntity) {
        return null;
        /*try{

        } catch (Exception e) {
            throw new CreationException("There was an unexpected error while updating the person");
        }*/
    }

    private PersonEntity findBySsnIfExistsAndReturn(String ssn) {
        Optional<PersonEntity> foundPerson;
        String message = null;
        foundPerson = iPerson.findBySsnIs(ssn);
        message = String.format("Person with ssn: %s was not found", ssn);

        if (foundPerson.isPresent()) {
            return foundPerson.get();
        } else {
            throw new NotFoundException(message);
        }
    }

    private PersonEntity findByFirstNameAndLastNameIfExistsAndReturn(String firstName, String lastName) {
        Optional<PersonEntity> foundPerson;
        String message = null;

        foundPerson = iPerson.findByFirstNameIsAndLastNameIs(firstName, lastName);
        message = String.format("Person with name: %s %s was not found", firstName, lastName);

        if (foundPerson.isPresent()) {
            return foundPerson.get();
        } else {
            throw new NotFoundException(message);
        }
    }

    private PersonEntity findByCardNumberIdIfExistsAndReturn(Integer cardNumberId) {
        Optional<PersonEntity> foundPerson;
        String message = null;
        foundPerson = iPerson.findByCardNumberIdIs(cardNumberId);
        message = String.format("Person with card number: %s was not found", cardNumberId);

        if (foundPerson.isPresent()) {
            return foundPerson.get();
        } else {
            throw new NotFoundException(message);
        }
    }

    private void checkIfExistsBySsn(PersonEntity personEntity){
        if (iPerson.countAllBySsn(personEntity.getSsn())==0){
            throw new NotFoundException("You tried to update a person who does not exist in the database. Choose differetn ssn");
        }
    }

}

