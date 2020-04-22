package GTL_API.repository;

import GTL_API.models.serviceModels.CoverTypeToReturn;

public interface ICoverTypeCustom {
    CoverTypeToReturn findByCoverTypeName(String name);
}
