package com.uca.capas.parcial.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(schema="public",name="cat_libro")
public class Libro {
	
	@Id
	@Column(name="c_libro")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer c_libro;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_categoria")
	private Categoria c_categoria;
	
	@Transient
	private Integer c_categoriafk;
	
	@Column(name="s_titulo")
	@Size(max=500, message="El campo sobrepasa la cantidad de 500 caracteres")
	@NotEmpty(message="“El campo titulo no puede estar vacío")
	private String s_titulo;
	
	@Column(name="s_autor")
	@Size(max=150, message="El campo sobrepasa la cantidad de 150 caracteres")
	@NotEmpty(message="“El campo autor no puede estar vacío")
	private String s_autor;
	
	@Column(name="f_ingreso")
	private Date f_ingreso;
	
	@Column(name="b_estado")
	private Boolean b_estado;
	
	@Column(name="s_isbn")
	@Size(max=10, message="El campo sobrepasa la cantidad de 10 caracteres")
	@NotEmpty(message="“El campo isbn no puede estar vacío")
	private String s_isbn;
	
	
	public Boolean getB_estado() {
		return b_estado;
	}

	public void setB_estado(Boolean b_estado) {
		this.b_estado = b_estado;
	}

	public String getS_isbn() {
		return s_isbn;
	}

	public void setS_isbn(String s_isbn) {
		this.s_isbn = s_isbn;
	}

	public Integer getC_libro() {
		return c_libro;
	}

	public void setC_libro(Integer c_libro) {
		this.c_libro = c_libro;
	}

	public Categoria getC_categoria() {
		return c_categoria;
	}

	public void setC_categoria(Categoria c_categoria) {
		this.c_categoria = c_categoria;
	}

	public Integer getC_categoriafk() {
		return c_categoriafk;
	}

	public void setC_categoriafk(Integer c_categoriafk) {
		this.c_categoriafk = c_categoriafk;
	}

	public String getS_titulo() {
		return s_titulo;
	}

	public void setS_titulo(String s_titulo) {
		this.s_titulo = s_titulo;
	}

	public String getS_autor() {
		return s_autor;
	}

	public void setS_autor(String s_autor) {
		this.s_autor = s_autor;
	}

	public String getF_ingreso() throws ParseException{
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:MM aa");
		Date date2 = new SimpleDateFormat("yyyy-mm-dd HH:MM:ss").parse(String.valueOf(f_ingreso));
		String strDate = formatter.format(date2);
		return strDate;
	}

	public void setF_ingreso(Date f_ingreso) {
		this.f_ingreso = f_ingreso;
	}

	public Libro() {
		super();
	}

	public String getEstadoDelegate() {
		if(this.b_estado==null)return "";
		else {
			return b_estado == true ? "Activo":"Inactivo";
		}
	}
	
	
}