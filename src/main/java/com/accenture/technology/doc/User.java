package com.accenture.technology.doc;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Document(collection = "users")
@JsonPropertyOrder({"id", "name"})
public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    private String id;

    @NotNull
    private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}




}

