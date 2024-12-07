package com.example.JobProject.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@Entity
@Table (name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    @ToString.Exclude // Исключаем поле password из метода toString
    private String password;

    private boolean status;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @OneToMany(mappedBy = "user")
    private List<NewsSubscription> newsSubscriptions;

    @OneToMany(mappedBy = "user")
    private List<FavoriteCryptocurrency> favoriteCryptocurrencies;


    @OneToOne(mappedBy = "user")
    private CashAccount cashAccount;


    @OneToOne(mappedBy = "user")
    private CryptocurrencyWallet cryptocurrencyWallet;

    @OneToMany(mappedBy = "user")
    private List<CryptocurrencyReport> cryptocurrencyReport;

}
