package GTL_API.services;

import GTL_API.models.serviceModels.CoverTypeToReturn;
import org.springframework.beans.factory.annotation.Autowired;
import GTL_API.repository.CoverTypeCustom;
import org.springframework.stereotype.Service;

@Service
public class CoverTypeService implements ICoverTypeService {

    private CoverTypeCustom coverTypeRepository;

    @Autowired
    public void setICoverTypeCustom(CoverTypeCustom coverTypeRepository) {
        this.coverTypeRepository = coverTypeRepository;
    }

    @Override
    public CoverTypeToReturn findCoverTypeByName(String name) {
        return coverTypeRepository.findByCoverTypeName(name);
    }
}