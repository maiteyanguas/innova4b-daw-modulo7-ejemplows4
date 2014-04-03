package innova4b.ejemplows4;

import java.util.ArrayList;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;


@Path("/json/coches")
public class JsonService {
	
	@GET
	@Path("/get")	
	@Produces("application/json")
	public ArrayList<Coche> get(){
		ArrayList<Coche> coches = new ArrayList<Coche>();
		Coche coche = new Coche();
		coche.setMarca("Seat");
		coche.setModelo("Ibiza");
		coche.setMatricula("7455CKP");
		coche.setAnyoCompra(2001);
		coches.add(coche);
		return coches;
	}
	
	@POST
	@Path("/post")
	@Consumes("application/json")
	public Response createCar(Coche coche){
		String result = "Coche creado correctamente: "+coche.toString();
		return Response.status(201).entity(result).build();
	}

}
