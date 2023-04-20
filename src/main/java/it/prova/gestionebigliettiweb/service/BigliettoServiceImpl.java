package it.prova.gestionebigliettiweb.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionebigliettiweb.dao.BigliettoDAO;
import it.prova.gestionebigliettiweb.listener.LocalEntityManagerFactoryListener;
import it.prova.gestionebigliettiweb.model.Biglietto;

public class BigliettoServiceImpl implements BigliettoService {

	private BigliettoDAO bigliettaDao;

	@Override
	public List<Biglietto> listAll() throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();
		
		try {
			// uso l'injection per il dao
			bigliettaDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return bigliettaDao.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}


	@Override
	public Biglietto caricaSingoloElemento(Long idInput) throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			bigliettaDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return bigliettaDao.findOne(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void aggiorna(Biglietto input) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inserisciNuovo(Biglietto input) throws Exception {
		// questo è come una connection
				EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

				try {
					// questo è come il MyConnection.getConnection()
					entityManager.getTransaction().begin();

					// uso l'injection per il dao
					bigliettaDao.setEntityManager(entityManager);

					// eseguo quello che realmente devo fare
					bigliettaDao.insert(input);

					entityManager.getTransaction().commit();
				} catch (Exception e) {
					entityManager.getTransaction().rollback();
					e.printStackTrace();
					throw e;
				} finally {
					LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
				}
		
	}

	@Override
	public void rimuovi(Long idArticoloToRemove) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();
		try {

			entityManager.getTransaction().begin();

			// injection
			bigliettaDao.setEntityManager(entityManager);

			bigliettaDao.delete(bigliettaDao.findOne(idArticoloToRemove));

			//commit
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			//rollback se esito negativo
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
		
	}

	@Override
	public List<Biglietto> findByExample(Biglietto input) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBigliettoDao(BigliettoDAO bigliettoDao) {
		this.bigliettaDao=bigliettoDao;
		
	}
	

}
