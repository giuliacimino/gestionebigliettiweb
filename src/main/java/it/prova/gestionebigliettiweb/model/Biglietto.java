package it.prova.gestionebigliettiweb.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "biglietto")
public class Biglietto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "provenienza")
	private String provenienza;
	
	@Column(name = "destinazione")
	private String destinazione;
	@Column(name = "prezzo")
	private Integer prezzo;
	@Column(name = "data")
	private LocalDate data;

	// campi per le time info del record
	@CreationTimestamp
	private LocalDateTime createDateTime;
	@UpdateTimestamp
	private LocalDateTime updateDateTime;
	
	
	public Biglietto() {
		
	}
	
	
	public Biglietto(String provenienza, String destinazione, Integer prezzo, LocalDate data) {
		this.provenienza=provenienza;
		this.destinazione=destinazione;
		this.prezzo=prezzo;
		this.data=data;
	}
	
	public Biglietto(String provenienza, String destinazione) {
		this.provenienza=provenienza;
		this.destinazione=destinazione;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getProvenienza() {
		return provenienza;
	}


	public void setProvenienza(String provenienza) {
		this.provenienza = provenienza;
	}


	public String getDestinazione() {
		return destinazione;
	}


	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}


	public Integer getPrezzo() {
		return prezzo;
	}


	public void setPrezzo(Integer prezzo) {
		this.prezzo = prezzo;
	}


	public LocalDate getData() {
		return data;
	}


	public void setData(LocalDate data) {
		this.data = data;
	}


	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}


	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}


	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}


	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	
	
	

}
