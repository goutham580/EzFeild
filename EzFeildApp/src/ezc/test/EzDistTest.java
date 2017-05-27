package ezc.test;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sap.security.core.server.csi.IXSSEncoder;
import com.sap.security.core.server.csi.XSSEncoder;

import ezc.model.EzBeat;
import ezc.model.EzBeatDistrubutor;
import ezc.model.EzBeatDistrubutorKey;
import ezc.model.EzDistrubutor;
import ezc.model.EzUser;
import ezc.model.EzUserBeat;
import ezc.model.EzUserBeatKey;

/**
 * Servlet implementing a simple JPA based persistence sample application for SAP Cloud Platform.
 */
public class EzDistTest extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = LoggerFactory.getLogger(EzDistTest.class);

    private DataSource ds;
    private EntityManagerFactory emf;

    /** {@inheritDoc} */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public void init() throws ServletException {
        Connection connection = null;
        try {
            InitialContext ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DefaultDB");

            Map properties = new HashMap();
            properties.put(PersistenceUnitProperties.NON_JTA_DATASOURCE, ds);
            emf = Persistence.createEntityManagerFactory("EzFeildApp", properties);
        } catch (NamingException e) {
            throw new ServletException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void destroy() {
        emf.close();
    }

    /** {@inheritDoc} */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	EntityManager em = emf.createEntityManager();
    	
    	Query query = em.createQuery("SELECT e, a FROM EzUser e,EzUserBeat a WHERE e.userId = a.ezUserBeatKey.userId");
    	List<Object[]> result5 = query.getResultList();
    	for (Object[] result : result5) {
    		 EzUser ezUser = (EzUser)result[0];
    		 EzUserBeat ezUserBeat = (EzUserBeat)result[1];
    		 response.getWriter().println("ezUser:::"+ezUser);
    		 response.getWriter().println("ezUserBeat:::"+ezUserBeat);
    	}
    	
    	response.getWriter().println("<p>Persistence with JPA Sample!</p>");
        try {
            appendEzUserTable(response);
            appendAddForm(response);
        } catch (Exception e) {
            response.getWriter().println("Persistence operation failed with reason: " + e.getMessage());
            LOGGER.error("Persistence operation failed", e);
        }
    }

    /** {@inheritDoc} */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        try {
            doAdd(request);
            doGet(request, response);
        } catch (Exception e) {
            response.getWriter().println("Persistence operation failed with reason: " + e.getMessage());
            LOGGER.error("Persistence operation failed", e);
        }
    }

    private void appendEzUserTable(HttpServletResponse response) throws SQLException, IOException {
        // 
    }

    private void appendAddForm(HttpServletResponse response) throws IOException {
        // Append form through which new EzUsers can be added
        response.getWriter().println(
                "<p><form action=\"\" method=\"post\">" + "First name:<input type=\"text\" name=\"FirstName\">"
                        + "&nbsp;Last name:<input type=\"text\" name=\"LastName\">"
                        + "&nbsp;<input type=\"submit\" value=\"Add EzUser\">" + "</form></p>");
    }

    private void doAdd(HttpServletRequest request) throws ServletException, IOException, SQLException {
        // Extract name of EzUser to be added from request
        String firstName = request.getParameter("FirstName");
        String lastName = request.getParameter("LastName");

        // Add EzUser if name is not null/empty
        EntityManager em = emf.createEntityManager();
        try {
            if (firstName != null && lastName != null && !firstName.trim().isEmpty() && !lastName.trim().isEmpty()) {
                EzUser EzUser = new EzUser();
                //EzUser.setEzUserId(124);
                EzUser.setUserId("11111");
                EzUser.setFirstName(firstName);
                
                em.getTransaction().begin();
                em.persist(EzUser);
                em.getTransaction().commit();
            }
            
            em = emf.createEntityManager();
            EzBeat ezBeats = new EzBeat();
            ezBeats.setBeatId(22222);
            ezBeats.setFirstName(firstName);
            ezBeats.setLastName(lastName);
            em.getTransaction().begin();
            em.persist(ezBeats);
            em.getTransaction().commit();
            
            em = emf.createEntityManager();
            EzUserBeatKey ezUserBeatKey = new EzUserBeatKey();
            ezUserBeatKey.setBeatId(22222);
            ezUserBeatKey.setUserId("11111");
            EzUserBeat ezUserBeat = new EzUserBeat();
            ezUserBeat.setEzUserBeatKey(ezUserBeatKey);
            em.getTransaction().begin();
            em.persist(ezUserBeat);
            em.getTransaction().commit();
            
    	    em = emf.createEntityManager();
            EzDistrubutor ezDistrubutors = new EzDistrubutor();
            ezDistrubutors.setDistrubutorId(33333);
            ezDistrubutors.setDistName("12333");
            em.getTransaction().begin();
            em.persist(ezDistrubutors);
            em.getTransaction().commit();
            

            
            em = emf.createEntityManager();
            EzBeatDistrubutorKey ezBeatDistrubutorKey = new EzBeatDistrubutorKey();
            ezBeatDistrubutorKey.setDistrubutorId(33333);
            ezBeatDistrubutorKey.setBeatId("22222");
            EzBeatDistrubutor ezBeatDistrubutor = new EzBeatDistrubutor();
            ezBeatDistrubutor.setEzBeatDistrubutorKey(ezBeatDistrubutorKey);
            em.getTransaction().begin();
            em.persist(ezBeatDistrubutor);
            em.getTransaction().commit();
            
            
        } finally {
            em.close();
        }
    }
}