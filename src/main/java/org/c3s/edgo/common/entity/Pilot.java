package org.c3s.edgo.common.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Pilot
 *
 */
@Entity
@Table(name="pilots")
public class Pilot implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Pilot() {
	}
	
	/**
	 * Pilot ID  
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pilot_id")
	private int id;
	
	/**
	 * Pilot Name
	 */
	@Column(name="pilot_name")
	private String name;
	
	
	
	
}
