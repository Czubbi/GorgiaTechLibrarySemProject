package GTL_API.repository;

import GTL_API.models.entities.CoverTypeEntity;
import GTL_API.models.serviceModels.CoverTypeToReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

@Component
public class CoverTypeImpl implements CoverTypeCustom {
    private CoverType coverType;
    private ModelMapper modelMapper;

    @Autowired
    public void setICoverType(CoverType coverType){
        this.coverType = coverType;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }


    @Override
    public CoverTypeToReturn findByCoverTypeName(String name) {
        CoverTypeEntity coverTypeFound = coverType.findByCoverTypeIs(name);
        return modelMapper.map(coverTypeFound, CoverTypeToReturn.class);
    }
}
