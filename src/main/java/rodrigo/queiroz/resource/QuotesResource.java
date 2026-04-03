package rodrigo.queiroz.resource;

import java.util.UUID;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import io.smallrye.mutiny.Multi;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import rodrigo.queiroz.model.Quote;

@Path("/quotes")
public class QuotesResource {
    @Channel("quotes-requests") Emitter<String> quoteRequestEmitter;

    @POST
    @Path("/request")
    public String createRequest() {
        UUID uuid = UUID.randomUUID();
        quoteRequestEmitter.send(uuid.toString());
        return uuid.toString();
    }

    @Channel("quotes") Multi<Quote> quotes;

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Multi<Quote> stream(){
        return quotes;
    }
}
