package app.ressources;

import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/public")
public class PublicRessource {

    @GET
    @PermitAll
    @Produces(MediaType.TEXT_PLAIN)
    public String publicRessource(){
        return "JBL LE BOSS(chetar)";
    }




}
