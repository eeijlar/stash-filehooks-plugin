package org.christiangalsterer.stash.filehooks.plugin.hook;

import com.atlassian.bitbucket.commit.Commit;
import com.atlassian.bitbucket.content.Change;
import com.atlassian.bitbucket.hook.repository.RepositoryHookDetails;
import com.atlassian.bitbucket.repository.RefChange;
import com.atlassian.bitbucket.repository.Repository;

import java.util.Map;
import java.util.Set;

public interface ChangesetService {
    Iterable<Change> getChanges(RepositoryHookDetails repository, final Iterable<Commit> x);
    Map<Commit, Iterable<Change>> getChanges(final Repository repository, Iterable<Commit> commits);
    Set<Commit> getCommitsBetween(final RepositoryHookDetails repository, Iterable<RefChange> refChanges);
}
