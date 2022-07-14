package org.jee.ecommerce.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "jee_catalog_product")
public class Product implements Serializable {
	
	private long id;
	private String reference;
	private String ean13;
	private String name;
	private String description;
	private float price;
	private boolean active;
	private Date createAt;
	private Date updateAt;
}
