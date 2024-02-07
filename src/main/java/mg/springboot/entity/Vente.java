package mg.springboot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "vente")
public class Vente {
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "annonce_id",nullable = false,unique = true)
    @NotNull(message = "Annonce obligatoire")
    private Annonce annonce;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "paiement_id")
    @NotNull(message = "Le mode de paiement doit être renseigné")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Paiement paiement;

    @Column(name = "remise")
    private Double remise=0.;

    @ManyToOne
    @JoinColumn(name = "utilisateur_acheteur_id")
    @NotNull(message = "L'acheteur doit être renseigné")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Utilisateur utilisateurAcheteur;

    @Column(name = "prix_vente")
    private Double prixVente;

}