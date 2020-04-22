package GTL_API.Services;

import GTL_API.Models.ReturnModels.CoverTypeReturn;
import GTL_API.Repositories.ICoverTypeCustom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoverTypeService implements ICoverTypeService {

    private ICoverTypeCustom iCoverTypeRepository;

    @Autowired
    public void setICoverTypeRepository(ICoverTypeCustom iCoverTypeRepository) {
        this.iCoverTypeRepository = iCoverTypeRepository;
    }

    @Override
    public CoverTypeReturn findCoverTypeByName(String coverType) {
        return iCoverTypeRepository.findCoverTypeByName(coverType);
    }
}