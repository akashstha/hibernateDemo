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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="orderItems")
public class OrderItems {
	@Id
	@GeneratedValue
	private Integer itemId;
	
	@Column
	private String itemName;
	
	@Column
	private double itemPrice;
	
	@OneToMany
	@JoinColumn(name="itemId")
	private List<Orders> orders;
	
	

}
