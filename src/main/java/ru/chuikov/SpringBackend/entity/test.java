package ru.chuikov.SpringBackend.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "test")
public class test implements Serializable {
	
	@Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment",strategy = "increment")
    private long id;
	
	@Column(name = "stroka")
    private String tstring;
	
	@Column(name = "chislo")
    private int tint;

	public test()
	{
		
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTstring() {
		return tstring;
	}

	public void setTstring(String tstring) {
		this.tstring = tstring;
	}
	public int getTint() {
		return tint;
	}

	public void setTint(int tint) {
		this.tint = tint;
	}
	


	public test(String tstring, int tint) {
		super();
		this.tstring = tstring;
		this.tint = tint;
	}

	public String toString() {
		return "test id = "+id+"; string = "+tstring+"; int = "+tint;
	}
}
