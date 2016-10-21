package by.tc.nb.service;

import by.tc.nb.service.impl.NoteBookServiceImpl;
import by.tc.nb.service.impl.UserService;
import by.tc.nb.service.impl.UserServiceImpl;

public class ServiceFactory {

	private static final ServiceFactory instance = new ServiceFactory();
	private NoteBookService nbService = new NoteBookServiceImpl();
	private final UserService userService = new UserServiceImpl();

	public static ServiceFactory getInstance(){
		return instance;
	}
	
	public NoteBookService getNoteBookService(){
		return nbService;
	}

	public UserService getUserService() {
		return userService;
	}

}
