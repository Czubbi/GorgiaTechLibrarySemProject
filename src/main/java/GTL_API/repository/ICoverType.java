package GTL_API.repository;

import GTL_API.models.entities.CoverTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICoverType extends JpaRepository<CoverTypeEntity, Integer> {
    CoverTypeEntity findByCoverTypeIs(String coverType);
}
