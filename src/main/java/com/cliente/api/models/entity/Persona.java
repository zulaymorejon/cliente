package com.cliente.api.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="persona")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Builder
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona  implements Serializable{
	
	@Id
	@Pattern(regexp = "[0-9]+",message = "Solo permite valores numericos")
	@NotEmpty(message = "El campo no puede ser vacio")
	@Column(unique=true, length = 10, name="cedula")
	private String identificacion;
	
	@Pattern(regexp = "[A-Za-z]+",message = "Solo se deben ingresar letras")
	@NotEmpty(message = "El campo no puede ser vacio")
	@Column(name = "nombre")
	private String nombre;
	
	@Pattern(regexp = "[A-Za-z]+",message = "Solo se deben ingresar letras")
	@NotEmpty(message = "El campo no puede ser vacio")
	@Column(name = "genero")
	private String genero;
	
	@Pattern(regexp = "[0-9]+",message = "Solo se deben ingresar numeros")
	@NotEmpty(message = "El campo no puede ser vacio")
	@Column(name = "edad")
	private int edad;
	
	@Pattern(regexp = "[A-Za-z]+",message = "Solo se deben ingresar letras")
	@NotEmpty(message = "El campo no puede ser vacio")
	@Column(name = "direccion")
	private String direccion;
	
	@Pattern(regexp = "[0-9]+",message = "Solo se deben ingresar numeros")
	@NotEmpty(message = "El campo no puede ser vacio")
	@Column(name = "telefono")
	private String telefono;
}
