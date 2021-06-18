package cst438.repositories;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import cst438.domain.*;

public interface CarRepository extends JpaRepository<Car, Long>{
	
	
	List<Car> findAll();
	
	
	@Query("SELECT c FROM Car c ORDER BY price")
	List<Car> findByPrice();
    
	
	@Query(value = "SELECT * FROM Car WHERE id = ?1", nativeQuery = true)
    List<Car> findById(int id);
	
	
	Car findCarById(int id);
    
	
	@Query(value = "SELECT * FROM Car  WHERE city LIKE ?1", nativeQuery = true)
	List<Car> findByCity(String city);
    

}