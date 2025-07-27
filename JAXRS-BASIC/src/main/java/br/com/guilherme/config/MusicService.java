package br.com.guilherme.config;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.guilherme.model.Song;
import br.com.guilherme.model.Songs;

@Path("/music")
public class MusicService {
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String loadNames() {
		StringBuilder sb = new StringBuilder("<html><body><h1>Nomes das Músicas</h1><ul></ul>");
		
		Songs.list().stream()
			.forEach(s -> sb.append("<li>").append(s.getName()).append("</li>"));
		
		sb.append("</ul></body></html>");
		
		return sb.toString();
	}
	
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Song> loadSongsAsJson(){
		return Songs.list();
	}
}
