package GTL_API.Repositories;

import GTL_API.Models.Entities.CoverTypeEntity;
import GTL_API.Models.ReturnModels.CoverTypeReturn;

public interface ICoverTypeCustom {
    CoverTypeReturn findCoverTypeByName(String coverType);

    CoverTypeReturn updateCoverType(CoverTypeEntity coverTypeEntity);
}
