package com.ams.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.*;

import java.sql.Timestamp;
//import java.util.Date;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Caller {
	
	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int callid;//To generate Primary key
	
	private String callname;
	private String callcontnum;
	private String loc;
	private String hosid;
	private String status;
	//private LocalDateTime call_timestamp; 
	
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp call_timestamp;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="ambid", referencedColumnName="ambid")
	private Ambulance ambcaller;
	
	
	
}


