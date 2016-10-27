package com.udr013.resources;

import com.udr013.domain.Message;
import com.udr013.resources.beans.MessageFilterBean;
import com.udr013.services.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * To get a Jersey resource to work we need at least three annotations
 *
 * @Path identifies the URI path template to which the resource responds
 * @GET, @POST, etc to know which method to use at a certain request
 * @Produce to specify the response type
 * <p>
 * NOTE: The conversion to xml is done bij JAXB which comes with java, however for json we need to "add" an extra lib
 * though it's already added to the pom.xmlby default we just have to uncomment it ;)
 */

@Path("/messages") //jersey will look for this path and expect methods annotated with the various request methods for
// this path
public class MessageResource {

	MessageService messageService = new MessageService();

	@GET// now jersey now knows how to handle a GET request but also needs to know the format it needs to send back
	@Produces(MediaType.APPLICATION_JSON) // So we need the @Produces annotation and specify the MediaType
	public List<Message> getMessages(@BeanParam MessageFilterBean filter) {
		if (filter.getYear() > 0) {
			return messageService.getAllMessagesFromYear(filter.getYear());
		}
		if (filter.getSize() > 0 && filter.getIndex() >= 0) {
			return messageService.getMessagesPaginated(filter.getIndex(), filter.getSize());
		} else {
			return messageService.getAllMessages();
		}
	}

	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long messageId) {
		return messageService.getMessage(messageId);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON) //if only annotated with Consumes it returns  application/xhtml+xml
	public Message AddMessage(Message message) {
		return messageService.addMassage(message);
	}


	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long messageId, Message message) {
		message.setId(messageId);
		return messageService.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId") long messageId) { //void cause nothing to return
		messageService.removeMessage(messageId);
	}


	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}

}



