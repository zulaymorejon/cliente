package com.cliente.api.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Table(name="cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "identificacion")
public class Cliente extends Persona {

	
	Cliente(String identificacion, String nombre, String genero, int edad, String direccion, String telefono) {
		super(identificacion, nombre, genero, edad, direccion, telefono);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = -1178543396264436804L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long clienteId;
	
	@NotEmpty(message = "El campo no puede ser vacio")
	@Column(name = "password")
	private String password;
	
	@NotEmpty(message = "El campo no puede ser vacio")
	@Column(name = "estado")
	private String estado;
}
