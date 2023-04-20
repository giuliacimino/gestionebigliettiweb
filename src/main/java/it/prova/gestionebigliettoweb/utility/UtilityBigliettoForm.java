package it.prova.gestionebigliettoweb.utility;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionebigliettiweb.model.Biglietto;

//nel nome della classe vi è Articolo in quanto è una classe specifica
public class UtilityBigliettoForm {

	public static Biglietto createBigliettoFromParams(String provenienzaInputParam, String destinazioneInputParam,
			String prezzoInputStringParam, String dataStringParam) {

		Biglietto result = new Biglietto(provenienzaInputParam, destinazioneInputParam);

		if (NumberUtils.isCreatable(prezzoInputStringParam)) {
			result.setPrezzo(Integer.parseInt(prezzoInputStringParam));
		}
		result.setData(parseDateArrivoFromString(dataStringParam));

		return result;
	}
	
	
	
	

	public static boolean validateBigliettoBean(Biglietto bigliettoToBeValidated) {
		// prima controlliamo che non siano vuoti i parametri
		if (StringUtils.isBlank(bigliettoToBeValidated.getProvenienza())
				|| StringUtils.isBlank(bigliettoToBeValidated.getDestinazione())
				|| bigliettoToBeValidated.getPrezzo() == null || bigliettoToBeValidated.getPrezzo() < 1
				|| bigliettoToBeValidated.getData() == null) {
			return false;
		}
		return true;
	}

	public static LocalDate parseDateArrivoFromString(String dataStringParam) {
		if (StringUtils.isBlank(dataStringParam))
			return null;

		try {
			return LocalDate.parse(dataStringParam);
		} catch (DateTimeParseException e) {
			return null;
		}
	}

}
