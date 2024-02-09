package mg.springboot.controller;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import mg.springboot.entity.Modele;
import mg.springboot.entity.Pays;
import mg.springboot.security.Response;
import mg.springboot.service.PaysService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Getter
@Setter
public class PaysController {
    PaysService paysService;

    public PaysController(PaysService paysService) {
        this.paysService = paysService;
    }

    @GetMapping({"/admin/pays", "/api/pays"})
    public Response<?> getPays() {
        return Response.send(HttpStatus.OK, "success", paysService.findAll());
    }

    @GetMapping("/admin/pays/{id}")
    public Response<?> getPays(@PathVariable int id) {
        return Response.send(HttpStatus.OK, "success", paysService.findById(id));
    }

    @PostMapping("/admin/pays")
    public Response<?> addPays(@Valid Pays pays) {
        return Response.send(HttpStatus.OK, "success", "Le pays a été ajouté",
                paysService.save(pays));
    }

    @PutMapping("/admin/pays/{id}")
    public Response<?> modifyPays(@PathVariable int id, @Valid Pays pays) {
        return Response.send(HttpStatus.OK, "success", "Le pays a été modifié",
                paysService.modify(id, pays));
    }

    @DeleteMapping("/admin/pays/{id}")
    public Response<?> deletePays(@PathVariable int id) {
        return Response.send(HttpStatus.OK, "success", "Le pays a été supprimé",
                paysService.delete(id));
    }
}
