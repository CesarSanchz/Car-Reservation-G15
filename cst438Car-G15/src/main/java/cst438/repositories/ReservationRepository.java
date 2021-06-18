package cst438.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import cst438.domain.*;
public interface ReservationRepository extends JpaRepository<Reservation, Long>{
	
	
	List<Reservation> findAll();
	
	
	@Query(value = "SELECT * FROM Reservations WHERE email LIKE %?1 ORDER BY rid desc  LIMIT 1", nativeQuery = true)
	Reservation findByEmail(String email);
	
	
	@Query(value = "SELECT * FROM Reservations WHERE email LIKE %?1 ORDER BY rid asc", nativeQuery = true)
	List<Reservation> findEmails(String email);
	
	
	@Query(value = "SELECT * FROM Reservations WHERE rid = ?1", nativeQuery = true)
    List<Reservation> findById(int rid);

}