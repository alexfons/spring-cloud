package demo.product.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import demo.product.model.Product;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {

	@RestResource
	Collection<Product> findByName(@Param("name") String name);

	@Override
	@PreAuthorize("hasAuthority('LIST_PRODUCT')")
	List<Product> findAll();

	@Override
	@PreAuthorize("hasAuthority('LIST_PRODUCT')")
	Page<Product> findAll(Pageable pageable);

	@Override
	@PreAuthorize("hasAuthority('LIST_PRODUCT')")
	List<Product> findAll(Iterable<Long> ids);

	@Override
	@PreAuthorize("hasAuthority('LIST_PRODUCT')")
	List<Product> findAll(Sort sort);

	@Override
	@PreAuthorize("hasAuthority('FIND_PRODUCT')")
	Product findOne(Long id);
}
