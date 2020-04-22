package GTL_API.Repositories;

import GTL_API.Models.Entities.CoverTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ICoverType extends JpaRepository<CoverTypeEntity, Integer> {
    Optional<CoverTypeEntity> findByCoverTypeIs(String coverType);
    int countAllByCoverTypeIs(String coverType);
}
