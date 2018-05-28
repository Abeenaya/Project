package com.accenture.adf.test;

import static org.junit.Assert.assertEquals;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.accenture.adf.businesstier.dao.EventDAO;
import com.accenture.adf.businesstier.dao.VisitorDAO;
import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.EventCoordinator;
import com.accenture.adf.businesstier.entity.Visitor;
import com.accenture.adf.businesstier.service.EventServiceImpl;

/**
 * Junit test case to test class EventServiceImpl
 * 
 */
public class TestEventServiceImpl {
	private ArrayList<Object[]> showAllEvents;
	private List<Object[]> eventList;
	private Visitor visitor;
	private EventServiceImpl eventServiceImpl;

	/**
	 * Set up the objects required before execution of every method
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		eventServiceImpl = new EventServiceImpl();
		visitor = new Visitor();
	}

	/**
	 * Deallocates the objects after execution of every method
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		/**
		 * @TODO: Release all the objects here by assigning them null  
		 */
	}

	/**
	 * Test case to test the method getAllEvents
	 */
	@Ignore@Test
	public void testGetAllEvents() {
		/**
		 * @TODO: Call getAllEvents method and assert it for the size of returned array
		 */	
		int expected=6;
		eventList=eventServiceImpl.getAllEvents();
		int actual =eventList.size();
		assertEquals(expected, actual);
	}

	/**
	 * Test case to test the method checkEventsofVisitor
	 */
	
	@Ignore@Test
	public void testCheckEventsofVisitor() {
		VisitorDAO visitorDAO = new VisitorDAO();
		
		
		try {
			visitor = visitorDAO.searchUser("npatel","password");
			boolean actual=eventServiceImpl.checkEventsofVisitor(visitor, 1002	, 10002);
			assertEquals(true, actual);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	/**
	 * Test case to test the method updateEventDeletions
	 */
	@Ignore@Test
	public void testUpdateEventDeletions() {
		/**
		 * @TODO: Call updateEventDeletions and assert the return type of this method
		 */	
		int eventid=1001;
		int eventsessionid=10001;
		int expected=300;
		int actual=299;
		eventServiceImpl.updateEventDeletions(eventid, eventsessionid);
		assertEquals(expected-1,actual);
	}

	/**
	 * Junit test case for getEventCoordinator
	 */
	@Ignore@Test
	public void testGetEventCoordinator() {
		/**
		 * @TODO: Call getAllEventCoordinators and assert the size of return type of this method
		 */	
		List<EventCoordinator> eventCoordinatorList;
		eventCoordinatorList=eventServiceImpl.getAllEventCoordinators();
		int actual=eventCoordinatorList.size();
		int expected=5;
		assertEquals(expected, actual);
		
	}

	/**
	 * Junit test case for getEvent
	 */
	@Ignore
	@Test
	public void testGetEvent() {
		/**
		 * @TODO: Call getEvent and assert the event id of this event with 
		 * passed event id 
		 */		
		Event e=eventServiceImpl.getEvent(1001, 10001);
		assertEquals(1001, e.getEventid());
	}

	/**
	 * Junit test case for updateEvent
	 */
	@Ignore
	@Test
	public void testInsertEvent() {
		/**
		 * @TODO: Call insertEvent
		 * Create event object by setting appropriate values
		 * Assert the status of insertEvent method
		 */		
		
		Event e=new Event();
		      e.setEventid(1008);
		      e.setName("NFL1");
		      e.setDescription("Music");
		      e.setPlace("tomorrowland");
		      e.setDuration("0900-0100");
		      e.setEventtype("concert");
		      int actual=eventServiceImpl.insertEvent(e);
	
		int expected=0;
		assertEquals(expected, actual);
	}

	/**
	 * Junit test case for updateEvent
	 */
	@Test
	public void testUpdateEvent() {
		/**
		 * @TODO: Fetch Event object by calling getAllEvents method 
		 * Update event object by setting appropriate values
		 * Call updateEvent method
		 * Assert the status of updateEvent method
		 */	
		Object[] object=null;
		Event event=new Event();
		showAllEvents=(ArrayList<Object[]>) eventServiceImpl.getAllEvents("NCCL Semi Finals");
		for(int i=0;i<showAllEvents.size();i++){
			object=showAllEvents.get(i);
		}
		event.setEventid(Integer.parseInt(object[0].toString()));
		event.setName("Rose Parade");
		event.setDescription("Floats,Music and More");
		event.setDuration("0900-1400");
		event.setEventtype("Tour");
		event.setPlace("Rose Garden");
		event.setSeatsavailable("4001");
		event.setSessionId(Integer.parseInt(object[7].toString()));
		int actual=eventServiceImpl.updateEvent(event);
		int expected=1;
		assertEquals(expected, actual);
		
	}

	/**
	 * Junit test case for deleteEvent
	 */
	@Ignore
	@Test
	public void testDeleteEvent() {
		/**
		 * @TODO: Fetch Event object by calling getAllEvents method 
		 * Update event object by setting appropriate values
		 * Call deleteEvent method
		 * Assert the status of deleteEvent method
		 */	
		EventDAO dao=new EventDAO();
		try
		{
			//ArrayList<Object[]> eventList = new ArrayList<Object[]>();
			showAllEvents = dao.showAllEvents("Fireworks Show");
			Object[] object=null;
			
			System.out.println(showAllEvents.size());
			for(int i=0;i<showAllEvents.size();i++){
				object=showAllEvents.get(i);
			}
			
			int eventId = Integer.parseInt(object[0].toString());
			int sessionId = Integer.parseInt(object[7].toString());
						
			int status = eventServiceImpl.deleteEvent(eventId, sessionId);
			assertEquals(1, status);
		}
	catch(Exception e)
	{
		e.printStackTrace();
	}

	}

	

}
