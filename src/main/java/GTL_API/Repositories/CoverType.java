package GTL_API.Repositories;

import GTL_API.Exceptions.UnknownException;
import GTL_API.Exceptions.UpdateException;
import GTL_API.Handlers.PatcherHandler;
import GTL_API.Models.Entities.CoverTypeEntity;
import GTL_API.Exceptions.DuplicateException;
import GTL_API.Exceptions.NotFoundException;
import GTL_API.Models.ReturnModels.CoverTypeReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

import java.util.Optional;

@Component
public class CoverType implements ICoverTypeCustom {
    /**
     * Instance of a ICoverType interface that extends JPARepository.
     */
    private ICoverType iCoverType;

    /**
     * Instance of a ModelMapper class.
     */
    private ModelMapper modelMapper;

    /**
     * Instance of a PatcherHandler class.
     */
    private PatcherHandler patcherHandler;

    /**
     * Instantiation of a PatcherHandler class.
     * @param patcherHandler An object that will be assigned to class's patcherHandler attribute.
     */
    @Autowired
    public void setPatcherHandler(PatcherHandler patcherHandler) {
        this.patcherHandler = patcherHandler;
    }

    /**
     * Instantiation of a ICoverType interface.
     * @param iCoverType An object that will be assigned to class's iCoverType attribute.
     */
    @Autowired
    public void setICoverType(ICoverType iCoverType) {
        this.iCoverType = iCoverType;
    }

    /**
     * Instantiation of a ModelMapper class.
     *
     * @param modelMapper An object that will be assigned to class's modelMapper attribute.
     */
    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    /**
     * A method that finds a cover type record in a database and returns the found object that is mapped
     * to the CoverTypeReturn class.
     * @param coverType Name of a cover type that is being stored in a database.
     * @return Object of CoverTypeReturn class with filled information.
     */
    @Override
    public CoverTypeReturn findCoverTypeByName(String coverType) {
        try {
            CoverTypeEntity foundCoverType = findIfExistsAndReturn(Optional.of(coverType));
            return modelMapper.map(foundCoverType, CoverTypeReturn.class);
        } catch (Exception e) {
            throw new UnknownException(String.format("There was an unknown exception while finding a cover" +
                    " type with name: %s", coverType));
        }
    }

    /**
     * A method updates a cover types that is being stored in a database. First it invokes findIfExistsAndReturn
     * method that optionally returns a stored record from a database. Next, it takes advantage from patcher handler
     * to fill not null fields of passed method parameter. Having done that, it uses checkIfExistsByCoverType method to
     * prevent adding duplicate records with the same coverType name. At the end, the record is being updated by using
     * iCoverType object's save() method, which returns updated object which is later mapped to CoverTypeReturn class
     * and returned.
     * @param coverTypeEntity CoverTypeEntity object with new information.
     * @return CoverTypeReturn object with updated information.
     */
    @Override
    public CoverTypeReturn updateCoverType(CoverTypeEntity coverTypeEntity) {
        try {
            CoverTypeEntity found = findIfExistsAndReturn(Optional.of(coverTypeEntity.getId()));
            patcherHandler.fillNotNullFields(found, coverTypeEntity);
            checkIfExistsByCoverType(found);
            CoverTypeEntity updated = iCoverType.save(found);
            return modelMapper.map(updated, CoverTypeReturn.class);
        } catch (DuplicateException duplicateException) {
            throw duplicateException;
        } catch (Exception e) {
            throw new UpdateException("There was an unexpected error while updating the cover type.");
        }
    }

    /**
     * The methods checks if a record of coverType table is present in a database. The implementation of the method
     * allows to search weather by CoverTypeEntity's id or coverType attributes. Depending on the type of a passed
     * parameter, the method searching differs.
     * @param searchValue Optional class's object with generic value.
     * @return Found object of CoverTypeEntity class.
     */
    private CoverTypeEntity findIfExistsAndReturn(Optional<?> searchValue) {
        Optional<CoverTypeEntity> foundCoverType = Optional.empty();
        String message = null;
        if (searchValue.isPresent() && searchValue.get() instanceof String) {
            foundCoverType = iCoverType.findByCoverTypeIs((String) searchValue.get());
            message = String.format("Cover type of name: %s was not found.", searchValue.get());
        } else if (searchValue.isPresent() && searchValue.get() instanceof Integer) {
            foundCoverType = iCoverType.findById((Integer) searchValue.get());
            message = "Cover type was not found.";
        }
        if (foundCoverType.isPresent()) {
            return foundCoverType.get();
        } else {
            throw new NotFoundException(message);
        }
    }

    /**
     * The method checks if there already exists a record in a database with the same coverType name as one that
     * passed parameter has. If there is such record, the method throws DuplicateException.
     * @param coverTypeEntity An object of CoverTypeEntity class.
     */
    private void checkIfExistsByCoverType(CoverTypeEntity coverTypeEntity) {
        if (iCoverType.countAllByCoverTypeIs(coverTypeEntity.getCoverType()) > 0) {
            throw new DuplicateException("You tried to update a cover type to a name that already exists. Choose " +
                    "different name.");
        }
    }
}
