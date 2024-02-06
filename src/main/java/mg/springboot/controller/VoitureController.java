package mg.springboot.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import mg.springboot.entity.Voiture;
import mg.springboot.security.Response;
import mg.springboot.security.Token;
import mg.springboot.service.TokenService;
import mg.springboot.service.VoitureService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class VoitureController {
    private final VoitureService voitureService;
    private final TokenService tokenService;

    public VoitureController(VoitureService voitureService, TokenService tokenService) {
        this.voitureService = voitureService;
        this.tokenService = tokenService;
    }

    @GetMapping("/admin/voitures")
    public Response<?> getVoitures() {
        return Response.send(HttpStatus.OK, "success", voitureService.findAll());
    }

    @GetMapping({"/admin/voitures/{id}", "/api/voitures/{id}"})
    public Response<?> getVoiture(@PathVariable int id) {
        return Response.send(HttpStatus.OK, "success", voitureService.findById(id));
    }

    @PutMapping("/admin/voitures/{id}")
    public Response<?> modifyVoiture(@PathVariable int id, @Valid Voiture voiture) {
        return Response.send(HttpStatus.OK, "success", "La voiture a été modifiée",
                voitureService.modify(id, voiture));
    }

    @PostMapping("/admin/voitures")
    public Response<?> addVoiture(@Valid Voiture voiture) {
        return Response.send(HttpStatus.OK, "success", "La voiture a été ajoutée",
                voitureService.save(voiture));
    }
    @DeleteMapping("/admin/voitures/{id}")
    public Response<?> deleteVoiture(@PathVariable int id) {
        return Response.send(HttpStatus.OK, "success", "La voiture a été supprimée",
                voitureService.delete(id));
    }
}
