package GTL_API.Repositories.BookReturnRespository;

import GTL_API.Models.Entities.BookReturnEntity;
import GTL_API.Models.ReturnModels.BookReturnReturn;

public interface IBookReturnRepositoryCustom {
    BookReturnReturn createBookReturn(BookReturnEntity bookReturnEntity);

    BookReturnReturn returnBook(int id);
}
