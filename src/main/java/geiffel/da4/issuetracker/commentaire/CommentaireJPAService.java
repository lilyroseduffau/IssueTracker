package geiffel.da4.issuetracker.commentaire;

import geiffel.da4.issuetracker.exceptions.ResourceAlreadyExistsException;
import geiffel.da4.issuetracker.exceptions.ResourceNotFoundException;
import geiffel.da4.issuetracker.issue.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Qualifier("jpa")
@Primary
public class CommentaireJPAService implements CommentaireService {

    @Autowired
    private CommentaireRepository commentaireRepository;

    @Override
    public List<Commentaire> getAll() {
        return commentaireRepository.findAll();
    }

    @Override
    public List<Commentaire> getAllByAuthorId(Long id) {
        return null;
    }

    @Override
    public List<Commentaire> getAllByIssueCode(Long code) {
        return null;
    }

    @Override
    public Commentaire getById(Long id) {
        Optional<Commentaire> commentaire = commentaireRepository.findById(id);
        if (commentaire.isPresent()) {
            return commentaire.get();
        } else {
            throw new ResourceNotFoundException("Commentaire", id);
        }
    }

    @Override
    public Commentaire create(Commentaire commentaire) throws ResourceAlreadyExistsException {
        Long id = commentaire.getId();
        if (commentaireRepository.existsById(id))
        {
            throw new ResourceAlreadyExistsException("Commentaire", id);
        }
        else {
            return commentaireRepository.save(commentaire);

        }
    }

    @Override
    public void update(Long id, Commentaire commentaire) throws ResourceNotFoundException {

        if (!commentaireRepository.existsById(id))
        {
            throw new ResourceNotFoundException("Commentaire", id);
        }
        else {
            commentaireRepository.save(commentaire);

        }
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        if (!commentaireRepository.existsById(id))
        {
            throw new ResourceNotFoundException("Commentaire", id);
        }
        else {
            commentaireRepository.deleteById(id);

        }
    }
}