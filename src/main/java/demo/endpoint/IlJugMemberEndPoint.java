package demo.endpoint;

import javax.inject.Named;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import demo.entity.IlJugMember;
import demo.service.IIlJugMemberService;

@Named
@Path("iljugmembers")
public class IlJugMemberEndPoint {

	@Autowired
	IIlJugMemberService ilJugMemberService;

	@POST
	@Produces({ "application/json" })
	public Response post(@QueryParam("last") String lastName,
			@QueryParam("first") String firstName) {
		IlJugMember ilJugMember = ilJugMemberService.createIlJugMember(
				lastName, firstName);
		return Response.status(Status.CREATED).entity(ilJugMember).build();
	}

	@PUT
	@Path("/{id}")
	public Response put(@PathParam("id") Long id,
			@QueryParam("last") String lastName,
			@QueryParam("first") String firstName) {
		ilJugMemberService.updateIlJugMember(id, lastName, firstName);
		return Response.status(Status.OK).build();
	}

	@GET
	@Path("/{id}")
	@Produces({ "application/json" })
	public IlJugMember getIJugMemberById(@PathParam("id") Long id) {
		return ilJugMemberService.getIlJugMember(id);
	}

	@GET
	@Produces({ "application/json" })
	public Iterable<IlJugMember> getAllIJugMembers() {
		return ilJugMemberService.getAllIlJugMembers();
	}

	@GET
	@Path("/search")
	@Produces({ "application/json" })
	public Iterable<IlJugMember> searchIJugMembersByLastName(
			@QueryParam("last") String lastName) {
		return ilJugMemberService.findIlJugMemberByLastName(lastName);
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id) {
		ilJugMemberService.deleteIlJugMember(id);
		return Response.status(Status.NO_CONTENT).build();
	}

}
