package pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table


public class Customer {
	@Id
	@GeneratedValue
	private Integer customerId;
	
	@Column
	private String CusomterName;
	
	@Column
	private int customerPhone;
	
	@Embedded
	private Address address;
	private Integer orderId;
	
	
	
	

}
