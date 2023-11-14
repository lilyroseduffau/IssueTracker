package geiffel.da4.issuetracker.issue;
import geiffel.da4.issuetracker.exceptions.ResourceAlreadyExistsException;
import geiffel.da4.issuetracker.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Qualifier("jpa")
@Primary
public class IssueJPAService implements IssueService {

    @Autowired
    private IssueRepository issueRepository;

    @Override
    public List<Issue> getAll() {
        return issueRepository.findAll();
    }

    @Override
    public Issue getByCode(Long id) {
        Optional<Issue> issue = issueRepository.findById(id);
        if (issue.isPresent()) {
            return issue.get();
        } else {
            throw new ResourceNotFoundException("Issue", id);
        }
    }

    @Override
    public Issue create(Issue issue) throws ResourceAlreadyExistsException {
        Long id = issue.getCode();
        if (issueRepository.existsById(id))
        {
            throw new ResourceAlreadyExistsException("Issue", id);
        }
        else {
            return issueRepository.save(issue);

        }
    }

    @Override
    public void update(Long id, Issue issue) throws ResourceNotFoundException {

        if (!issueRepository.existsById(id))
        {
            throw new ResourceNotFoundException("Issue", id);
        }
        else {
            issueRepository.save(issue);

        }
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        if (!issueRepository.existsById(id))
        {
            throw new ResourceNotFoundException("Issue", id);
        }
        else {
            issueRepository.deleteById(id);

        }
    }
}
