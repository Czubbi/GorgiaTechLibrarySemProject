package GTL_API.services;

import GTL_API.models.exceptions.NotFoundException;
import GTL_API.models.serviceModels.CoverTypeToReturn;
import org.springframework.beans.factory.annotation.Autowired;
import GTL_API.repository.ICoverTypeCustom;
import org.springframework.stereotype.Service;

@Service
public class CoverTypeService implements ICoverTypeService {

    private ICoverTypeCustom coverTypeRepository;

    @Autowired
    public void setICoverTypeCustom(ICoverTypeCustom coverTypeRepository) {
        this.coverTypeRepository = coverTypeRepository;
    }

    @Override
    public CoverTypeToReturn findCoverTypeByName(String name) {
        return coverTypeRepository.findByCoverTypeName(name);
    }
}