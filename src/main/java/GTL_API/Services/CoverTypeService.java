package GTL_API.Services;

import GTL_API.Models.Entities.CoverTypeEntity;
import GTL_API.Models.ReturnModels.CoverTypeReturn;
import GTL_API.Models.UpdateModels.CoverTypeUpdate;
import GTL_API.Repositories.ICoverTypeCustom;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoverTypeService implements ICoverTypeService {

    private ICoverTypeCustom iCoverTypeRepository;

    private ModelMapper modelMapper;

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Autowired
    public void setICoverTypeRepository(ICoverTypeCustom iCoverTypeRepository) {
        this.iCoverTypeRepository = iCoverTypeRepository;
    }

    @Override
    public CoverTypeReturn findCoverTypeByName(String coverType) {
        return iCoverTypeRepository.findCoverTypeByName(coverType);
    }

    @Override
    public CoverTypeReturn updateCoverType(CoverTypeUpdate coverType) {
        return iCoverTypeRepository.updateCoverType(modelMapper.map(coverType, CoverTypeEntity.class));
    }
}