package GTL_API.repository;

import GTL_API.models.serviceModels.CoverTypeToReturn;

public interface CoverTypeCustom {
    CoverTypeToReturn findByCoverTypeName(String name);
}
