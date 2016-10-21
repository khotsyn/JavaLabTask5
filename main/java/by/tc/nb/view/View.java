package by.tc.nb.view;


import by.tc.nb.bean.*;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.bean.entity.User;
import by.tc.nb.controller.Controller;
import by.tc.nb.dao.impl.pool.ConnectionPool;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class View {
	static final String signIn = "in";
	static final String signUp = "up";
	static final String exit = "exit";
	static final String add = "add";
	static final String clear = "clear";
	static final String findContent = "find";
	static final String findDate = "date";
	static final String show = "show";
	static final String logout = "logout";

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {

			System.out.print(signIn + " ");
			System.out.print(signUp + " ");
			System.out.println(exit);
			Controller controller = new Controller();
			System.out.println("Enter the command");
			String string1 = reader.readLine();
			Response response1;
			switch (string1) {
				case "exit":
					reader.close();
					ConnectionPool.getInstance().closePool();
					return;
				case "up":
					System.out.println("Enter your login:");
					String loginReg = reader.readLine();
					System.out.println("Enter your password:");
					String passwordReg = reader.readLine();
					RegistrationRequest registrationRequest = new RegistrationRequest();
					registrationRequest.setCommandName("REGISTRATION");
					registrationRequest.setLogin(loginReg);
					registrationRequest.setPassword(passwordReg);
					response1 = controller.doRequest(registrationRequest);
					if(response1.isErrorStatus() ==  false){
						System.out.println(response1.getResultMessage());
					}else{
						System.out.println(response1.getErrorMessage());
					}
					break;
				case "in":
					System.out.println("Enter your login:");
					String loginIn = reader.readLine();
					System.out.println("Enter your password:");
					String passwordIn = reader.readLine();
					AuthenticationRequest authenticationRequest = new AuthenticationRequest();
					authenticationRequest.setCommandName("AUTHENTICATION");
					authenticationRequest.setLogin(loginIn);
					authenticationRequest.setPassword(passwordIn);
					response1 = controller.doRequest(authenticationRequest);
					if (!response1.isErrorStatus() == false) {
						System.out.println(response1.getErrorMessage());
					} else {
						AuthenticationResponse resp = (AuthenticationResponse) response1;
						User currentUser = resp.getUser();
						int sessionId = currentUser.getId();
						System.out.println("Hello, " + currentUser.getLogin() + "!");
						while (true) {
							System.out.print(exit + " ");
							System.out.print(add + " ");
							System.out.print(clear + " ");
							System.out.print(findContent + " ");
							System.out.print(findDate + " ");
							System.out.print(show + " ");
							System.out.println(logout);

							System.out.println("Enter the command:");
							String string2 = reader.readLine();
							if (string2.equals(logout)) {
								System.out.println("You have been logout!");
								break;
							}
							Response response2;
							switch (string2) {
								case "exit":
									reader.close();
									ConnectionPool.getInstance().closePool();
									return;
								case "add":
									AddNoteRequest addRequest = new AddNoteRequest();
									System.out.println("Enter your note:");
									String myNote = reader.readLine();
									addRequest.setNote(myNote);
									addRequest.setCommandName("ADD_NEW_NOTE");
									addRequest.setUserId(sessionId);
									response2 = controller.doRequest(addRequest);
									if (response2.isErrorStatus() == false) {
										System.out.println(response2.getErrorMessage());
									} else {
										System.out.println(response2.getResultMessage());
									}
									break;
								case "show":
									ShowAllNotesRequest showRequest = new ShowAllNotesRequest();
									showRequest.setUserId(sessionId);
									showRequest.setCommandName("SHOW_NOTEBOOK");
									response2 = controller.doRequest(showRequest);
									if (response2.isErrorStatus() == false) {
										System.out.println(response2.getErrorMessage());
									} else {
										ShowAllNotesResponse res = (ShowAllNotesResponse) response2;
										List<Note> book = res.getAllBook();
										if (!book.isEmpty()) {
											for (Note note : book) {
												System.out.println(note);
											}
										}
										System.out.println(response2.getResultMessage());
									}
									break;
								case "clear":
									ClearBookRequest clearRequest = new ClearBookRequest();
									System.out.println("Are you sure you want to clear user notes? All notes " +
											"will be lost !!! Y/N");
									String answer = reader.readLine();
									if (!(answer.equals("Y") || answer.equals("y"))) {
										break;
									}
									clearRequest.setUserId(sessionId);
									clearRequest.setCommandName("CLEAR_NOTEBOOK");
									response2 = controller.doRequest(clearRequest);
									if (response2.isErrorStatus() == false) {
										System.out.println(response2.getErrorMessage());
									} else {
										System.out.println(response2.getResultMessage());
									}
									break;
								case "find":
									FindNotesRequest findRequest = new FindNotesRequest();
									System.out.println("Enter the search string:");
									String search = reader.readLine();
									findRequest.setFindString(search);
									findRequest.setUserId(sessionId);
									findRequest.setCommandName("FIND_BY_NOTE");
									response2 = controller.doRequest(findRequest);
									if (response2.isErrorStatus() == false) {
										System.out.println(response2.getErrorMessage());
									} else {
										FindNotesResponse res = (FindNotesResponse) response2;
										List<Note> noteFind = res.getFindBook();
										if (!noteFind.isEmpty()) {
											for (Note note : noteFind) {
												System.out.println(note);
											}
										}
										System.out.println(response2.getResultMessage());
									}
									break;
								case "date":
									FindByDateRequest dateRequest = new FindByDateRequest();
									System.out.println("Enter day! Example 29");
									dateRequest.setDay(reader.readLine());
									System.out.println("Enter month! Example 8");
									dateRequest.setMonth(reader.readLine());
									System.out.println("Enter year! Example 2016");
									dateRequest.setYear(reader.readLine());
									dateRequest.setUserId(sessionId);
									dateRequest.setCommandName("FIND_BY_DATE");
									response2 = controller.doRequest(dateRequest);
									if (response2.isErrorStatus() == false) {
										System.out.println(response2.getErrorMessage());
									} else {
										FindByDateResponse res = (FindByDateResponse) response2;
										List<Note> noteFind = res.getDateNotes();
										if (!noteFind.isEmpty()) {
											for (Note note : noteFind) {
												System.out.println(note);
											}
										}
										System.out.println(response2.getResultMessage());
									}
									break;
								default:
									System.out.println("Incorrect command!");
									break;
							}
						}
					}
					break;
			}
		}
	}
}

