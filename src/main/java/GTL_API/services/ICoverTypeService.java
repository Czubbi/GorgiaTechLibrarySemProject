package GTL_API.services;

import GTL_API.models.serviceModels.CoverTypeToReturn;
import org.springframework.stereotype.Service;


public interface ICoverTypeService {
    CoverTypeToReturn findCoverTypeByName(String name);
}
