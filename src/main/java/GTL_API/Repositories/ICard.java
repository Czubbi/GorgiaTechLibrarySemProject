package GTL_API.Repositories;

import GTL_API.Models.Entities.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICard extends JpaRepository<CardEntity, Integer> {
    Optional<CardEntity> findByNumberIs(int number);

    boolean existsByNumber(int number);

}
