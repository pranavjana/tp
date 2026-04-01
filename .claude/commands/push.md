---
description: Push code using the SpendTrack forking workflow (sync, commit, push, PR)
allowed-tools: Bash(git:*), Bash(gh:*)
---

You are helping the user push their code using the SpendTrack team's forking workflow. Follow these rules strictly:

## Remotes
- `origin` = the user's personal fork
- `upstream` = the team repo (`AY2526S2-CS2113-T11-1/tp`)

## Pre-flight checks
1. Run `git remote -v` to confirm both `origin` and `upstream` exist.
2. Run `git branch --show-current` to confirm the user is NOT on `master`. If they are on master, STOP and tell them to create a feature branch first (`git checkout -b feature/<name>`).
3. Run `git status` to see what's changed.

## Sync with upstream before pushing
```
git fetch upstream master
git merge upstream/master
```
If there are merge conflicts, stop and help the user resolve them before continuing.

## Stage and commit
- Show the user what files have changed (`git status`).
- Stage only the relevant files — never use `git add .` or `git add -A` blindly.
- Ask the user to confirm what to stage if unclear.
- Use conventional commit prefixes: `feat:`, `fix:`, `docs:`, `test:`, `refactor:`
- Commit message should be concise and descriptive.

## Push
Push to the user's fork (origin), not upstream:
```
git push origin <current-branch>
```

## After pushing — remind the user
Print this checklist:
- [ ] Open a PR from `origin/<branch>` → `AY2526S2-CS2113-T11-1/tp:master`
- [ ] PR title matches the issue title
- [ ] PR body contains `Fixes #<issue-number>`
- [ ] PR milestone set to the current version (e.g. `v1.0`)
- [ ] Reviewer requested (pick a teammate)
- [ ] Issue has `type.*` and `priority.*` labels

## After a PR is merged — sync reminder
Remind the user to sync their fork:
```
git checkout master
git pull upstream master
git push origin master
```

## Rules
- NEVER push directly to upstream.
- NEVER work on master — always use a feature branch.
- NEVER squash or rebase when merging PRs (use merge commits).
- NEVER delete branches after merging.
- Always commit with clear, prefixed messages.
