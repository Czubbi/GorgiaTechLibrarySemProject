package GTL_API.Repositories;

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
    private ICoverType iCoverType;
    private ModelMapper modelMapper;
    private PatcherHandler patcherHandler;

    @Autowired
    public void setPatcherHandler(PatcherHandler patcherHandler) {
        this.patcherHandler = patcherHandler;
    }

    @Autowired
    public void setICoverType(ICoverType iCoverType) {
        this.iCoverType = iCoverType;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CoverTypeReturn findCoverTypeByName(String coverType) {
        try {
            CoverTypeEntity foundCoverType = findIfExistsAndReturn(Optional.of(coverType));
            return modelMapper.map(foundCoverType, CoverTypeReturn.class);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public CoverTypeReturn updateCoverType(CoverTypeEntity coverTypeEntity) {
        try {
            CoverTypeEntity found = findIfExistsAndReturn(Optional.of(coverTypeEntity.getId()));
            patcherHandler.fillNotNullFields(found, coverTypeEntity);
            checkIfExistsByCoverType(found);
            CoverTypeEntity updated = iCoverType.save(found);
            return modelMapper.map(updated, CoverTypeReturn.class);
        } catch(DuplicateException duplicateException) {
            throw duplicateException;
        } catch (Exception e) {
            throw new UpdateException("There was an unexpected error while updating the cover type.");
        }
    }

    private CoverTypeEntity findIfExistsAndReturn(Optional<?> searchValue) {
        Optional<CoverTypeEntity> foundCoverType = Optional.empty();
        String message = null;
        if (searchValue.get() instanceof String) {
            foundCoverType = iCoverType.findByCoverTypeIs((String) searchValue.get());
            message = String.format("Cover type of name: %s wass not found.", searchValue.get());
        } else if (searchValue.get() instanceof Integer) {
            foundCoverType = iCoverType.findById((Integer) searchValue.get());
            message = String.format("Cover type was not found.");
        }
        if (foundCoverType.isPresent()) {
            return foundCoverType.get();
        } else {
            throw new NotFoundException(message);
        }
    }


    private void checkIfExistsByCoverType(CoverTypeEntity coverTypeEntity) {
        if (iCoverType.countAllByCoverTypeIs(coverTypeEntity.getCoverType()) > 0) {
            throw new DuplicateException("You tried to update a cover type to a name that already exists. Choose " +
                    "different name.");
        }
    }
}
