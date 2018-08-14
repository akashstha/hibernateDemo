package pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table


public class Orders {
	@Id
	@GeneratedValue
	private Integer orderId;
	
	@Column
	private String orderStatus;
	
	@OneToMany
	@JoinColumn(name="orderId")
	private List<Customer>customerDetails;
	private Integer itemId;
	
	

}
