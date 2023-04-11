package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.domain.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {
}
