package restWs;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.service.dao.NoteDao;
@Path("/verification")
public class Verification {
	
	@GET
	@Path("/candidature")
	@Produces(MediaType.TEXT_PLAIN)
	public String ServiceMessage(@QueryParam("cin") String cin, @QueryParam("num") String num) {
		NoteDao notedao = new NoteDao();
		boolean admis = notedao.verificationNote(cin,num);
		
		if (admis) {
			return "Admis";
		} else {
			return "Non Admis";
		}
		
	}

	

}
