package com.github.hugovallada.orderscontrol.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User implements Serializable {
	
	@EqualsAndHashCode.Include
	private Long id;
	
	private String name;
	
	private String email;
	
	private String phone;
	
	private String password;
	
	
	
}
