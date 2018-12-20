package demo.product.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6360717661176366888L;
	@Id @GeneratedValue
    private Long id;
}
