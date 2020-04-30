package GTL_API.Repositories.BookBorrowRepository;

import GTL_API.Models.Entities.BookBorrowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookBorrowRepository extends JpaRepository<BookBorrowEntity, Integer> {
}
