package com.nizar.gameworkshop.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "games", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "name" }, name = "unique_name_constraint") })
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Name is required")
	@Column(unique = true)
	private String name;

	@NotBlank(message = "Genre is required")
	private String genre;

	@NotBlank(message = "Description is required")
	private String description;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	// M:1
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	// 1:M
	@OneToMany(mappedBy = "game", fetch = FetchType.LAZY)
	private List<GameMechanic> gameMechanics;

	// ZERO ARGS CONSTRUCTOR
	public Game() {
	}

	// ALL ARGS CONSTRUCTOR
	public Game(String name, String genre, String description) {

		this.name = name;
		this.genre = genre;
		this.description = description;
	}

	// GETTERS & SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<GameMechanic> getGameMechanics() {
		return gameMechanics;
	}

	public void setGameMechanics(List<GameMechanic> gameMechanics) {
		this.gameMechanics = gameMechanics;
	}

	// Save the date before the object is created
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	// Save the date on every update
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

}
