package br.com.aline.votenorestaurante.DAO;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import br.com.aline.votenorestaurante.DAO.mock.MockEntidade;

public class EntidadeDAOTest {

	private EntidadeDAO<MockEntidade> entidadeDao;
	private EntidadeDAO<MockEntidade> entidadeDaoSpy;

	private Session session;
	private Criteria criteria;
	private SessionFactory sessionFactory;

	@Before
	public void setup() throws Exception {
		entidadeDao = new EntidadeDAO<MockEntidade>();
		sessionFactory = mock(SessionFactory.class);
		session = mock(Session.class);
		criteria = mock(Criteria.class);
		entidadeDaoSpy = PowerMockito.spy(entidadeDao);

		when(entidadeDaoSpy.buildSessionFactory()).thenReturn(sessionFactory);
		when(sessionFactory.openSession()).thenReturn(session);
		when(session.createCriteria(any(Class.class))).thenReturn(criteria);
		when(session.isOpen()).thenReturn(true);

	}

	@SuppressWarnings("unchecked")
	@Test
	public void testeBuscarPorIdThrowException() {
		when(criteria.uniqueResult()).thenThrow(Exception.class);

		MockEntidade mockEntidade = null;
		assertNull(mockEntidade);
		mockEntidade = entidadeDaoSpy.buscaPorId(MockEntidade.class, 1l);
		assertNull(mockEntidade);
	}

	@Test
	public void testBuscarPorId() {
		when(criteria.uniqueResult()).thenReturn(new MockEntidade());
		MockEntidade mockEntidade = null;
		assertNull(mockEntidade);
		mockEntidade = entidadeDaoSpy.buscaPorId(MockEntidade.class, 1l);
		assertNotNull(mockEntidade);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testeListaThrowsException(){
		when(criteria.list()).thenThrow(Exception.class); 
		
		List<MockEntidade> mockEntidades = null; 
		assertNull(mockEntidades);
		mockEntidades = entidadeDaoSpy.lista(MockEntidade.class); 
		assertNotNull(mockEntidades);
		assertTrue(mockEntidades.isEmpty());
	}
	
	@Test
	public void testeLista(){
		List<MockEntidade> mockEntidades = new ArrayList<MockEntidade>(); 
		mockEntidades.add(new MockEntidade()); 
		
		when(criteria.list()).thenReturn(mockEntidades); 
		
		List<MockEntidade> mockEntidadesResposta = null; 
		assertNull(mockEntidadesResposta);
		mockEntidadesResposta = entidadeDaoSpy.lista(MockEntidade.class);
		assertTrue(mockEntidadesResposta.size() > 0);
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testeCriarThrowsException(){
		when(session.save(any(MockEntidade.class))).thenThrow(Exception.class);
		Transaction transacao = mock(Transaction.class); 
		when(session.getTransaction()).thenReturn(transacao); 
		
		MockEntidade mockEntidade = null; 
		assertNull(mockEntidade);
		mockEntidade = entidadeDaoSpy.criar(new MockEntidade()); 
		verify(transacao, times(1)).rollback();
	}
	
	@Test
	public void testCriar(){
		Serializable serializable = mock(Serializable.class); 
		when(session.save(any(MockEntidade.class))).thenReturn(serializable); 
		Transaction transacao = mock(Transaction.class); 
		when(session.getTransaction()).thenReturn(transacao); 
		
		MockEntidade mockEntity = new MockEntidade(); 
		mockEntity = entidadeDaoSpy.criar(mockEntity); 
		verify(session, times(1)).save(any(MockEntidade.class)); 
		verify(transacao, times(1)).commit();
		
	}

}
