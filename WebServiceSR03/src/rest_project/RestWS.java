package rest_project;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Motorisation;
import sr03.utc.fr.RequestLocal;

@Stateless
@Path("/req")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
public class RestWS
{
	@EJB
	private RequestLocal request;
	
	@GET
	@Path("/colorNames")
    public Response getColorNames()
    {
		return Response.ok(this.request.getColorNames()).build();
    }
	
	@GET
	@Path("/colors")
    public Response getColors()
    {
		return Response.ok(this.request.getColors()).build();
    }
	
	@GET
	@Path("/modeles")
    public Response getModeles()
    {
		return Response.ok(this.request.getModeles()).build();
    }
	
	@GET
	@Path("/finitions")
    public Response getFinitions()
    {
		return Response.ok(this.request.getFinitions()).build();
    }
	
	@GET
	@Path("/finitionsmodele")
    public Response getFinitionsByModel(@QueryParam("mid") Integer mid)
    {
		return Response.ok(this.request.getTypeFinitionByModele(mid)).build();
    }
	
	@GET
	@Path("/motorisationsfinition")
	public Response getMotorisationByFinition(@QueryParam("fid") Integer finitionId)
	{
		return Response.ok(this.request.getMotorisationByFinition(finitionId)).build();
    }
	
	@GET
	@Path("/colorsfinition")
	public Response getColorByFinition(@QueryParam("fid") Integer finitionId)
	{
		return Response.ok(this.request.getColorByFinition(finitionId)).build();
    }

	@GET
	@Path("/typejantesfinition")
	public Response getTypeJanteByFinition(@QueryParam("fid") Integer finitionId)
	{
		return Response.ok(this.request.getTypeJanteByFinition(finitionId)).build();
    }
   
	@GET
	@Path("/optionsupsfinition")
	public Response getOptionSupByFinition(@QueryParam("fid") Integer finitionId)
	{
		return Response.ok(this.request.getOptionSupByFinition(finitionId)).build();
    }
	
	@GET
	@Path("/motorisations")
    public Response getMotorisation()
    {
		return Response.ok(this.request.getMotorisations()).build();
    }
	
	@GET
	@Path("/optionsup")
    public Response getOptionSupForVoiture(@QueryParam("vid") int vid)
    {
		return Response.ok(this.request.getOptionSupForVoiture(vid)).build();
    }
}
