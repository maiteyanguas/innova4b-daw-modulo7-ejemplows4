package innova4b.ejemplows4;

import java.util.ArrayList;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;


@Path("/json/coches")
public class JsonService {
	
	ArrayList<Coche> coches = new ArrayList<Coche>();
	
	void addDefaultCar(){
		Coche coche = new Coche();
		coche.setMarca("Seat");
		coche.setModelo("Ibiza");
		coche.setMatricula("7455CKP");
		coche.setAnyoCompra(2001);
		coches.add(coche);
	}
	
	@GET
	@Path("/get")	
	@Produces("application/json")
	public ArrayList<Coche> get(){
		if (coches.isEmpty())
			addDefaultCar();
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
