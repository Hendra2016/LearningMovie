package co.l.nostra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.l.nostra.model.domain.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long>{

}
