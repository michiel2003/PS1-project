package application.entitys.images;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRep extends CrudRepository<Image, Integer>{
	
	@Query(value = "select url from image", nativeQuery = true)
	List<String> findAllUrl();
	
	

}
