package lab.smk.models.journals;

import sun.util.resources.LocaleData;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String version;
    private String hash;
    private LocalDate dateAdded;
    private String userAdded;

    public Program(String name, String version, String hash, LocalDate dateAdded, String userAdded) {
        this.name = name;
        this.version = version;
        this.hash = hash;
        this.dateAdded = dateAdded;
        this.userAdded = userAdded;
    }

    public Program() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getUserAdded() {
        return userAdded;
    }

    public void setUserAdded(String userAdded) {
        this.userAdded = userAdded;
    }
}
