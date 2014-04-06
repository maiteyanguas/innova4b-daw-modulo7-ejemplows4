package innova4b.ejemplows4.RestService;

import innova4b.ejemplows4.Domain.Coche;
import innova4b.ejemplows4.Repository.CocheRepo;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;


@Path("/json/coches")
public class CocheService {
	
	@GET
	@Path("/get")	
	@Produces("application/json")
	public ArrayList<Coche> get(@Context ServletContext servletContext){
		CocheRepo cocherepo = new CocheRepo((Connection)servletContext.getAttribute("DBConnection"));
		return cocherepo.list();
	}

	@GET
	@Path("/get/{id}")	
	@Produces("application/json")
	public Coche get(@PathParam("id") int id, @Context ServletContext servletContext) { 
		CocheRepo cocherepo = new CocheRepo((Connection)servletContext.getAttribute("DBConnection"));
		return cocherepo.get(id);
	}
	
	@POST
	@Path("/post")
	@Consumes("application/json")
	public Response createCar(@Context ServletContext servletContext, Coche coche){
		CocheRepo cocherepo = new CocheRepo((Connection)servletContext.getAttribute("DBConnection"));
		int row = cocherepo.insert(coche);
		if (row==0)
			return Response.status(500).entity("Error al crear el coche").build();
		String result = "Coche creado correctamente: "+coche.toString();
		return Response.status(201).entity(result).build();
	}

}
