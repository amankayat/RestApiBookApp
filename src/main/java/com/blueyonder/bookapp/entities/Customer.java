package com.blueyonder.bookapp.entities;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.ToString.Exclude;

@Entity
@Table(name="customer_info")
@Getter
@Setter

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer customerId;
private String customerName;
private String gender;
private LocalDate dateofbirth;

@OneToMany(cascade = CascadeType.ALL,mappedBy="customer")
@JsonManagedReference
@Exclude
private Set<Address> address;
@OneToOne(cascade = CascadeType.ALL)
private Users user;
}
