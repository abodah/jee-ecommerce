package org.jee.ecommerce.catalogue.entity;

import java.io.Serializable;
import java.util.Date;

public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private String description;
	private boolean active;
	private Date createdAt;
	private Date updatedAt;

}
