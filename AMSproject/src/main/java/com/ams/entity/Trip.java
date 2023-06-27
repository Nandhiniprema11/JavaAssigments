package com.ams.entity;
import java.sql.Date;
import org.hibernate.annotations.Type;

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

public class Trip {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private int tripid;//To generate Primary key

	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp sttimestamp;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp edimestamp;
	private String sloc;
	private String dloc;
	private String distrav;
	private String tripstatus;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="callid", referencedColumnName="callid")
	private Caller callerId;
	
	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp call_timestamp;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="ambid", referencedColumnName="ambid")
	private Ambulance ambtrip;
	
}

