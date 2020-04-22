package GTL_API.Services;

import GTL_API.Models.ReturnModels.CoverTypeReturn;


public interface ICoverTypeService {
    CoverTypeReturn findCoverTypeByName(String coverType);
}
