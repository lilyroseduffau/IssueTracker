package geiffel.da4.issuetracker.commentaire;

import geiffel.da4.issuetracker.issue.Issue;
import geiffel.da4.issuetracker.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Commentaire {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private User author;
    @ManyToOne
    @JoinColumn(referencedColumnName = "code")
    private Issue issue;
    private String contenu;

    public Commentaire(Long id, User author, Issue issue, String contenu) {
        this.id = id;
        this.author = author;
        this.issue = issue;
        this.contenu = contenu;
    }

    public Commentaire() {
    }

    public Long getAuthorId(){
        return this.author.getId();
    }
    public Long getIssueCode() {
        return this.issue.getCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }


}
