package com.bm.ecommerce.model;


import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private BigDecimal price;

	private String description;

	@Column(nullable = false)
	private int stock;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	// ---------- constructors ------------
	public Product() {
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
	}

	public Product(Long id, String name, BigDecimal price, String description, int stock, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.stock = stock;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	//--------- getters and setters ---------

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	public int getStock() {
		return stock;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void touchUpdatedAt() {
		this.updatedAt = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ""
				+ ", name=" + name + ""
				+ ", price=" + price + 
				", description=" + description +
				", stock="+ stock + 
				", createdAt=" + createdAt + 
				", updatedAt=" + updatedAt + "]";
	}





}
